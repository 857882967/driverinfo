package com.driverinfo.entity;

import java.util.List;

import com.driverinfo.oldHibernateModel.User;


/**
 * 用户数据模板
 * @author Mander
 *
 */
public class DatagridUserEntity {

	private int total;
	
	private List<UserEntity> rows;
	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<UserEntity> getRows() {
		return rows;
	}

	public void setRows(List<UserEntity> rows) {
		this.rows = rows;
	}

	

	
	
	
	
	
}
