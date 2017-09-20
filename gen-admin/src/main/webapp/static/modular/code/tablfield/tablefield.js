/**
 * 管理初始化
 */
var TableField = {
    id: "TableFieldTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TableField.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
	     {title: 'Id', field: 'id', align: 'center', valign: 'middle'},
	     {title: '关联表ID', field: 'tableId', align: 'center', valign: 'middle'},
	     {title: '列名', field: 'fieldName', align: 'center', valign: 'middle'},
	     {title: '名称', field: 'name', align: 'center', valign: 'middle'},
	     {title: '功能', field: 'content', align: 'center', valign: 'middle'},
	     {title: '类型', field: 'type', align: 'center', valign: 'middle'},
	     {title: '是否主键', field: 'isKey', align: 'center', valign: 'middle'},
	     {title: '是否可以为空', field: 'isNull', align: 'center', valign: 'middle'},
	     {title: '是否显示新增', field: 'isShowAdd', align: 'center', valign: 'middle'},
	     {title: '是否显示编辑', field: 'isShowEdit', align: 'center', valign: 'middle'},
	     {title: '是否显示详情', field: 'isShowDetail', align: 'center', valign: 'middle'},
	     {title: '是否列表显示', field: 'isShowList', align: 'center', valign: 'middle'},
	     {title: '是否Excel导入', field: 'isImport', align: 'center', valign: 'middle'},
	     {title: '是否导出Excel', field: 'isExport', align: 'center', valign: 'middle'},
	     {title: '是否查询', field: 'isQuery', align: 'center', valign: 'middle'},
	     {title: '查询类型', field: 'queryMode', align: 'center', valign: 'middle'},
	     {title: '显示类型', field: 'showType', align: 'center', valign: 'middle'},
	     {title: '排序', field: 'orderNum', align: 'center', valign: 'middle'},
	     {title: '字段名称', field: 'dictName', align: 'center', valign: 'middle'},
	     {title: '字段类型 1 枚举 2 字段 3 列表', field: 'dictType', align: 'center', valign: 'middle'},
	     {title: '字段默认值', field: 'fieldDefault', align: 'center', valign: 'middle'},
	     {title: ' 字段注释', field: 'fieldContent', align: 'center', valign: 'middle'},
	     {title: '字段长度', field: 'fieldLength', align: 'center', valign: 'middle'},
	     {title: '字段类型', field: 'fieldType', align: 'center', valign: 'middle'},
	     {title: '小数点位数', field: 'fieldPointLength', align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
TableField.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TableField.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TableField.openAddTableField = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tablefield/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TableField.openTableFieldDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tablefield/goto_update/' + TableField.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
TableField.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tablefield/delete", function (data) {
            Feng.success("删除成功!");
            TableField.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tablefieldId",this.seItem.id);
        ajax.start();
    }
};

TableField.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询列表
 */
TableField.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TableField.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TableField.initColumn();
    var table = new BSTable(TableField.id, "/tablefield/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(TableField.formParams());
    TableField.table = table.init();
});
