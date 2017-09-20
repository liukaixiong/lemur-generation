package cn.afterturn.gen.modular.code.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @author JueYue
 * @Date 2017-09-20 09:22
 */
@TableName("t_code_table_field")
public class TableFieldModel extends Model<TableFieldModel> {

    private static final long serialVersionUID = 1L;


    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联表ID
     */
    @TableField(value = "table_id")
    private Integer tableId;

    /**
     * 列名
     */
    @TableField(value = "field_name")
    private String fieldName;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 功能
     */
    @TableField(value = "content")
    private String content;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 是否主键
     */
    @TableField(value = "is_key")
    private String isKey;

    /**
     * 是否可以为空
     */
    @TableField(value = "is_null")
    private String isNull;

    /**
     * 是否显示新增
     */
    @TableField(value = "is_show_add")
    private Integer isShowAdd;

    /**
     * 是否显示编辑
     */
    @TableField(value = "is_show_edit")
    private Integer isShowEdit;

    /**
     * 是否显示详情
     */
    @TableField(value = "is_show_detail")
    private Integer isShowDetail;

    /**
     * 是否列表显示
     */
    @TableField(value = "is_show_list")
    private Integer isShowList;

    /**
     * 是否Excel导入
     */
    @TableField(value = "is_import")
    private Integer isImport;

    /**
     * 是否导出Excel
     */
    @TableField(value = "is_export")
    private Integer isExport;

    /**
     * 是否查询
     */
    @TableField(value = "is_query")
    private String isQuery;

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
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 字段名称
     */
    @TableField(value = "dict_name")
    private String dictName;

    /**
     * 字段类型 1 枚举 2 字段 3 列表
     */
    @TableField(value = "dict_type")
    private Integer dictType;

    /**
     * 字段默认值
     */
    @TableField(value = "field_default")
    private String fieldDefault;

    /**
     * 字段注释
     */
    @TableField(value = "field_content")
    private String fieldContent;

    /**
     * 字段长度
     */
    @TableField(value = "field_length")
    private Integer fieldLength;

    /**
     * 字段类型
     */
    @TableField(value = "field_type")
    private String fieldType;

    /**
     * 小数点位数
     */
    @TableField(value = "field_point_length")
    private Integer fieldPointLength;


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
     * 获取: 关联表ID
     */
    public Integer getTableId() {
        return tableId;
    }

    /**
     * 设置: 关联表ID
     */
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取: 列名
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置: 列名
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 获取: 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置: 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取: 功能
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置: 功能
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取: 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置: 类型
     */
    public void setType(String type) {
        this.type = type;
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
     * 获取: 是否可以为空
     */
    public String getIsNull() {
        return isNull;
    }

    /**
     * 设置: 是否可以为空
     */
    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    /**
     * 获取: 是否显示新增
     */
    public Integer getIsShowAdd() {
        return isShowAdd;
    }

    /**
     * 设置: 是否显示新增
     */
    public void setIsShowAdd(Integer isShowAdd) {
        this.isShowAdd = isShowAdd;
    }

    /**
     * 获取: 是否显示编辑
     */
    public Integer getIsShowEdit() {
        return isShowEdit;
    }

    /**
     * 设置: 是否显示编辑
     */
    public void setIsShowEdit(Integer isShowEdit) {
        this.isShowEdit = isShowEdit;
    }

    /**
     * 获取: 是否显示详情
     */
    public Integer getIsShowDetail() {
        return isShowDetail;
    }

    /**
     * 设置: 是否显示详情
     */
    public void setIsShowDetail(Integer isShowDetail) {
        this.isShowDetail = isShowDetail;
    }

    /**
     * 获取: 是否列表显示
     */
    public Integer getIsShowList() {
        return isShowList;
    }

    /**
     * 设置: 是否列表显示
     */
    public void setIsShowList(Integer isShowList) {
        this.isShowList = isShowList;
    }

    /**
     * 获取: 是否Excel导入
     */
    public Integer getIsImport() {
        return isImport;
    }

    /**
     * 设置: 是否Excel导入
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
     * 获取: 字段名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置: 字段名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取: 字段类型 1 枚举 2 字段 3 列表
     */
    public Integer getDictType() {
        return dictType;
    }

    /**
     * 设置: 字段类型 1 枚举 2 字段 3 列表
     */
    public void setDictType(Integer dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取: 字段默认值
     */
    public String getFieldDefault() {
        return fieldDefault;
    }

    /**
     * 设置: 字段默认值
     */
    public void setFieldDefault(String fieldDefault) {
        this.fieldDefault = fieldDefault;
    }

    /**
     * 获取:  字段注释
     */
    public String getFieldContent() {
        return fieldContent;
    }

    /**
     * 设置:  字段注释
     */
    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent;
    }

    /**
     * 获取: 字段长度
     */
    public Integer getFieldLength() {
        return fieldLength;
    }

    /**
     * 设置: 字段长度
     */
    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    /**
     * 获取: 字段类型
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 设置: 字段类型
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * 获取: 小数点位数
     */
    public Integer getFieldPointLength() {
        return fieldPointLength;
    }

    /**
     * 设置: 小数点位数
     */
    public void setFieldPointLength(Integer fieldPointLength) {
        this.fieldPointLength = fieldPointLength;
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
