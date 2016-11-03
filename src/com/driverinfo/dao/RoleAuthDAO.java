package com.driverinfo.dao;

import java.util.List;

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

import com.driverinfo.hibernateEntity.RoleAuth;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleAuth entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.drivercms.cdcms.RoleAuth
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class RoleAuthDAO {
	private static final Logger log = Logger
			.getLogger(RoleAuthDAO.class);
	// property constants

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

	public void save(RoleAuth transientInstance) {
		log.debug("saving RoleAuth instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleAuth persistentInstance) {
		log.debug("deleting RoleAuth instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleAuth findById(java.lang.Integer id) {
		log.debug("getting RoleAuth instance with id: " + id);
		try {
			RoleAuth instance = (RoleAuth) getCurrentSession().get(
					"com.drivercms.cdcms.RoleAuth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleAuth instance) {
		log.debug("finding RoleAuth instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.RoleAuth")
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
		log.debug("finding RoleAuth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleAuth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all RoleAuth instances");
		try {
			String queryString = "from RoleAuth";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleAuth merge(RoleAuth detachedInstance) {
		log.debug("merging RoleAuth instance");
		try {
			RoleAuth result = (RoleAuth) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleAuth instance) {
		log.debug("attaching dirty RoleAuth instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleAuth instance) {
		log.debug("attaching clean RoleAuth instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleAuthDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoleAuthDAO) ctx.getBean("RoleAuthDAO");
	}
}