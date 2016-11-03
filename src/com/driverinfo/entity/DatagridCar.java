package com.driverinfo.entity;

import java.util.List;

import com.driverinfo.oldHibernateModel.User;


/**
 * 用户数据模板
 * @author Mander
 *
 */
public class DatagridCar {

	private int total;
	
	private List<EntityCar> rows;
	
	
	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<EntityCar> getRows() {
		return rows;
	}

	public void setRows(List<EntityCar> rows) {
		this.rows = rows;
	}

	
	
	
	
	
	
}
