/**
 * 仓库管理初始化
 */
var Warehouse = {
    id: "WarehouseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Warehouse.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'warehouse_id', visible: false, align: 'center', valign: 'middle'},
        {title: '仓库编号', field: 'warehouse_code', align: 'center', valign: 'middle', sortable: true},
        {title: '仓库名称', field: 'warehouse_name', align: 'center', valign: 'middle', sortable: true},
        {title: '租赁时间', field: 'rent_time', align: 'center', valign: 'middle', sortable: true},
        {title: '仓库类型', field: 'warehouse_type', align: 'center', valign: 'middle', sortable: true},
        {title: '所属部门', field: 'deptName', align: 'center', valign: 'middle', sortable: true},
        {title: '是否禁用',field: 'is_unuse', align: 'center', valign: 'middle', sortable: true},
        {title: '是否默认', field: 'is_defalut', align: 'center', valign: 'middle', sortable: true},
        {title: '地址', field: 'address', align: 'center', valign: 'middle', sortable: true},
        {title: '联系人', field: 'contact_person', align: 'center', valign: 'middle', sortable: true},
        {title: '联系电话', field: 'contact_phone', align: 'center', valign: 'middle', sortable: true},
        {title: '面积', field: 'area', align: 'center', valign: 'middle', sortable: true}];
};

/**
 * 检查是否选中
 */
Warehouse.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Warehouse.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加仓库
 */
Warehouse.openAddWarehouse = function () {
    var index = layer.open({
        type: 2,
        title: '添加仓库',
        area: ['800px', '620px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/warehouse/warehouse_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看仓库详情
 */
Warehouse.openWarehouseDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '仓库详情',
            area: ['800px', '620px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/warehouse/warehouse_update/' + Warehouse.seItem.warehouse_id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除仓库
 */
Warehouse.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/warehouse/delete", function (data) {
            Feng.success("删除成功!");
            Warehouse.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
         
       
        ajax.set("warehouseId",this.seItem.warehouse_id);
        ajax.start();
    }
};

/**
 * 查询仓库列表
 */
Warehouse.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Warehouse.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Warehouse.initColumn();
    var table = new BSTable(Warehouse.id, "/warehouse/list", defaultColunms);
    table.setPaginationType("client");
    
    Warehouse.table = table.init();
});
