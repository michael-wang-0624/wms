/**
 * 初始化仓库详情对话框
 */
var WarehouseInfoDlg = {
    warehouseInfoData : {},
    validateFields: {
    	warehouseName: {
            validators: {
                notEmpty: {
                    message: '仓库名称不能为空'
                }
            }
        },
        
        contactPhone:{
        	validators: {
        		notEmpty: {
                    message: '手机号码不能为空'
                },
                stringLength: {
                    min: 11,
                    max: 11,
                    message: '请输入11位手机号码'
                },
                regexp: {
                    regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                    message: '请输入正确的手机号码'
                }
        	}
        	
        },
        pid:{
        	validators: {
                notEmpty: {
                    message: '部门不能为空'
                }
            }
        }, 
        address:{
        	validators:{
        		notEmpty: {
                    message: '仓库名称不能为空'
                },
                stringLength: {/*长度提示*/
                    min: 6,
                    max: 30,
                    message: '地址长度必须在6到30之间'
                }
        	}
        }
        
        
        
        
        
       
    
    }
};

/**
 * 清除数据
 */
WarehouseInfoDlg.clearData = function() {
    this.warehouseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WarehouseInfoDlg.set = function(key, val) {
 
    this.warehouseInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WarehouseInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WarehouseInfoDlg.close = function() {
    parent.layer.close(window.parent.Warehouse.layerIndex);
}

/**
 * 收集数据
 */
WarehouseInfoDlg.collectData = function() {
    this.set('warehouseId').set('warehouseName').set('warehouseType').
    set('area').set('purpose').set('rentTime').set('contactPhone').set('contactPerson').set('pid').set('address').set('warehouseCode');
}

/**
 * 提交添加
 */
WarehouseInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/warehouse/add", function(data){
        Feng.success("添加成功!");
        window.parent.Warehouse.table.refresh();
        WarehouseInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    
    ajax.set(this.warehouseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WarehouseInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/warehouse/update", function(data){
        Feng.success("修改成功!");
        window.parent.Warehouse.table.refresh();
        WarehouseInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.warehouseInfoData);
    ajax.start();
}

$(function() {
	Feng.initValidator("warehouseForm", WarehouseInfoDlg.validateFields);
});
