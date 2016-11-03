package com.driverinfo.hibernateEntity;
// Generated 2016-10-26 10:27:41 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Company generated by hbm2java
 */

public class Company implements java.io.Serializable {

	private Integer id;
	private Areas areas;
	private String allName;
	private String simpleName;
	private String phone;
	private Date createtime;
	private Date updatetime;
	private Integer creatorid;
	private Set drivers = new HashSet(0);

	public Company() {
	}

	public Company(String allName) {
		this.allName = allName;
	}

	public Company(Areas areas, String allName, String simpleName, String phone, Date createtime, Date updatetime,
			Integer creatorid, Set drivers) {
		this.areas = areas;
		this.allName = allName;
		this.simpleName = simpleName;
		this.phone = phone;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.creatorid = creatorid;
		this.drivers = drivers;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Areas getAreas() {
		return this.areas;
	}

	public void setAreas(Areas areas) {
		this.areas = areas;
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

	
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
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