package com.driverinfo.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.driverinfo.dao.DriverDAO;
import com.driverinfo.entity.DriverDatagrid;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Driver entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.driverinfo.model.oldhbm.drivercms.test.Driver
 * @author MyEclipse Persistence Tools
 */
@Service
public class DriverService {

	@Resource(name="driverDAO",type=DriverDAO.class)
	private DriverDAO driverDAO;

	
	public void setDriverDAO(DriverDAO driverDAO) {
		this.driverDAO = driverDAO;
	}
	
	
	
	
	public DriverDatagrid findAll(User user, Integer page, Integer rows) {
		
		return driverDAO.findAll(user,page,rows);
	}
	
	
	
	
	
	
}