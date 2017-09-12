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
 * 表信息管理
 *
 * @author JueYue
 * @Date 2017-09-11 11:32
 */
@TableName("t_system_table_head")
public class TableInfoModel extends Model<TableInfoModel> {

    private static final long serialVersionUID = 1L;


    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 表名称
     */
    @TableField(value = "content")
    private String content;

    /**
     * CreateBy
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * CreateDate
     */
    @TableField(value = "create_date")
    private Date createDate;

    /**
     * 是否分页
     */
    @TableField(value = "is_pagination")
    private String isPagination;

    /**
     * 是否带出Excel
     */
    @TableField(value = "is_export")
    private String isExport;

    /**
     * 表名
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * UpdateBy
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * UpdateDate
     */
    @TableField(value = "update_date")
    private Date updateDate;


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
     * 获取: CreateBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置: CreateBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取: CreateDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置: CreateDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取: 是否分页
     */
    public String getIsPagination() {
        return isPagination;
    }

    /**
     * 设置: 是否分页
     */
    public void setIsPagination(String isPagination) {
        this.isPagination = isPagination;
    }

    /**
     * 获取: 是否带出Excel
     */
    public String getIsExport() {
        return isExport;
    }

    /**
     * 设置: 是否带出Excel
     */
    public void setIsExport(String isExport) {
        this.isExport = isExport;
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
     * 获取: UpdateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置: UpdateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取: UpdateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置: UpdateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
