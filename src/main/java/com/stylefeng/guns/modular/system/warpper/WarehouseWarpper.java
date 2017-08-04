package com.stylefeng.guns.modular.system.warpper;

import java.util.List;
import java.util.Map;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;

public class WarehouseWarpper extends BaseControllerWarpper {

    public WarehouseWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
   
        map.put("deptName", ConstantFactory.me().getDeptName((Integer) map.get("dept_id")));
     }
}
