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

import com.driverinfo.hibernateEntity.Role;


/**
 * A data access object (DAO) providing persistence and search support for Role
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.drivercms.cdcms.Role
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class RoleDAO {
	private static final Logger log = Logger.getLogger(RoleDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TITLE = "title";
	public static final String ENABLE = "enable";
	public static final String LEVEL = "level";
	public static final String DESCIPTION = "desciption";
	public static final String CREATOR = "creator";
	public static final String AREAID = "areaid";

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

	public void save(Role transientInstance) {
		log.debug("saving Role instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Role persistentInstance) {
		log.debug("deleting Role instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Role findById(java.lang.Integer id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = (Role) getCurrentSession().get(
					"com.drivercms.cdcms.Role", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Role instance) {
		log.debug("finding Role instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.Role")
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
		log.debug("finding Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Role as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByDesciption(Object desciption) {
		return findByProperty(DESCIPTION, desciption);
	}

	public List findByCreator(Object creator) {
		return findByProperty(CREATOR, creator);
	}

	public List findByAreaid(Object areaid) {
		return findByProperty(AREAID, areaid);
	}

	public List findAll() {
		log.debug("finding all Role instances");
		try {
			String queryString = "from Role";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Role merge(Role detachedInstance) {
		log.debug("merging Role instance");
		try {
			Role result = (Role) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Role instance) {
		log.debug("attaching dirty Role instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Role instance) {
		log.debug("attaching clean Role instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoleDAO) ctx.getBean("RoleDAO");
	}

	
//	public List<Role> findbyUser(String userid) {
//	    Query query=getCurrentSession().createSQLQuery("").addEntity(Role.class);
//	     List<Role> ls= query.list();
//		return ls;
//	}
	
	
	
	
}