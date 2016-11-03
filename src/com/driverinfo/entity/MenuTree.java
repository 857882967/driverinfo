package com.driverinfo.entity;

import java.util.List;

//菜单树
public class MenuTree {

	private String name;//
	private List<Menu> menus;//菜单集合
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	
	
}
