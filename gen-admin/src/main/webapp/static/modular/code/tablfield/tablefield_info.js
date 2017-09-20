/**
 * 初始化详情对话框
 */
var TableFieldInfoDlg = {
    TableFieldInfoData : {}
};

/**
 * 清除数据
 */
TableFieldInfoDlg.clearData = function() {
    this.TableFieldInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TableFieldInfoDlg.set = function(key, val) {
    this.TableFieldInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TableFieldInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TableFieldInfoDlg.close = function() {
    parent.layer.close(window.parent.TableField.layerIndex);
}

/**
 * 收集数据
 */
TableFieldInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
TableFieldInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/TableField/add", function(data){
        Feng.success("添加成功!");
        window.parent.TableField.table.refresh();
        TableFieldInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.TableFieldInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TableFieldInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/TableField/update", function(data){
        Feng.success("修改成功!");
        window.parent.TableField.table.refresh();
        TableFieldInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.TableFieldInfoData);
    ajax.start();
}

$(function() {

});
