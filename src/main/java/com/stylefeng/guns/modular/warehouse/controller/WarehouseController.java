package com.stylefeng.guns.modular.warehouse.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.common.annotion.log.BussinessLog;
import com.stylefeng.guns.common.constant.Dict;
import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.WarehouseMapper;
import com.stylefeng.guns.common.persistence.model.Warehouse;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.factory.UserFactory;
import com.stylefeng.guns.modular.system.warpper.WarehouseWarpper;
import com.stylefeng.guns.modular.warehouse.dao.WarehouseDao;

/**
 * 仓库控制器
 *
 * @author fengshuonan
 * @Date 2017-08-02 14:16:06
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController extends BaseController {

    private String PREFIX = "/warehouse/warehouse/";
    
    @Resource
    WarehouseDao warehouseDao;
    
    @Resource
    WarehouseMapper warehouseMapper;

    /**
     * 跳转到仓库首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "warehouse.html";
    }

    /**
     * 跳转到添加仓库
     */
    @RequestMapping("/warehouse_add")
    public String warehouseAdd() {
        return PREFIX + "warehouse_add.html";
    }

    /**
     * 跳转到修改仓库
     */
    @RequestMapping("/warehouse_update/{warehouseId}")
    public String warehouseUpdate(@PathVariable Integer warehouseId, Model model) {
        /*Dict dict = dictMapper.selectById(dictId);
        model.addAttribute("dict", dict);
        List<Dict> subDicts = dictMapper.selectList(new EntityWrapper<Dict>().eq("pid", dictId));
        model.addAttribute("subDicts", subDicts);
        LogObjectHolder.me().set(dict);*/
        Warehouse warehouse = warehouseMapper.selectById(warehouseId);
        model.addAttribute(warehouse);
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(warehouse.getDeptId()));
        return PREFIX + "warehouse_edit.html";
    }

    /**
     * 获取仓库列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String condition) {
        List<Map<String, Object>> list = this.warehouseDao.selectWarehouses(super.getPara("condition"));
        return super.warpObject(new WarehouseWarpper(list));
    }

    /**
     * 新增仓库
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @BussinessLog(value = "新增仓库",key = "warehouseName",dict = Dict.WarehouseDict)
    public Object add(Warehouse warehouse,Integer pid) {
        if (ToolUtil.isOneEmpty(warehouse.getWarehouseName())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        warehouse.setCreateTime(new Date());
        warehouse.setIsDefalut(0);
        warehouse.setIsUnuse(0);
        warehouse.setDeptId(pid);
        warehouse.setCreateUser(ShiroKit.getUser().getName());
        warehouse.insert();
        
        return super.SUCCESS_TIP;
    }

    /**
     * 删除仓库
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @BussinessLog(value = "删除仓库",key = "warehouseId",dict = Dict.DeleteDict)
    public Object delete(@RequestParam Integer warehouseId) {

        this.warehouseMapper.deleteById(warehouseId);
        return SUCCESS_TIP;
    }


    /**
     * 修改仓库
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Warehouse warehouse,Integer pid) {
        warehouse.setDeptId(pid);
        
        this.warehouseMapper.updateById(warehouse);
        return super.SUCCESS_TIP;
    }

    /**
     * 仓库详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
