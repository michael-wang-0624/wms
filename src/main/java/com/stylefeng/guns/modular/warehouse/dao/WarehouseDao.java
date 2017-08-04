package com.stylefeng.guns.modular.warehouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 仓库Dao
 *
 * @author fengshuonan
 * @Date 2017-08-02 14:16:07
 */
public interface WarehouseDao {


    /**
     * 
     *@author 王胜
     *@version 1.0.0
     *@date 2017年8月2日
     *@param condition
     *@return
     *@see
     */
    List<Map<String, Object>> selectWarehouses(@Param("condition") String condition);
}
