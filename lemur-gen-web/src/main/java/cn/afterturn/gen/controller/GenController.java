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

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.afterturn.common.model.BaseModel;
import cn.afterturn.common.model.RequestModel;
import cn.afterturn.common.model.ResponseModel;
import cn.afterturn.gen.core.db.read.IReadTable;
import cn.afterturn.gen.core.db.read.ReadTableFactory;
import cn.afterturn.gen.core.util.ConnectionUtil;
import cn.afterturn.gen.model.DbInfoEntity;

/**
 * 
 * @author JueYue
 * 2017年4月22日
 */
@RestController
@RequestMapping("gen")
public class GenController {

    @RequestMapping(value = "queryDatabses")
    public ResponseModel queryDatabses(DbInfoEntity entity, RequestModel form) {
        try {
            ConnectionUtil.init(entity.getDbDriver(), entity.getDbUrl(), entity.getDbUserName(),
                entity.getDbPassword());
            IReadTable readTable = ReadTableFactory.getReadTable(entity.getDbType());
            List<String>  list = readTable.getAllDB();
            List<BaseModel>  dblist = new ArrayList<>();
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

}
