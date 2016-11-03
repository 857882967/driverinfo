package com.driverinfo.oldHibernateModel;

import java.sql.Timestamp;

/**
 * Driver entity. @author MyEclipse Persistence Tools
 */

public class Driver implements java.io.Serializable {

	// Fields

	private Integer id;
	private Car car;
	private Company company;
	private String name;
	private Integer sex;
	private String sfzh;
	private String zgzh;
	private String address;
	private String lxdh;
	private String driverNo;
	private Integer status;
	private String driverLevel;
	private Timestamp createtime;
	private Timestamp updatetime;

	// Constructors

	/** default constructor */
	public Driver() {
	}

	/** minimal constructor */
	public Driver(String name) {
		this.name = name;
	}

	/** full constructor */
	public Driver(Car car, Company company, String name, Integer sex,
			String sfzh, String zgzh, String address, String lxdh,
			String driverNo, Integer status, String driverLevel,
			Timestamp createtime, Timestamp updatetime) {
		this.car = car;
		this.company = company;
		this.name = name;
		this.sex = sex;
		this.sfzh = sfzh;
		this.zgzh = zgzh;
		this.address = address;
		this.lxdh = lxdh;
		this.driverNo = driverNo;
		this.status = status;
		this.driverLevel = driverLevel;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getZgzh() {
		return this.zgzh;
	}

	public void setZgzh(String zgzh) {
		this.zgzh = zgzh;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getDriverNo() {
		return this.driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDriverLevel() {
		return this.driverLevel;
	}

	public void setDriverLevel(String driverLevel) {
		this.driverLevel = driverLevel;
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

}