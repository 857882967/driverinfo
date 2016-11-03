package com.driverinfo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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

import com.driverinfo.dao.UserDAO;
import com.driverinfo.entity.DatagridUserEntity;
import com.driverinfo.hibernateEntity.User;

/**
 * @see com.driverinfo.model.oldhbm.drivercms.test.User
 * @author MyEclipse Persistence Tools
 */
@Service
public class UserService {
	


	@Resource(name="userDAO",type=UserDAO.class)
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public List<User> findByNamePasss(String name,String pass){
		return userDAO.findByNamePass(name, pass);
	}


	public List<User> findByUser(User user, String page, String rows) {
		
		return userDAO.findByUser(user,page,rows);
	}


	
	


	public DatagridUserEntity findUsersByParm(String page, String rows, String parm,String userid) {
		return userDAO.findUsersByParm(page,rows,parm,userid);
	}


	public DatagridUserEntity findUsersByUser(String page, String rows, User user) {
		// TODO Auto-generated method stub
		return userDAO.findUsersByUser( page, rows,user);
	}


	
	public int deleteByUid(String uid, String name) {
		return userDAO.deleteByUid(uid,name);
	}
	
	
	
	
	
	
}