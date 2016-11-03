package com.driverinfo.oldHibernateModel;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String title;
	private Integer enable;
	private Integer level;
	private String desciption;
	private Integer creator;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Integer areaid;
	private Set roleAuths = new HashSet(0);
	private Set userRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String name, String title, Integer level, String desciption) {
		this.name = name;
		this.title = title;
		this.level = level;
		this.desciption = desciption;
	}

	/** full constructor */
	public Role(String name, String title, Integer enable, Integer level,
			String desciption, Integer creator, Timestamp createtime,
			Timestamp updatetime, Integer areaid, Set roleAuths, Set userRoles) {
		this.name = name;
		this.title = title;
		this.enable = enable;
		this.level = level;
		this.desciption = desciption;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.areaid = areaid;
		this.roleAuths = roleAuths;
		this.userRoles = userRoles;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEnable() {
		return this.enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Integer getCreator() {
		return this.creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
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

	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Set getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(Set roleAuths) {
		this.roleAuths = roleAuths;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}