/**
 * 代码归 Green Dragon Team 所有,任何公司和个人不得擅自使用, 我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package cn.afterturn.gen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.afterturn.common.model.RequestModel;
import cn.afterturn.common.model.ResponseModel;
import cn.afterturn.gen.model.DbInfoEntity;
import cn.afterturn.gen.service.IDbInfoService;

import com.github.pagehelper.PageInfo;

/**
 *  服务
 * @author JueYue
 * @date 2017-03-14 19:28
 * @version V1.0  
 */
@Controller
@RestController("dbinfo")
public class DbInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbInfoController.class);

    @Autowired
    private IDbInfoService      dbInfoService;

    @RequestMapping(params = "list", method = RequestMethod.POST)
    public ResponseModel DbInfoList(DbInfoEntity entity, RequestModel form) {
        PageInfo<DbInfoEntity> list = dbInfoService.getDbInfoPage(entity, form.getPage(),
            form.getPageSize());
        return ResponseModel.ins(list);
    }

    /**
     * 
     *  新增
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseModel saveDbInfo(String agentId,
                                    @RequestBody(required = false) DbInfoEntity entity) {
        return ResponseModel.ins(dbInfoService.addDbInfo(entity));
    }

    /**
     * 
     *  修改
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseModel updateDbInfo(String agentId,
                                      @RequestBody(required = false) DbInfoEntity entity) {
        return ResponseModel.ins(dbInfoService.updateDbInfo(entity));
    }

    /**
     * 
     *  删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ResponseModel deleteDbInfo(String agentId, DbInfoEntity entity) {
        return ResponseModel.ins(dbInfoService.deteleDbInfo(entity));
    }
}
