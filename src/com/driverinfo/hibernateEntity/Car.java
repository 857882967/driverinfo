package com.driverinfo.hibernateEntity;
// Generated 2016-10-26 10:27:41 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * Car generated by hbm2java
 */

public class Car implements java.io.Serializable {

	private Integer id;
	private String chp;
	private Integer cartype;
	private String carcolor;
	private String engineNo;
	private String operationState;
	private Integer status;
	private Integer companyid;
	private Date putOperationtime;
	private String travelid;
	private Date createtime;
	private Date updatetime;
	private Integer restrictDate;
	private Date scrapdate;
	private Integer creatorid;
	private Set drivers = new HashSet(0);

	public Car() {
	}

	public Car(String chp, Integer cartype, String carcolor, String engineNo, String operationState, Integer status,
			Integer companyid, Date putOperationtime, String travelid, Date createtime, Date updatetime,
			Integer restrictDate, Date scrapdate, Integer creatorid, Set drivers) {
		this.chp = chp;
		this.cartype = cartype;
		this.carcolor = carcolor;
		this.engineNo = engineNo;
		this.operationState = operationState;
		this.status = status;
		this.companyid = companyid;
		this.putOperationtime = putOperationtime;
		this.travelid = travelid;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.restrictDate = restrictDate;
		this.scrapdate = scrapdate;
		this.creatorid = creatorid;
		this.drivers = drivers;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getChp() {
		return this.chp;
	}

	public void setChp(String chp) {
		this.chp = chp;
	}

	
	public Integer getCartype() {
		return this.cartype;
	}

	public void setCartype(Integer cartype) {
		this.cartype = cartype;
	}

	
	public String getCarcolor() {
		return this.carcolor;
	}

	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}

	
	public String getEngineNo() {
		return this.engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	
	public String getOperationState() {
		return this.operationState;
	}

	public void setOperationState(String operationState) {
		this.operationState = operationState;
	}

	
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public Integer getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	
	public Date getPutOperationtime() {
		return this.putOperationtime;
	}

	public void setPutOperationtime(Date putOperationtime) {
		this.putOperationtime = putOperationtime;
	}

	
	public String getTravelid() {
		return this.travelid;
	}

	public void setTravelid(String travelid) {
		this.travelid = travelid;
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

	
	public Integer getRestrictDate() {
		return this.restrictDate;
	}

	public void setRestrictDate(Integer restrictDate) {
		this.restrictDate = restrictDate;
	}

	
	public Date getScrapdate() {
		return this.scrapdate;
	}

	public void setScrapdate(Date scrapdate) {
		this.scrapdate = scrapdate;
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
