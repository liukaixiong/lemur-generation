/**
 * 代码归 Green Dragon Team 所有,任何公司和个人不得擅自使用, 我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package cn.afterturn.gen.service;

import com.github.pagehelper.PageInfo;

import cn.afterturn.gen.model.DbInfoEntity;


/**
 *  服务
 * @author JueYue
 * @date 2017-03-14 19:28
 * @version V1.0  
 */
public interface IDbInfoService {
    /**
     * 分页查询 
     * @param entity
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<DbInfoEntity> getDbInfoPage(DbInfoEntity entity, int page, int pageSize);

    /**
     * 新增 
     * @param entity
     * @return
     */
    public boolean addDbInfo(DbInfoEntity entity);

    /**
     * 修改 
     * @param entity
     * @return
     */
    public boolean updateDbInfo(DbInfoEntity entity);

    /**
     * 删除 
     * @param entity
     * @return
     */
    public boolean deteleDbInfo(DbInfoEntity entity);

}
