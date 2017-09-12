package cn.afterturn.gen.modular.code.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 模板管理
 *
 * @author JueYue
 * @Date 2017-09-11 11:22
 */
@TableName("t_system_template")
public class TemplateModel extends Model<TemplateModel> {

    private static final long serialVersionUID = 1L;


    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模板名称
     */
    @TableField(value = "TEMPLATE_NAME")
    private String templateName;

    /**
     * 模板地址
     */
    @TableField(value = "TEMPLATE_path")
    private String templatePath;

    /**
     * UserId
     */
    @TableField(value = "USER_ID")
    private String userId;

    /**
     * TemplateDesc
     */
    @TableField(value = "TEMPLATE_DESC")
    private String templateDesc;

    /**
     * 文件名称
     */
    @TableField(value = "FILE_NAME")
    private String fileName;

    /**
     * 创建人
     */
    @TableField(value = "CRT_USER_ID")
    private String crtUserId;

    /**
     * 创建时间
     */
    @TableField(value = "CRT_TIME")
    private Date crtTime;

    /**
     * 修改人
     */
    @TableField(value = "MDF_USER_ID")
    private String mdfUserId;

    /**
     * 修改时间
     */
    @TableField(value = "MDF_TIME")
    private Date mdfTime;

    /**
     * 模板类型
     */
    @TableField(value = "TEMPLATE_TYPE")
    private String templateType;


    /**
     * 获取: Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置: Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取: 模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置: 模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 获取: 模板地址
     */
    public String getTemplatePath() {
        return templatePath;
    }

    /**
     * 设置: 模板地址
     */
    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    /**
     * 获取: UserId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置: UserId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取: TemplateDesc
     */
    public String getTemplateDesc() {
        return templateDesc;
    }

    /**
     * 设置: TemplateDesc
     */
    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    /**
     * 获取: 文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置: 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取: 创建人
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 设置: 创建人
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /**
     * 获取: 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置: 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取: 修改人
     */
    public String getMdfUserId() {
        return mdfUserId;
    }

    /**
     * 设置: 修改人
     */
    public void setMdfUserId(String mdfUserId) {
        this.mdfUserId = mdfUserId;
    }

    /**
     * 获取: 修改时间
     */
    public Date getMdfTime() {
        return mdfTime;
    }

    /**
     * 设置: 修改时间
     */
    public void setMdfTime(Date mdfTime) {
        this.mdfTime = mdfTime;
    }

    /**
     * 获取: 模板类型
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 设置: 模板类型
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
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
