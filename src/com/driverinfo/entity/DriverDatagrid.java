package com.driverinfo.entity;

import java.util.List;

import com.driverinfo.oldHibernateModel.Driver;


public class DriverDatagrid {

	private int total;
	
	private List<EntityDriver> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<EntityDriver> getRows() {
		return rows;
	}

	public void setRows(List<EntityDriver> rows) {
		this.rows = rows;
	}
	
	
	
}
