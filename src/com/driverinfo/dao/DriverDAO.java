package com.driverinfo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.driverinfo.entity.CompanyDataGrid;
import com.driverinfo.entity.DriverDatagrid;
import com.driverinfo.entity.EntityDriver;
import com.driverinfo.hibernateEntity.Areas;
import com.driverinfo.hibernateEntity.Driver;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Driver entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.drivercms.cdcms.Driver
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class DriverDAO {
	private static final Logger log = LoggerFactory.getLogger(DriverDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String SFZH = "sfzh";
	public static final String ZGZH = "zgzh";
	public static final String ADDRESS = "address";
	public static final String LXDH = "lxdh";
	public static final String DRIVER_NO = "driverNo";
	public static final String STATUS = "status";
	public static final String DRIVER_LEVEL = "driverLevel";

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

	public void save(Driver transientInstance) {
		log.debug("saving Driver instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Driver persistentInstance) {
		log.debug("deleting Driver instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Driver findById(java.lang.Integer id) {
		log.debug("getting Driver instance with id: " + id);
		try {
			Driver instance = (Driver) getCurrentSession().get(
					"com.drivercms.cdcms.Driver", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Driver instance) {
		log.debug("finding Driver instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.Driver")
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
		log.debug("finding Driver instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Driver as model where model."
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

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findBySfzh(Object sfzh) {
		return findByProperty(SFZH, sfzh);
	}

	public List findByZgzh(Object zgzh) {
		return findByProperty(ZGZH, zgzh);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByLxdh(Object lxdh) {
		return findByProperty(LXDH, lxdh);
	}

	public List findByDriverNo(Object driverNo) {
		return findByProperty(DRIVER_NO, driverNo);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDriverLevel(Object driverLevel) {
		return findByProperty(DRIVER_LEVEL, driverLevel);
	}

	public List findAll() {
		log.debug("finding all Driver instances");
		try {
			String queryString = "from Driver";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Driver merge(Driver detachedInstance) {
		log.debug("merging Driver instance");
		try {
			Driver result = (Driver) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Driver instance) {
		log.debug("attaching dirty Driver instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Driver instance) {
		log.debug("attaching clean Driver instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DriverDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DriverDAO) ctx.getBean("DriverDAO");
	}

	
	//
	public DriverDatagrid findAll(User user, Integer page, Integer rows) {
		 int pg=(page - 1)* rows;
		 Query query=null;
		 DriverDatagrid cdg=new DriverDatagrid();
		Areas area= user.getAreas();
		if(area==null){
			//查看全部
			String hql="select d.id,d.name,d.sex,d.sfzh,d.zgzh,d.address,d.lxdh,d.driverNo,d.driverLevel,d.createtime from driver as d";
			String total="select count(d.id) from driver as d";
			query= getCurrentSession().createSQLQuery(hql);
			query.setFirstResult(pg);
			query.setMaxResults(rows);
			List list=  query.list();
			 
			query= getCurrentSession().createSQLQuery(total);
			List count=  query.list();
			cdg.setRows(bindEntity(list));
			cdg.setTotal(Integer.parseInt(count.get(0).toString()));
		}else{
			
		}
		return cdg;
	}
	
	
	private List<EntityDriver> bindEntity(List list){
		List<EntityDriver> ls=new ArrayList<EntityDriver>();
		if(list.size()!=0&&list!=null){
			for (int i = 0; i < list.size(); i++) {
				EntityDriver d=new EntityDriver();
				Object[] obj=(Object[])list.get(i);
				d.setId(Integer.parseInt(obj[0].toString()));
				d.setName(obj[1].toString());
				d.setSex(obj[2].toString());
				d.setSfzh(obj[3].toString());
				d.setZgzh(obj[4].toString());
				d.setAddress(obj[5].toString());
				d.setLxdh(obj[6].toString());
				d.setDriverNo(obj[7].toString());
				d.setDriverLevel(obj[8].toString());
				d.setCreatetime(Timestamp.valueOf(obj[9].toString()));
				ls.add(d);
			}
		}
		return ls;
	}
	
	
	
	
}