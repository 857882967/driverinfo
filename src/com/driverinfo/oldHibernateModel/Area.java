package com.driverinfo.oldHibernateModel;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer code;
	private String name;
	private String fathercode;
	private Set companies = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(Integer code) {
		this.code = code;
	}

	/** full constructor */
	public Area(Integer code, String name, String fathercode, Set companies,
			Set users) {
		this.code = code;
		this.name = name;
		this.fathercode = fathercode;
		this.companies = companies;
		this.users = users;
	}

	/** */
	public Area(Integer id, Integer code, String name, String fathercode) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.fathercode = fathercode;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathercode() {
		return this.fathercode;
	}

	public void setFathercode(String fathercode) {
		this.fathercode = fathercode;
	}

	public Set getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set companies) {
		this.companies = companies;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}