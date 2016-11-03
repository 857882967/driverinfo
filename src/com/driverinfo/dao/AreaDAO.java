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
public class AreaDAO {
	private static final Logger log = Logger.getLogger(AreaDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String FATHERCODE = "fathercode";

	@Resource(name="sessionFactory",type=SessionFactory.class)
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Areas transientInstance) {
		log.debug("saving Area instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	

	public void delete(Areas persistentInstance) {
		log.debug("deleting Area instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Areas findById(java.lang.Integer id) {
		log.debug("getting Area instance with id: " + id);
		try {
			Areas instance = (Areas) getCurrentSession().get(
					"com.drivercms.cdcms.Area", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Areas instance) {
		log.debug("finding Area instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.Area")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Area instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Area as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByFathercode(Object fathercode) {
		return findByProperty(FATHERCODE, fathercode);
	}

	public List findAll() {
		log.debug("finding all Area instances");
		try {
			String queryString = "from Area";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Areas merge(Areas detachedInstance) {
		log.debug("merging Area instance");
		try {
			Areas result = (Areas) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Areas instance) {
		log.debug("attaching dirty Area instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Areas instance) {
		log.debug("attaching clean Area instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AreaDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AreaDAO) ctx.getBean("AreaDAO");
	}

	
	
	
	
	public List<Areas> findByAreaid(Integer id) {
		Query query=getCurrentSession().createQuery("");
		return query.list();
	}

	//添加地区
	public MessModule addArea(String cmbProvince, String cmbCity, String cmbArea) {
		
		
		return null;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Integer i=1000;
		System.out.println(i.toString());
	}

	
	
	//查询所有省
	public List<Areas> findAllProvince() {
		List<Areas> lsAreas=new ArrayList<>();
		try {
			Query query=getCurrentSession().createQuery("from Areas where level=1");
			 lsAreas= query.list();		
		} catch (Exception e) {
			
		}
		return lsAreas;
	}
	
	
	
	
	
	
	
	
}
