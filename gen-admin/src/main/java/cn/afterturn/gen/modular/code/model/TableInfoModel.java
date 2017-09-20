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
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
@TableName("t_code_table_head")
public class TableInfoModel extends Model<TableInfoModel> {

    private static final long serialVersionUID = 1L;


    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 表名
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * ClassName
     */
    @TableField(value = "class_name")
    private String className;

    /**
     * 表名称
     */
    @TableField(value = "content")
    private String content;

    /**
     * 是否导入Excel
     */
    @TableField(value = "is_import")
    private Integer isImport;

    /**
     * 是否导出Excel
     */
    @TableField(value = "is_export")
    private Integer isExport;

    /**
     * 是否分页
     */
    @TableField(value = "is_pagination")
    private Integer isPagination;

    /**
     * 是否添加日志
     */
    @TableField(value = "is_log")
    private Integer isLog;

    /**
     * 是否添加协议
     */
    @TableField(value = "is_protocol")
    private Integer isProtocol;

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
    public String getId() {
        return id;
    }

    /**
     * 设置: Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取: 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置: 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取: ClassName
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置: ClassName
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取: 表名称
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置: 表名称
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取: 是否导入Excel
     */
    public Integer getIsImport() {
        return isImport;
    }

    /**
     * 设置: 是否导入Excel
     */
    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }

    /**
     * 获取: 是否导出Excel
     */
    public Integer getIsExport() {
        return isExport;
    }

    /**
     * 设置: 是否导出Excel
     */
    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    /**
     * 获取: 是否分页
     */
    public Integer getIsPagination() {
        return isPagination;
    }

    /**
     * 设置: 是否分页
     */
    public void setIsPagination(Integer isPagination) {
        this.isPagination = isPagination;
    }

    /**
     * 获取: 是否添加日志
     */
    public Integer getIsLog() {
        return isLog;
    }

    /**
     * 设置: 是否添加日志
     */
    public void setIsLog(Integer isLog) {
        this.isLog = isLog;
    }

    /**
     * 获取: 是否添加协议
     */
    public Integer getIsProtocol() {
        return isProtocol;
    }

    /**
     * 设置: 是否添加协议
     */
    public void setIsProtocol(Integer isProtocol) {
        this.isProtocol = isProtocol;
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
