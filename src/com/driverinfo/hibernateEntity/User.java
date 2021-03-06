package com.driverinfo.hibernateEntity;
// Generated 2016-10-26 10:27:41 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer id;
	private Areas areas;
	private String name;
	private String cname;
	private String password;
	private Integer status;
	private Integer creator;
	private Integer companyid;
	private Integer arealevel;
	private Date createtime;
	private Date updatetime;
	private Date logintime;
	private Date loginouttime;
	private Set userRoles = new HashSet(0);

	public User() {
	}

	public User(String name, String cname, String password) {
		this.name = name;
		this.cname = cname;
		this.password = password;
	}

	public User(Areas areas, String name, String cname, String password, Integer status, Integer creator,
			Integer companyid, Integer arealevel, Date createtime, Date updatetime, Date logintime, Date loginouttime,
			Set userRoles) {
		this.areas = areas;
		this.name = name;
		this.cname = cname;
		this.password = password;
		this.status = status;
		this.creator = creator;
		this.companyid = companyid;
		this.arealevel = arealevel;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.logintime = logintime;
		this.loginouttime = loginouttime;
		this.userRoles = userRoles;
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

	
	public Integer getArealevel() {
		return this.arealevel;
	}

	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
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


	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	
	public Date getLoginouttime() {
		return this.loginouttime;
	}

	public void setLoginouttime(Date loginouttime) {
		this.loginouttime = loginouttime;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}
