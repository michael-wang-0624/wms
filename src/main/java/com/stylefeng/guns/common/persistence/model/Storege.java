package com.stylefeng.guns.common.persistence.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-03
 */
public class Storege extends Model<Storege> {

    private static final long serialVersionUID = 1L;

    /**
     * 库位表
     */
	private Integer id;
    /**
     * 库位号
     */
	@TableField("storege_code")
	private Integer storegeCode;
    /**
     * 库位名称
     */
	private String name;
    /**
     * 库位类型
     */
	private Integer type;
    /**
     * 仓库Id
     */
	@TableField("warehouse_id")
	private Integer warehouseId;
    /**
     * 是否禁用
     */
	@TableField("is_disable")
	private Integer isDisable;
    /**
     * 是否默认
     */
	@TableField("is_defalut")
	private Integer isDefalut;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 备注信息
     */
	private String information;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoregeCode() {
		return storegeCode;
	}

	public void setStoregeCode(Integer storegeCode) {
		this.storegeCode = storegeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

	public Integer getIsDefalut() {
		return isDefalut;
	}

	public void setIsDefalut(Integer isDefalut) {
		this.isDefalut = isDefalut;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Storege{" +
			"id=" + id +
			", storegeCode=" + storegeCode +
			", name=" + name +
			", type=" + type +
			", warehouseId=" + warehouseId +
			", isDisable=" + isDisable +
			", isDefalut=" + isDefalut +
			", createTime=" + createTime +
			", information=" + information +
			"}";
	}
}
