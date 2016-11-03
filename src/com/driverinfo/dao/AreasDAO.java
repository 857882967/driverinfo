package com.driverinfo.dao;

import java.util.ArrayList;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.driverinfo.entity.MessModule;
import com.driverinfo.hibernateEntity.Areas;


/**
 * A data access object (DAO) providing persistence and search support for Area
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.drivercms.cdcms.Area
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class AreasDAO {
	private static final Logger log = Logger.getLogger(AreasDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String FATHERCODE = "fathercode";
	public static final String LEVEL = "level";

	@Resource(name="sessionFactory",type=SessionFactory.class)
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}
	
	
	//查询所有省
	public List<Areas> findAllProvince() {
	
		List<Areas> lsAreas=new ArrayList<>();
		try {
			Query query=getCurrentSession().createQuery("from Areas where level=?");
			query.setInteger(0,1);
			 lsAreas= query.list();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsAreas;
	}
	
	
	
	
	
	
	
	
	
}
