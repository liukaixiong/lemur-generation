/**
 * 代码归 Green Dragon Team 所有,任何公司和个人不得擅自使用, 我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package cn.afterturn.gen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.afterturn.gen.model.DbInfoEntity;
import cn.afterturn.gen.repository.DbInfoRepository;
import cn.afterturn.gen.service.IDbInfoService;

/**
 *  服务
 * @author JueYue
 * @date 2017-03-14 19:28
 * @version V1.0  
 **/
@Service("dbInfoService")
public class DbInfoServiceImpl implements IDbInfoService {

    @Autowired
    private DbInfoRepository dbInfoRepository;

    @Override
    public PageInfo<DbInfoEntity> getDbInfoPage(DbInfoEntity DbInfo, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<DbInfoEntity>(dbInfoRepository.select(DbInfo));
    }

    @Override
    public boolean addDbInfo(DbInfoEntity entity) {
        return dbInfoRepository.insertSelective(entity) > 0;
    }

    @Override
    public boolean updateDbInfo(DbInfoEntity entity) {
        return dbInfoRepository.updateByPrimaryKey(entity) > 0;
    }

    @Override
    public boolean deteleDbInfo(DbInfoEntity entity) {
        return dbInfoRepository.deleteByPrimaryKey(entity.getId()) > 0;
    }

}
