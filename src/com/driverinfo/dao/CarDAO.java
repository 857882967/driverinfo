package com.driverinfo.dao;


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
import com.driverinfo.entity.DatagridCar;
import com.driverinfo.hibernateEntity.Car;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for Car
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.drivercms.cdcms.Car
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class CarDAO {
	private static final Logger log = Logger.getLogger(CarDAO.class);
	// property constants
	public static final String CHP = "chp";
	public static final String CARTYPE = "cartype";
	public static final String CARCOLOR = "carcolor";
	public static final String ENGINE_NO = "engineNo";
	public static final String OPERATION_STATE = "operationState";
	public static final String STATUS = "status";
	public static final String COMPANYID = "companyid";
	public static final String TRAVELID = "travelid";
	public static final String RESTRICT_DATE = "restrictDate";
	public static final String CREATORID = "creatorid";

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

	public void save(Car transientInstance) {
		log.debug("saving Car instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Car persistentInstance) {
		log.debug("deleting Car instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Car findById(java.lang.Integer id) {
		log.debug("getting Car instance with id: " + id);
		try {
			Car instance = (Car) getCurrentSession().get(
					"com.drivercms.cdcms.Car", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Car instance) {
		log.debug("finding Car instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.Car")
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
		log.debug("finding Car instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Car as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChp(Object chp) {
		return findByProperty(CHP, chp);
	}

	public List findByCartype(Object cartype) {
		return findByProperty(CARTYPE, cartype);
	}

	public List findByCarcolor(Object carcolor) {
		return findByProperty(CARCOLOR, carcolor);
	}

	public List findByEngineNo(Object engineNo) {
		return findByProperty(ENGINE_NO, engineNo);
	}

	public List findByOperationState(Object operationState) {
		return findByProperty(OPERATION_STATE, operationState);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByCompanyid(Object companyid) {
		return findByProperty(COMPANYID, companyid);
	}

	public List findByTravelid(Object travelid) {
		return findByProperty(TRAVELID, travelid);
	}

	public List findByRestrictDate(Object restrictDate) {
		return findByProperty(RESTRICT_DATE, restrictDate);
	}

	public List findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List findAll() {
		log.debug("finding all Car instances");
		try {
			String queryString = "from Car";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Car merge(Car detachedInstance) {
		log.debug("merging Car instance");
		try {
			Car result = (Car) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Car instance) {
		log.debug("attaching dirty Car instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Car instance) {
		log.debug("attaching clean Car instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CarDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CarDAO) ctx.getBean("CarDAO");
	}

	
	public DatagridCar findAll(User user, Integer page, Integer rows) {
		int pg=(page - 1)* rows;
		 Query query=null;
		 DatagridCar cdg=new DatagridCar();
		 
		 try {
			 
			query=getCurrentSession().createQuery("from Car");
			query.setFirstResult(pg);
			query.setMaxResults(rows);
			cdg.setRows( query.list());
			query= getCurrentSession().createSQLQuery("select count(id) from Car");
			List count= query.list();
			cdg.setTotal(Integer.parseInt(count.get(0).toString()));
			
		} catch (Exception e) {
			
		}
		 
		return cdg;
	}
	
	
	
	
}