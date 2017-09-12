package cn.afterturn.gen.core.model;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

import cn.afterturn.gen.core.model.enmus.GenerationType;


/**
 * 主键的参数
 *
 * @author JueYue
 * @date 2014年12月25日
 */
public class GenerationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Java包名
     */
    private String javaPackage = "cn.afterturn.code";
    /**
     * JSP包名,如果为空,使用javaPackage
     */
    private String jspPackage = "cn.afterturn.code";
    /**
     * 功能名称
     */
    private String name;
    /**
     * 数据库表明
     */
    private String tableName;
    /**
     * 主键名称
     */
    private String idName = "id";
    /**
     * 主键类型
     */
    private GenerationType idType = GenerationType.IDENTITY;
    /**
     * 类名,不填使用表名
     */
    private String entityName = "Lemru";
    /**
     * 包名,不填使用表名,小写
     */
    private String packageName = "lemru";
    /**
     * 生成时间
     **/
    private String date;
    /**
     * 作者
     **/
    private String author;

    public String getJavaPackage() {
        return javaPackage;
    }

    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    public String getJspPackage() {
        return StringUtils.isNotEmpty(jspPackage) ? jspPackage : javaPackage;
    }

    public void setJspPackage(String jspPackage) {
        this.jspPackage = jspPackage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public GenerationType getIdType() {
        return idType;
    }

    public void setIdType(GenerationType idType) {
        this.idType = idType;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getPackageName() {
        return packageName == null ? null : packageName.toLowerCase();
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
