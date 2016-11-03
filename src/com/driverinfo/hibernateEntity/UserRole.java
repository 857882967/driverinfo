package com.driverinfo.hibernateEntity;
// Generated 2016-10-26 10:27:41 by Hibernate Tools 4.3.1.Final

/**
 * UserRole generated by hbm2java
 */

public class UserRole implements java.io.Serializable {

	private Integer id;
	private Role role;
	private User user;

	public UserRole() {
	}

	public UserRole(Role role, User user) {
		this.role = role;
		this.user = user;
	}


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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}