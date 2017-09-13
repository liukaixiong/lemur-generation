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
 * 表字段信息
 *
 * @author JueYue
 * @Date 2017-09-11 11:36
 */
@TableName("t_code_table_field")
public class TableFieldInfoModel extends Model<TableFieldInfoModel> {

    private static final long serialVersionUID = 1L;


    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 名称
     */
    @TableField(value = "content")
    private String content;

    /**
     * DictField
     */
    @TableField(value = "dict_field")
    private String dictField;

    /**
     * DictTable
     */
    @TableField(value = "dict_table")
    private String dictTable;

    /**
     * DictText
     */
    @TableField(value = "dict_text")
    private String dictText;

    /**
     * FieldDefault
     */
    @TableField(value = "field_default")
    private String fieldDefault;

    /**
     * FieldHref
     */
    @TableField(value = "field_href")
    private String fieldHref;

    /**
     * FieldLength
     */
    @TableField(value = "field_length")
    private Integer fieldLength;

    /**
     * FieldName
     */
    @TableField(value = "field_name")
    private String fieldName;

    /**
     * FieldValidType
     */
    @TableField(value = "field_valid_type")
    private String fieldValidType;

    /**
     * 是否主键
     */
    @TableField(value = "is_key")
    private String isKey;

    /**
     * IsNull
     */
    @TableField(value = "is_null")
    private String isNull;

    /**
     * 是否查询
     */
    @TableField(value = "is_query")
    private String isQuery;

    /**
     * 是否显示
     */
    @TableField(value = "is_show")
    private String isShow;

    /**
     * 显示枚举(逗号分隔)
     */
    @TableField(value = "is_show_list")
    private String isShowList;

    /**
     * Length
     */
    @TableField(value = "length")
    private Integer length;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * PointLength
     */
    @TableField(value = "point_length")
    private Integer pointLength;

    /**
     * 查询类型
     */
    @TableField(value = "query_mode")
    private String queryMode;

    /**
     * 显示类型
     */
    @TableField(value = "show_type")
    private String showType;

    /**
     * Type
     */
    @TableField(value = "type")
    private String type;

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
     * UpdateName
     */
    @TableField(value = "update_name")
    private String updateName;

    /**
     * 关联表ID
     */
    @TableField(value = "table_id")
    private String tableId;


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
     * 获取: 名称
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置: 名称
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取: DictField
     */
    public String getDictField() {
        return dictField;
    }

    /**
     * 设置: DictField
     */
    public void setDictField(String dictField) {
        this.dictField = dictField;
    }

    /**
     * 获取: DictTable
     */
    public String getDictTable() {
        return dictTable;
    }

    /**
     * 设置: DictTable
     */
    public void setDictTable(String dictTable) {
        this.dictTable = dictTable;
    }

    /**
     * 获取: DictText
     */
    public String getDictText() {
        return dictText;
    }

    /**
     * 设置: DictText
     */
    public void setDictText(String dictText) {
        this.dictText = dictText;
    }

    /**
     * 获取: FieldDefault
     */
    public String getFieldDefault() {
        return fieldDefault;
    }

    /**
     * 设置: FieldDefault
     */
    public void setFieldDefault(String fieldDefault) {
        this.fieldDefault = fieldDefault;
    }

    /**
     * 获取: FieldHref
     */
    public String getFieldHref() {
        return fieldHref;
    }

    /**
     * 设置: FieldHref
     */
    public void setFieldHref(String fieldHref) {
        this.fieldHref = fieldHref;
    }

    /**
     * 获取: FieldLength
     */
    public Integer getFieldLength() {
        return fieldLength;
    }

    /**
     * 设置: FieldLength
     */
    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    /**
     * 获取: FieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置: FieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 获取: FieldValidType
     */
    public String getFieldValidType() {
        return fieldValidType;
    }

    /**
     * 设置: FieldValidType
     */
    public void setFieldValidType(String fieldValidType) {
        this.fieldValidType = fieldValidType;
    }

    /**
     * 获取: 是否主键
     */
    public String getIsKey() {
        return isKey;
    }

    /**
     * 设置: 是否主键
     */
    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    /**
     * 获取: IsNull
     */
    public String getIsNull() {
        return isNull;
    }

    /**
     * 设置: IsNull
     */
    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    /**
     * 获取: 是否查询
     */
    public String getIsQuery() {
        return isQuery;
    }

    /**
     * 设置: 是否查询
     */
    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    /**
     * 获取: 是否显示
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置: 是否显示
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取: 显示枚举(逗号分隔)
     */
    public String getIsShowList() {
        return isShowList;
    }

    /**
     * 设置: 显示枚举(逗号分隔)
     */
    public void setIsShowList(String isShowList) {
        this.isShowList = isShowList;
    }

    /**
     * 获取: Length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 设置: Length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 获取: 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置: 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取: PointLength
     */
    public Integer getPointLength() {
        return pointLength;
    }

    /**
     * 设置: PointLength
     */
    public void setPointLength(Integer pointLength) {
        this.pointLength = pointLength;
    }

    /**
     * 获取: 查询类型
     */
    public String getQueryMode() {
        return queryMode;
    }

    /**
     * 设置: 查询类型
     */
    public void setQueryMode(String queryMode) {
        this.queryMode = queryMode;
    }

    /**
     * 获取: 显示类型
     */
    public String getShowType() {
        return showType;
    }

    /**
     * 设置: 显示类型
     */
    public void setShowType(String showType) {
        this.showType = showType;
    }

    /**
     * 获取: Type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置: Type
     */
    public void setType(String type) {
        this.type = type;
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

    /**
     * 获取: UpdateName
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置: UpdateName
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    /**
     * 获取: 关联表ID
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * 设置: 关联表ID
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
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
