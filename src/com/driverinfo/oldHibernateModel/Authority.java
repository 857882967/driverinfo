package com.driverinfo.oldHibernateModel;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable {

	// Fields

	

	private Integer id;
	private String name;
	private String title;
	private String code;
	private String fathercode;
	private String type;
	private String url;
	private String icon;
	private String desciption;
	private Integer creatorid;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Integer areaid;
	private Set roleAuths = new HashSet(0);

	
	
	public Authority(Integer id, String name, String title, String code, String fathercode, String type, String url,
			String icon) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.code = code;
		this.fathercode = fathercode;
		this.type = type;
		this.url = url;
		this.icon = icon;
	}
	
	

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** minimal constructor */
	public Authority(String name, String title) {
		this.name = name;
		this.title = title;
	}

	/** full constructor */
	public Authority(String name, String title, String code, String fathercode,
			String type, String url, String icon, String desciption,
			Integer creatorid, Timestamp createtime, Timestamp updatetime,
			Integer areaid, Set roleAuths) {
		this.name = name;
		this.title = title;
		this.code = code;
		this.fathercode = fathercode;
		this.type = type;
		this.url = url;
		this.icon = icon;
		this.desciption = desciption;
		this.creatorid = creatorid;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.areaid = areaid;
		this.roleAuths = roleAuths;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFathercode() {
		return this.fathercode;
	}

	public void setFathercode(String fathercode) {
		this.fathercode = fathercode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Integer getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(Integer creatorid) {
		this.creatorid = creatorid;
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

}