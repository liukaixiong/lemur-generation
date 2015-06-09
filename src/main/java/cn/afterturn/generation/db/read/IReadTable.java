package cn.afterturn.generation.db.read;

import cn.afterturn.generation.base.GenBeanEntity;

/**
 * 读取数据库表,获取数据库表的属性
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public interface IReadTable {
    /**
     * 读取数据库表格属性
     * 
     * @param tableName
     * @return
     */
    public GenBeanEntity read(String tableName);

}
