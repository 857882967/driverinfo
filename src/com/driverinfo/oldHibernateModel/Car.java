package com.driverinfo.oldHibernateModel;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	private Integer id;
	private String chp;
	private Integer cartype;
	private String carcolor;
	private String engineNo;
	private String operationState;
	private Integer status;
	private Integer companyid;
	private Timestamp putOperationtime;
	private String travelid;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Integer restrictDate;
	private Timestamp scrapdate;
	private Integer creatorid;
	private Set drivers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** full constructor */
	public Car(String chp, Integer cartype, String carcolor, String engineNo,
			String operationState, Integer status, Integer companyid,
			Timestamp putOperationtime, String travelid, Timestamp createtime,
			Timestamp updatetime, Integer restrictDate, Timestamp scrapdate,
			Integer creatorid, Set drivers) {
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

	// Property accessors

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

	public Timestamp getPutOperationtime() {
		return this.putOperationtime;
	}

	public void setPutOperationtime(Timestamp putOperationtime) {
		this.putOperationtime = putOperationtime;
	}

	public String getTravelid() {
		return this.travelid;
	}

	public void setTravelid(String travelid) {
		this.travelid = travelid;
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

	public Integer getRestrictDate() {
		return this.restrictDate;
	}

	public void setRestrictDate(Integer restrictDate) {
		this.restrictDate = restrictDate;
	}

	public Timestamp getScrapdate() {
		return this.scrapdate;
	}

	public void setScrapdate(Timestamp scrapdate) {
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