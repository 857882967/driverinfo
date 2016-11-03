package com.driverinfo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.driverinfo.dao.AreaDAO;
import com.driverinfo.dao.CarDAO;
import com.driverinfo.entity.DatagridCar;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for Car
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.driverinfo.model.oldhbm.drivercms.test.Car
 * @author MyEclipse Persistence Tools
 */
@Service
public class CarService {


	@Resource(name="carDAO",type=CarDAO.class)
	private CarDAO carDAO;
	
	public void setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
	}


	public DatagridCar findAll(User user, Integer page, Integer rows) {
		
		return carDAO.findAll(user,page,rows);
	}
	
	
	
	
	
	
}