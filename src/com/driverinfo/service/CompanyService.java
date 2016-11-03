package com.driverinfo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.driverinfo.dao.CompanyDAO;
import com.driverinfo.entity.CompanyDataGrid;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.driverinfo.model.oldhbm.drivercms.test.Company
 * @author MyEclipse Persistence Tools
 */
@Service
public class CompanyService {
	private static final Logger log = Logger.getLogger(CompanyService.class);
	// property constants
	
	@Resource(name="companyDAO",type=CompanyDAO.class)
	private CompanyDAO companyDAO;

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	
	public CompanyDataGrid findAll(User user,Integer page,Integer rows) {
		// TODO Auto-generated method stub
		return companyDAO.findAll(user,page,rows);
	}
	
	
	
	
	
	
	
	
	
	
}