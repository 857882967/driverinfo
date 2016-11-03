package com.driverinfo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.driverinfo.hibernateEntity.UserRole;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.drivercms.cdcms.UserRole
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class UserRoleDAO {
	private static final Logger log = Logger
			.getLogger(UserRoleDAO.class);
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

	public void save(UserRole transientInstance) {
		log.debug("saving UserRole instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserRole persistentInstance) {
		log.debug("deleting UserRole instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserRole findById(java.lang.Integer id) {
		log.debug("getting UserRole instance with id: " + id);
		try {
			UserRole instance = (UserRole) getCurrentSession().get(
					"com.drivercms.cdcms.UserRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserRole instance) {
		log.debug("finding UserRole instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.UserRole")
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
		log.debug("finding UserRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserRole as model where model."
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
		log.debug("finding all UserRole instances");
		try {
			String queryString = "from UserRole";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserRole merge(UserRole detachedInstance) {
		log.debug("merging UserRole instance");
		try {
			UserRole result = (UserRole) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserRole instance) {
		log.debug("attaching dirty UserRole instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserRole instance) {
		log.debug("attaching clean UserRole instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserRoleDAO) ctx.getBean("UserRoleDAO");
	}

	//根据用户获取角色的下级角色
	public List<Role> findNextByUserid(Integer uid) {
		 List<Role> ls=null;
		try {
			StringBuffer sql= new StringBuffer("select * from role where level >( select ro.level from userRole as ur inner join role as ro on ro.id= ur.roleid where ur.userid=");
			sql.append("1)");
			Query query=getCurrentSession().createSQLQuery(sql.toString());
			List list= query.list();
			ls=bind(list);
		} catch (Exception e) {
			
		}
		return ls;
	}
	
	
	//绑定
	private List<Role> bind(List list){
		List<Role> ls=new ArrayList<>();
		if(list!=null&&list.size()!=0){
		   for (int i = 0; i < list.size(); i++) {
			   Role role=new Role();
		   	Object[] obj= (Object[]) list.get(i);
		   	role.setId(Integer.parseInt(obj[0].toString()));
		   	role.setName(obj[1].toString());
		   	role.setTitle(obj[2].toString());
		   	role.setEnable(Integer.parseInt(obj[3].toString()));
		   	role.setLevel(Integer.parseInt(obj[4].toString()));
		   	role.setDesciption(obj[5].toString());
		   	role.setCreator(Integer.parseInt(obj[6].toString()));
		   	role.setCreatetime(Timestamp.valueOf(obj[7].toString()));
		   	role.setUpdatetime(Timestamp.valueOf(obj[8].toString()));
		   	if(obj[9]!=null){
		   		role.setAreaid(Integer.parseInt(obj[9].toString()));	
		   	}
		   	ls.add(role);
		   }
		 }
		return ls;
	}
	
	
	
	
	
	
}