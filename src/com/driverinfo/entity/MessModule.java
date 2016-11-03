package com.driverinfo.entity;

//数据模型
public class MessModule {

	private String name;
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MessModule(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public MessModule() {
		super();
	}
	
	
}
