package com.driverinfo.entity;

import java.sql.Timestamp;

//用户表格实体
public class UserEntity {

	private Integer id;
	private String name;
	private String cname;
	private String password;
	private String areaName;//地区名称
	private String companyName;//所属公司名称
	private Integer status;
	private Integer creator;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Timestamp logintime;
	private Timestamp loginouttime;
	
	
	
	public UserEntity(Integer id, String name, String cname, String password, String areaName, String companyName,
			Integer status, Integer creator, Timestamp createtime) {
		super();
		this.id = id;
		this.name = name;
		this.cname = cname;
		this.password = password;
		this.areaName = areaName;
		this.companyName = companyName;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
	}
	public UserEntity(Integer id, String name, String cname, String areaName, Timestamp createtime) {
		super();
		this.id = id;
		this.name = name;
		this.cname = cname;
		this.areaName = areaName;
		this.createtime = createtime;
	}
	public UserEntity() {
		super();
	}
	public UserEntity(Integer id, String name, String cname, String password, String areaName, String companyName,
			Integer status, Integer creator, Timestamp createtime, Timestamp updatetime, Timestamp logintime,
			Timestamp loginouttime) {
		super();
		this.id = id;
		this.name = name;
		this.cname = cname;
		this.password = password;
		this.areaName = areaName;
		this.companyName = companyName;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.logintime = logintime;
		this.loginouttime = loginouttime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Timestamp getLogintime() {
		return logintime;
	}
	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}
	public Timestamp getLoginouttime() {
		return loginouttime;
	}
	public void setLoginouttime(Timestamp loginouttime) {
		this.loginouttime = loginouttime;
	}

	
}
