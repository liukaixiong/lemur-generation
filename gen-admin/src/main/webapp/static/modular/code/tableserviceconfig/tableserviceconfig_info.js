/**
 * 初始化详情对话框
 */
var TableServiceConfigInfoDlg = {
    TableServiceConfigInfoData : {}
};

/**
 * 清除数据
 */
TableServiceConfigInfoDlg.clearData = function() {
    this.TableServiceConfigInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TableServiceConfigInfoDlg.set = function(key, val) {
    this.TableServiceConfigInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TableServiceConfigInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TableServiceConfigInfoDlg.close = function() {
    parent.layer.close(window.parent.TableServiceConfig.layerIndex);
}

/**
 * 收集数据
 */
TableServiceConfigInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
TableServiceConfigInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/TableServiceConfig/add", function(data){
        Feng.success("添加成功!");
        window.parent.TableServiceConfig.table.refresh();
        TableServiceConfigInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.TableServiceConfigInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TableServiceConfigInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/TableServiceConfig/update", function(data){
        Feng.success("修改成功!");
        window.parent.TableServiceConfig.table.refresh();
        TableServiceConfigInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.TableServiceConfigInfoData);
    ajax.start();
}

$(function() {

});
