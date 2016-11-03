package com.driverinfo.oldHibernateModel;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	private Integer id;
	private Area area;
	private String allName;
	private String simpleName;
	private String phone;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Integer creatorid;
	private Set drivers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(String allName) {
		this.allName = allName;
	}

	/** full constructor */
	public Company(Area area, String allName, String simpleName, String phone,
			Timestamp createtime, Timestamp updatetime, Integer creatorid,
			Set drivers) {
		this.area = area;
		this.allName = allName;
		this.simpleName = simpleName;
		this.phone = phone;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.creatorid = creatorid;
		this.drivers = drivers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAllName() {
		return this.allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}

	public String getSimpleName() {
		return this.simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(Integer creatorid) {
		this.creatorid = creatorid;
	}

	public Set getDrivers() {
		return this.drivers;
	}

	public void setDrivers(Set drivers) {
		this.drivers = drivers;
	}

}