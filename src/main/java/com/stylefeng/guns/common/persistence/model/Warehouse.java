package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
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
public class Warehouse extends Model<Warehouse> {

    private static final long serialVersionUID = 1L;

    /**
     * 仓库主键
     */
	@TableId(value="warehouse_id", type= IdType.AUTO)
	private Integer warehouseId;
    /**
     * 仓库名称
     */
	@TableField("warehouse_name")
	private String warehouseName;
    /**
     * 租赁时间
     */
	@TableField("rent_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rentTime;
    /**
     * 仓库类型
     */
	@TableField("warehouse_type")
	private Integer warehouseType;
    /**
     * 部门Id
     */
	@TableField("dept_id")
	private Integer deptId;
    /**
     * 是否禁用
     */
	@TableField("is_unuse")
	private Integer isUnuse;
    /**
     * 是否默认
     */
	@TableField("is_defalut")
	private Integer isDefalut;
    /**
     * 地址
     */
	private String address;
    /**
     * 纬度
     */
	private Double addrlat;
    /**
     * 经度
     */
	private Double addrlng;
    /**
     * 面积
     */
	private Double area;
    /**
     * 联系人
     */
	@TableField("contact_person")
	private String contactPerson;
    /**
     * 联系电话
     */
	@TableField("contact_phone")
	private String contactPhone;
    /**
     * 创建人
     */
	@TableField("create_user")
	private String createUser;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 编号
     */
	@TableField("warehouse_code")
	private String warehouseCode;
    /**
     * 作用
     */
	private String purpose;


	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Date getRentTime() {
		return rentTime;
	}

	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
	}

	public Integer getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(Integer warehouseType) {
		this.warehouseType = warehouseType;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getIsUnuse() {
		return isUnuse;
	}

	public void setIsUnuse(Integer isUnuse) {
		this.isUnuse = isUnuse;
	}

	public Integer getIsDefalut() {
		return isDefalut;
	}

	public void setIsDefalut(Integer isDefalut) {
		this.isDefalut = isDefalut;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAddrlat() {
		return addrlat;
	}

	public void setAddrlat(Double addrlat) {
		this.addrlat = addrlat;
	}

	public Double getAddrlng() {
		return addrlng;
	}

	public void setAddrlng(Double addrlng) {
		this.addrlng = addrlng;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	protected Serializable pkVal() {
		return this.warehouseId;
	}

	@Override
	public String toString() {
		return "Warehouse{" +
			"warehouseId=" + warehouseId +
			", warehouseName=" + warehouseName +
			", rentTime=" + rentTime +
			", warehouseType=" + warehouseType +
			", deptId=" + deptId +
			", isUnuse=" + isUnuse +
			", isDefalut=" + isDefalut +
			", address=" + address +
			", addrlat=" + addrlat +
			", addrlng=" + addrlng +
			", area=" + area +
			", contactPerson=" + contactPerson +
			", contactPhone=" + contactPhone +
			", createUser=" + createUser +
			", createTime=" + createTime +
			", warehouseCode=" + warehouseCode +
			", purpose=" + purpose +
			"}";
	}
}
