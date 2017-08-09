/**
 * Copyright 2013-2017 JueYue (qrb.jueyue@gmail.com)
 *   
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.afterturn.gen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.afterturn.common.model.BaseModel;
import cn.afterturn.common.model.RequestModel;
import cn.afterturn.common.model.ResponseModel;
import cn.afterturn.gen.core.CodeGenModel;
import cn.afterturn.gen.core.CodeGenUtil;
import cn.afterturn.gen.core.GenCoreConstant;
import cn.afterturn.gen.core.db.read.IReadTable;
import cn.afterturn.gen.core.db.read.ReadTableFactory;
import cn.afterturn.gen.core.util.NameUtil;
import cn.afterturn.common.util.ConnectionUtil;
import cn.afterturn.gen.model.DbInfoEntity;
import cn.afterturn.gen.model.TemplateEntity;
import cn.afterturn.gen.model.base.GenerationEntity;
import cn.afterturn.gen.service.IGenService;
import cn.afterturn.gen.service.ITemplateService;

/**
 * 
 * @author JueYue
 * 2017年4月22日
 */
@Controller
@RequestMapping("gen")
public class GenController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenController.class);
    
    @Autowired
    private IGenService         genService;
    @Autowired
    private ITemplateService    templateService;

    @RequestMapping(value = "queryDatabses")
    @ResponseBody
    public ResponseModel queryDatabses(DbInfoEntity entity, RequestModel form) {
        try {
            ConnectionUtil.init(entity.getDbDriver(), entity.getDbUrl(), entity.getDbUserName(),
                entity.getDbPassword());
            IReadTable readTable = ReadTableFactory.getReadTable(entity.getDbType());
            List<String> list = readTable.getAllDB();
            List<BaseModel> dblist = new ArrayList<>();
            BaseModel info;
            for (String db : list) {
                info = new BaseModel(db);
                dblist.add(info);
            }
            return ResponseModel.ins(new PageInfo<>(dblist));
        } finally {
            ConnectionUtil.close();
        }
    }

    @RequestMapping(value = "queryTables")
    @ResponseBody
    public ResponseModel queryTables(DbInfoEntity entity, String dbName, RequestModel form) {
        try {
            ConnectionUtil.init(entity.getDbDriver(), entity.getDbUrl(), entity.getDbUserName(),
                entity.getDbPassword());
            IReadTable readTable = ReadTableFactory.getReadTable(entity.getDbType());
            return ResponseModel.ins(new PageInfo<>(readTable.getAllTable(dbName)));
        } finally {
            ConnectionUtil.close();
        }
    }

    @RequestMapping(value = "genCode")
    public void genCode(DbInfoEntity entity, String dbName, String tableName, GenerationEntity ge,
                        HttpServletRequest req, HttpServletResponse res) {
        String[] templates = req.getParameterValues("templates[]");
        CodeGenModel model = new CodeGenModel();
        model.setDbType(GenCoreConstant.MYSQL);
        model.setTableName(tableName);
        model.setDbName(dbName);
        model.setUrl(entity.getDbUrl());
        model.setPasswd(entity.getDbPassword());
        model.setUsername(entity.getDbUserName());
        if (StringUtils.isEmpty(ge.getEntityName())) {
            ge.setEntityName(NameUtil.getEntityHumpName(dbName));
        }
        model.setGenerationEntity(ge);
        List<TemplateEntity> templateList = templateService.getTemplateByIds(templates);
        List<String> templateFileList = genService.loadTemplateFile(templateList);
        List<String> fileList = new ArrayList<>();
        for (int i = 0; i < templateList.size(); i++) {
            model.setParseType(templateList.get(i).getTemplateType());
            model.setFile(templateFileList.get(i));
            fileList.addAll(CodeGenUtil.codeGen(model));
        }
        downThisFileList(res, fileList, templateList, ge);
    }

    private void downThisFileList(HttpServletResponse res, List<String> fileList, List<TemplateEntity> templateList, GenerationEntity ge) {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(res.getOutputStream());
            for (int i = 0; i < fileList.size(); i++) {
                if(templateList.get(i).getFileName().endsWith("js") || templateList.get(i).getFileName().endsWith("html")){
                    out.putNextEntry(new ZipEntry(String.format(templateList.get(i).getFileName(), ge.getEntityName().toLowerCase())));
                }else{
                    out.putNextEntry(new ZipEntry(String.format(templateList.get(i).getFileName(), ge.getEntityName())));
                }
                out.write(fileList.get(i).getBytes(), 0, fileList.get(i).getBytes().length);
                out.closeEntry();
            }
            res.setContentType("application/octet-stream");
            res.setHeader("Content-Disposition", "attachment;filename=" + "code.zip");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                out.close();
                res.getOutputStream().flush();
                res.getOutputStream().close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
    

}
