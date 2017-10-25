package cn.afterturn.gen.core.db.convert.sql;

import cn.afterturn.gen.core.model.GenBeanEntity;

/**
 * @author JueYue on 2017/10/25.
 */
public interface ISqlConvert {

    /**
     * 解析SQL
     */
    public GenBeanEntity parseSql(String sql);
}
