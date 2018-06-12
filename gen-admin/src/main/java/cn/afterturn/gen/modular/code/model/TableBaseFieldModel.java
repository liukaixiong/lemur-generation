package cn.afterturn.gen.modular.code.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础字段
 *
 * @author 
 * @Date 
 */
@TableName("t_code_table_base_field")
public class TableBaseFieldModel extends Model<TableBaseFieldModel> {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     * 
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 用户
     * 
     */
    @TableField(value="user_id")
    private Integer userId;
    /**
     * 别名
     * 
     */
    @TableField(value="alias")
    private String alias;
    /**
     * 字段ID
     * 
     */
    @TableField(value="field_id")
    private Integer fieldId;
    /**
     * 创建人
     * 
     */
    @TableField(value="CRT_USER_ID")
    private Integer crtUserId;
    /**
     * 创建时间
     * 
     */
    @TableField(value="CRT_TIME")
    private Date crtTime;
    /**
     * 修改人
     * 
     */
    @TableField(value="MDF_USER_ID")
    private Integer mdfUserId;
    /**
     * 修改时间
     * 
     */
    @TableField(value="MDF_TIME")
    private Date mdfTime;
    /**
     * 获取: 主键
     * 
     */
    public Integer getId() {
    return id;
    }
    /**
     * 设置: 主键
     * 
     */
    public void setId(Integer id) {
    this.id = id;
    }
    /**
     * 获取: 用户
     * 
     */
    public Integer getUserId() {
    return userId;
    }
    /**
     * 设置: 用户
     * 
     */
    public void setUserId(Integer userId) {
    this.userId = userId;
    }
    /**
     * 获取: 别名
     * 
     */
    public String getAlias() {
    return alias;
    }
    /**
     * 设置: 别名
     * 
     */
    public void setAlias(String alias) {
    this.alias = alias;
    }
    /**
     * 获取: 字段ID
     * 
     */
    public Integer getFieldId() {
    return fieldId;
    }
    /**
     * 设置: 字段ID
     * 
     */
    public void setFieldId(Integer fieldId) {
    this.fieldId = fieldId;
    }
    /**
     * 获取: 创建人
     * 
     */
    public Integer getCrtUserId() {
    return crtUserId;
    }
    /**
     * 设置: 创建人
     * 
     */
    public void setCrtUserId(Integer crtUserId) {
    this.crtUserId = crtUserId;
    }
    /**
     * 获取: 创建时间
     * 
     */
    public Date getCrtTime() {
    return crtTime;
    }
    /**
     * 设置: 创建时间
     * 
     */
    public void setCrtTime(Date crtTime) {
    this.crtTime = crtTime;
    }
    /**
     * 获取: 修改人
     * 
     */
    public Integer getMdfUserId() {
    return mdfUserId;
    }
    /**
     * 设置: 修改人
     * 
     */
    public void setMdfUserId(Integer mdfUserId) {
    this.mdfUserId = mdfUserId;
    }
    /**
     * 获取: 修改时间
     * 
     */
    public Date getMdfTime() {
    return mdfTime;
    }
    /**
     * 设置: 修改时间
     * 
     */
    public void setMdfTime(Date mdfTime) {
    this.mdfTime = mdfTime;
    }

    @Override
    protected Serializable pkVal() {
    return this.id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
