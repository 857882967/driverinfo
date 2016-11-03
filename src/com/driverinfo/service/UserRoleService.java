package com.driverinfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.driverinfo.dao.UserRoleDAO;
import com.driverinfo.hibernateEntity.Role;
import com.driverinfo.oldHibernateModel.UserRole;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.driverinfo.model.oldhbm.drivercms.test.UserRole
 * @author MyEclipse Persistence Tools
 */
@Service
public class UserRoleService {
	private static final Logger log = LoggerFactory
			.getLogger(UserRoleService.class);
	// property constants

	@Resource(name="userRoleDAO",type=UserRoleDAO.class)
	private UserRoleDAO userRoleDAO;
	
	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	//根据用户名获取下级角色类型
	public List<Role> findNextByUserid(Integer uid) {
		return userRoleDAO.findNextByUserid(uid);
		
	}
}