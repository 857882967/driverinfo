package com.driverinfo.oldHibernateModel;

/**
 * RoleAuth entity. @author MyEclipse Persistence Tools
 */

public class RoleAuth implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Authority authority;

	// Constructors

	/** default constructor */
	public RoleAuth() {
	}

	/** full constructor */
	public RoleAuth(Role role, Authority authority) {
		this.role = role;
		this.authority = authority;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}