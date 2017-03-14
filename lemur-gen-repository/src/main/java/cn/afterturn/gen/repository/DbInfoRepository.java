/**
 * 代码归 Green Dragon Team 所有,任何公司和个人不得擅自使用, 我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package cn.afterturn.gen.repository;


import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;

import cn.afterturn.gen.model.DbInfoEntity;

/**   
 * @Description:  
 * @author JueYue
 * @date 2017-03-14 19:28
 * @version V1.0   
 */
@Repository("dbInfoRepository")
public interface DbInfoRepository extends Mapper<DbInfoEntity> {

}