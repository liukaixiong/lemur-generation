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
 * 生成参数
 *
 * @author JueYue
 * @Date 2017-09-13 09:18
 */
@TableName("t_code_gen_params")
public class GenParamModel extends Model<GenParamModel> {

    private static final long serialVersionUID = 1L;


    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 别名
     */
    @TableField(value = "alias")
    private String alias;
    /**
     * 作者
     */
    @TableField(value = "author")
    private String author;
    /**
     * 拥有人
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * code 包
     */
    @TableField(value = "code_package")
    private String codePackage;

    /**
     * js 目录
     */
    @TableField(value = "js_package")
    private String jsPackage;

    /**
     * html 目录
     */
    @TableField(value = "html_package")
    private String htmlPackage;

    /**
     * 创建人
     */
    @TableField(value = "CRT_USER_ID")
    private Integer crtUserId;

    /**
     * 创建时间
     */
    @TableField(value = "CRT_TIME")
    private Date crtTime;

    /**
     * 修改人
     */
    @TableField(value = "MDF_USER_ID")
    private Integer mdfUserId;

    /**
     * 修改时间
     */
    @TableField(value = "MDF_TIME")
    private Date mdfTime;


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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取: 作者
     */
    public String getAuthor() {
        return author;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 设置: 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取: code 包
     */
    public String getCodePackage() {
        return codePackage;
    }

    /**
     * 设置: code 包
     */
    public void setCodePackage(String codePackage) {
        this.codePackage = codePackage;
    }

    /**
     * 获取: js 目录
     */
    public String getJsPackage() {
        return jsPackage;
    }

    /**
     * 设置: js 目录
     */
    public void setJsPackage(String jsPackage) {
        this.jsPackage = jsPackage;
    }

    /**
     * 获取: html 目录
     */
    public String getHtmlPackage() {
        return htmlPackage;
    }

    /**
     * 设置: html 目录
     */
    public void setHtmlPackage(String htmlPackage) {
        this.htmlPackage = htmlPackage;
    }

    /**
     * 获取: 创建人
     */
    public Integer getCrtUserId() {
        return crtUserId;
    }

    /**
     * 设置: 创建人
     */
    public void setCrtUserId(Integer crtUserId) {
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
    public Integer getMdfUserId() {
        return mdfUserId;
    }

    /**
     * 设置: 修改人
     */
    public void setMdfUserId(Integer mdfUserId) {
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
