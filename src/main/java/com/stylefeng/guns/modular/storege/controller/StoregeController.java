package com.stylefeng.guns.modular.storege.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 库位控制器
 *
 * @author fengshuonan
 * @Date 2017-08-03 16:30:36
 */
@Controller
@RequestMapping("/storege")
public class StoregeController extends BaseController {

    private String PREFIX = "/storege/storege/";

    /**
     * 跳转到库位首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "storege.html";
    }

    /**
     * 跳转到添加库位
     */
    @RequestMapping("/storege_add")
    public String storegeAdd() {
        return PREFIX + "storege_add.html";
    }

    /**
     * 跳转到修改库位
     */
    @RequestMapping("/storege_update/{storegeId}")
    public String storegeUpdate(@PathVariable Integer storegeId, Model model) {
        return PREFIX + "storege_edit.html";
    }

    /**
     * 获取库位列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增库位
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除库位
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改库位
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 库位详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
