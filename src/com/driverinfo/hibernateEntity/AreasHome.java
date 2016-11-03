package com.driverinfo.hibernateEntity;
// Generated 2016-10-26 10:27:41 by Hibernate Tools 4.3.1.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Areas.
 * @see com.drivercms.hbernateModel.Areas
 * @author Hibernate Tools
 */


public class AreasHome {

	private static final Log log = LogFactory.getLog(AreasHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Areas transientInstance) {
		log.debug("persisting Areas instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Areas persistentInstance) {
		log.debug("removing Areas instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Areas merge(Areas detachedInstance) {
		log.debug("merging Areas instance");
		try {
			Areas result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Areas findById(Integer id) {
		log.debug("getting Areas instance with id: " + id);
		try {
			Areas instance = entityManager.find(Areas.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	
	
	
}
