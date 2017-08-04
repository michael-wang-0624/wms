/**
 * 初始化库位详情对话框
 */
var StoregeInfoDlg = {
    storegeInfoData : {}
};

/**
 * 清除数据
 */
StoregeInfoDlg.clearData = function() {
    this.storegeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StoregeInfoDlg.set = function(key, val) {
    this.storegeInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StoregeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
StoregeInfoDlg.close = function() {
    parent.layer.close(window.parent.Storege.layerIndex);
}

/**
 * 收集数据
 */
StoregeInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
StoregeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/storege/add", function(data){
        Feng.success("添加成功!");
        window.parent.Storege.table.refresh();
        StoregeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.storegeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
StoregeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/storege/update", function(data){
        Feng.success("修改成功!");
        window.parent.Storege.table.refresh();
        StoregeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.storegeInfoData);
    ajax.start();
}

$(function() {

});
