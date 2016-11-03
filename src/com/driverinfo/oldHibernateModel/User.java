package com.driverinfo.oldHibernateModel;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Area area;
	private String name;
	private String cname;
	private String password;
	private Integer status;
	private Integer creator;
	private Integer companyid;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Timestamp logintime;
	private Timestamp loginouttime;
	private Set userRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String cname, String password) {
		this.name = name;
		this.cname = cname;
		this.password = password;
	}

	/** full constructor */
	public User(Area area, String name, String cname, String password,
			Integer status, Integer creator, Integer companyid,
			Timestamp createtime, Timestamp updatetime, Timestamp logintime,
			Timestamp loginouttime, Set userRoles) {
		this.area = area;
		this.name = name;
		this.cname = cname;
		this.password = password;
		this.status = status;
		this.creator = creator;
		this.companyid = companyid;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.logintime = logintime;
		this.loginouttime = loginouttime;
		this.userRoles = userRoles;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreator() {
		return this.creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Integer getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
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

	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public Timestamp getLoginouttime() {
		return this.loginouttime;
	}

	public void setLoginouttime(Timestamp loginouttime) {
		this.loginouttime = loginouttime;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}