/**
 * 表信息管理管理初始化
 */
var TableInfo = {
    id: "TableInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TableInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
	     {title: 'Id', field: 'id', align: 'center', valign: 'middle'},
	     {title: '表名称', field: 'content', align: 'center', valign: 'middle'},
	     {title: 'CreateBy', field: 'createBy', align: 'center', valign: 'middle'},
	     {title: 'CreateDate', field: 'createDate', align: 'center', valign: 'middle'},
	     {title: '是否分页', field: 'isPagination', align: 'center', valign: 'middle'},
	     {title: '是否带出Excel', field: 'isExport', align: 'center', valign: 'middle'},
	     {title: '表名', field: 'tableName', align: 'center', valign: 'middle'},
	     {title: 'UpdateBy', field: 'updateBy', align: 'center', valign: 'middle'},
	     {title: 'UpdateDate', field: 'updateDate', align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
TableInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TableInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加表信息管理
 */
TableInfo.openAddTableInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加表信息管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tableinfo/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看表信息管理详情
 */
TableInfo.openTableInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '表信息管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tableinfo/goto_update/' + TableInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除表信息管理
 */
TableInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tableinfo/delete", function (data) {
            Feng.success("删除成功!");
            TableInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tableinfoId",this.seItem.id);
        ajax.start();
    }
};

TableInfo.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询表信息管理列表
 */
TableInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TableInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TableInfo.initColumn();
    var table = new BSTable(TableInfo.id, "/tableinfo/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(TableInfo.formParams());
    TableInfo.table = table.init();
});
