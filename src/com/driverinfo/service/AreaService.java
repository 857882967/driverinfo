package com.driverinfo.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.driverinfo.dao.AreaDAO;
import com.driverinfo.entity.MessModule;
import com.driverinfo.hibernateEntity.Areas;

/** 
 * @see com.driverinfo.model.oldhbm.drivercms.test.Area
 * @author MyEclipse Persistence Tools
 */
@Service
public class AreaService {
	
	

	@Resource(name="areaDAO",type=AreaDAO.class)
	private AreaDAO areaDAO;


	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	
	@SuppressWarnings("unchecked")
	public List<Areas> findAll(){
		return areaDAO.findAll();
	}

	public List<Areas> findByAreaid(Integer id) {		
		return  areaDAO.findByAreaid(id);
	}

	public MessModule addArea(String cmbProvince, String cmbCity, String cmbArea) {
		return areaDAO.addArea(cmbProvince,cmbCity,cmbArea);
	}

	public List<Areas> findAllProvince() {
		
		return areaDAO.findAllProvince();
	}
	
	
	
	
	
}