package com.driverinfo.hibernateEntity;
// Generated 2016-10-26 10:27:41 by Hibernate Tools 4.3.1.Final

/**
 * RoleAuth generated by hbm2java
 */
public class RoleAuth implements java.io.Serializable {

	private Integer id;
	private Authority authority;
	private Role role;

	public RoleAuth() {
	}

	public RoleAuth(Authority authority, Role role) {
		this.authority = authority;
		this.role = role;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}