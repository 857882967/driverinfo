package com.driverinfo.entity;

import java.sql.Timestamp;

//司机实例对应model.Driver 用于 toExcel
public class EntityCar {

	
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
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChp() {
		return chp;
	}
	public void setChp(String chp) {
		this.chp = chp;
	}
	public Integer getCartype() {
		return cartype;
	}
	public void setCartype(Integer cartype) {
		this.cartype = cartype;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getOperationState() {
		return operationState;
	}
	public void setOperationState(String operationState) {
		this.operationState = operationState;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	public Timestamp getPutOperationtime() {
		return putOperationtime;
	}
	public void setPutOperationtime(Timestamp putOperationtime) {
		this.putOperationtime = putOperationtime;
	}
	public String getTravelid() {
		return travelid;
	}
	public void setTravelid(String travelid) {
		this.travelid = travelid;
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
	public Integer getRestrictDate() {
		return restrictDate;
	}
	public void setRestrictDate(Integer restrictDate) {
		this.restrictDate = restrictDate;
	}
	public Timestamp getScrapdate() {
		return scrapdate;
	}
	public void setScrapdate(Timestamp scrapdate) {
		this.scrapdate = scrapdate;
	}
	public Integer getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(Integer creatorid) {
		this.creatorid = creatorid;
	}
		
		
}
