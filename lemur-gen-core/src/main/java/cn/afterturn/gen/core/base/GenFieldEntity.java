package cn.afterturn.gen.core.base;

import java.io.Serializable;

/**
 * 数据库表字段属性
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public class GenFieldEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库字段名称
     */
    private String            fieldName;
    /**
     * 字段名称
     */
    private String            name;
    /**
     * 字段中文名称
     */
    private String            chinaName;
    /**
     * 数据库字段注释
     */
    private String            comment;
    /**
     * 数据库字段类型
     */
    private String            fieldType;
    /**
     * 字段类型
     */
    private String            type;
    /**
     * 字符串允许输入最大长度
     */
    private String            charmaxLength;
    /**
     * 精度
     **/
    private String            precision;
    /**
     * 小数点
     **/
    private String            scale;
    /**
     * 是否允许为空 Y/N
     **/
    private String            nullable;
    /**
     * 对象
     */
    private GenBeanEntity     bean;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharmaxLength() {
        return charmaxLength;
    }

    public void setCharmaxLength(String charmaxLength) {
        this.charmaxLength = charmaxLength;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    public GenBeanEntity getBean() {
        return bean;
    }

    public void setBean(GenBeanEntity bean) {
        this.bean = bean;
    }

}
