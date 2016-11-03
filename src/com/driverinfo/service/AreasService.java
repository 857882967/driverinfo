package com.driverinfo.service;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.driverinfo.dao.AreaDAO;
import com.driverinfo.dao.AreasDAO;
import com.driverinfo.hibernateEntity.Areas;

/** 
 * @see com.driverinfo.model.oldhbm.drivercms.test.Area
 * @author MyEclipse Persistence Tools
 */
@Service
public class AreasService {
	
	

	@Resource(name="areasDAO",type=AreasDAO.class)
	private AreasDAO areasDAO;

	public void setAreasDAO(AreasDAO areasDAO) {
		this.areasDAO = areasDAO;
	}

	
	

	public List<Areas> findAllProvince() {
		// TODO Auto-generated method stub
		return areasDAO.findAllProvince();
	}


	
	
	
	
	
	
	
	
}