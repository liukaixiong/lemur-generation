package cn.afterturn.gen.model.base;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库表属性
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public class GenBeanEntity implements Serializable {

    private static final long    serialVersionUID = 1L;
    /**
     * 表名
     */
    private String               tableName;
    /**
     * Java 表名
     */
    private String               name;
    /**
     * 中文名称
     */
    private String               chinaName;
    /**
     * 注释
     */
    private String               comment;
    /**
     * 表字段
     */
    private List<GenFieldEntity> fields;

    public List<GenFieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<GenFieldEntity> fields) {
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

}
