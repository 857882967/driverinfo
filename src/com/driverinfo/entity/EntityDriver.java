package com.driverinfo.entity;

import java.sql.Timestamp;

//司机实例对应model.Driver 用于 toExcel
public class EntityDriver {

	// Fields
	//.d.lxdh,d.driverNo,d.driverLevel,d.createtime
	
		private Integer id;
		private String name;
		private String sex;
		private String zgzh;
		private String sfzh;
		private String address;
		private String lxdh;
		private String driverNo;
		private String driverLevel;
		private String company;
		private Timestamp createtime;
		private Timestamp updateTime;
		
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getZgzh() {
			return zgzh;
		}
		public void setZgzh(String zgzh) {
			this.zgzh = zgzh;
		}
		public String getSfzh() {
			return sfzh;
		}
		public void setSfzh(String sfzh) {
			this.sfzh = sfzh;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getLxdh() {
			return lxdh;
		}
		public void setLxdh(String lxdh) {
			this.lxdh = lxdh;
		}
		public String getDriverNo() {
			return driverNo;
		}
		public void setDriverNo(String driverNo) {
			this.driverNo = driverNo;
		}
		public String getDriverLevel() {
			return driverLevel;
		}
		public void setDriverLevel(String driverLevel) {
			this.driverLevel = driverLevel;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public Timestamp getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Timestamp createtime) {
			this.createtime = createtime;
		}
		public Timestamp getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Timestamp updateTime) {
			this.updateTime = updateTime;
		}
		
		
}
