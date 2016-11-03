package com.driverinfo.entity;

import java.util.List;

import com.driverinfo.oldHibernateModel.Company;


public class CompanyDataGrid {

	private int total;
	private List<EntityCompany> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<EntityCompany> getRows() {
		return rows;
	}
	public void setRows(List<EntityCompany> rows) {
		this.rows = rows;
	}
}
