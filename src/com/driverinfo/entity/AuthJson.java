package com.driverinfo.entity;

import java.util.List;

import com.driverinfo.hibernateEntity.Authority;

//权限菜单+按钮Json
public class AuthJson {


	
	private Authority menuAuthority;//菜单 
	private List<Authority> buttonAuthority;//菜单按钮
	
	
	
	
	public Authority getMenuAuthority() {
		return menuAuthority;
	}
	public void setMenuAuthority(Authority menuAuthority) {
		this.menuAuthority = menuAuthority;
	}
	public List<Authority> getButtonAuthority() {
		return buttonAuthority;
	}
	public void setButtonAuthority(List<Authority> buttonAuthority) {
		this.buttonAuthority = buttonAuthority;
	}
	
	
	
	@Override
	public String toString() {
		return "AuthJson [menuAuthority=" + menuAuthority + ", buttonAuthority=" + buttonAuthority + "]";
	}
	
	
	
	
	
	
	
}
