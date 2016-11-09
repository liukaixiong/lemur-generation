package cn.afterturn.generation.db.read;

import java.util.List;

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
    /**
     * 查询所有的库
     * @return
     */
    public List<String> getAllDB();
    /**
     * 查询所有的表
     * @return
     */
    public List<String> getAllTable(String dbName);
    
    

}
