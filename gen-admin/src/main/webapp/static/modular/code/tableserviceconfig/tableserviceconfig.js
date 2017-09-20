/**
 * 管理初始化
 */
var TableServiceConfig = {
    id: "TableServiceConfigTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TableServiceConfig.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
	     {title: 'Id', field: 'id', align: 'center', valign: 'middle'},
	     {title: '对应表', field: 'tableId', align: 'center', valign: 'middle'},
	     {title: '功能 ', field: 'type', align: 'center', valign: 'middle'},
	     {title: '是否启用改功能', field: 'isEnable', align: 'center', valign: 'middle'},
	     {title: '是否需要授权', field: 'isPermission', align: 'center', valign: 'middle'},
	     {title: '是否开启事务', field: 'isTransactional', align: 'center', valign: 'middle'},
	     {title: '事务类型', field: 'transactionalType', align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
TableServiceConfig.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TableServiceConfig.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TableServiceConfig.openAddTableServiceConfig = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tableserviceconfig/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TableServiceConfig.openTableServiceConfigDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tableserviceconfig/goto_update/' + TableServiceConfig.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
TableServiceConfig.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tableserviceconfig/delete", function (data) {
            Feng.success("删除成功!");
            TableServiceConfig.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tableserviceconfigId",this.seItem.id);
        ajax.start();
    }
};

TableServiceConfig.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询列表
 */
TableServiceConfig.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TableServiceConfig.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TableServiceConfig.initColumn();
    var table = new BSTable(TableServiceConfig.id, "/tableserviceconfig/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(TableServiceConfig.formParams());
    TableServiceConfig.table = table.init();
});
