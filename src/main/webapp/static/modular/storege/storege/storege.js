/**
 * 库位管理初始化
 */
var Storege = {
    id: "StoregeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Storege.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Storege.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Storege.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加库位
 */
Storege.openAddStorege = function () {
    var index = layer.open({
        type: 2,
        title: '添加库位',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/storege/storege_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看库位详情
 */
Storege.openStoregeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '库位详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/storege/storege_update/' + Storege.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除库位
 */
Storege.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/storege/delete", function (data) {
            Feng.success("删除成功!");
            Storege.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("storegeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询库位列表
 */
Storege.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Storege.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Storege.initColumn();
    var table = new BSTable(Storege.id, "/storege/list", defaultColunms);
    table.setPaginationType("client");
    Storege.table = table.init();
});
