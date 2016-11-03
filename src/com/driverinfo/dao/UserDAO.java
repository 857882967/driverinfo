package com.driverinfo.dao;

import java.sql.Timestamp;
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

import com.driverinfo.entity.DatagridUserEntity;
import com.driverinfo.entity.UserEntity;
import com.driverinfo.hibernateEntity.Areas;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.drivercms.cdcms.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class UserDAO {
	private static final Logger log = Logger.getLogger(UserDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String CNAME = "cname";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String CREATOR = "creator";
	public static final String COMPANYID = "companyid";

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

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get(
					"com.drivercms.cdcms.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.User")
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
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
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

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByCreator(Object creator) {
		return findByProperty(CREATOR, creator);
	}

	public List findByCompanyid(Object companyid) {
		return findByProperty(COMPANYID, companyid);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}

	
	public List<User> findByNamePass(String name, String pass) {
		Query query=getCurrentSession().createQuery("from User where name=? and password=?");
		query.setString(0, name);
		query.setString(1, pass);
		return query.list();
	}

	
	public List<User> findByUser(User user, String page, String rows) {
		
		return null;
	}

	
	public DatagridUserEntity findUsersByParm(String page, String rows, String parm,String userid) {
		
		Query query=getCurrentSession().createQuery("");
		
		
		return null;
	}

	//查询所管辖地区的用户，超级管理员不受地区限制查询所有
	@SuppressWarnings("unchecked")
	public DatagridUserEntity findUsersByUser(String page, String rows, User user) {
		DatagridUserEntity due=new DatagridUserEntity();
		List<UserEntity> ls= new ArrayList<UserEntity>();
		 StringBuffer bu=new StringBuffer();
		 int pg=(Integer.parseInt(page) - 1) * Integer.parseInt(rows);
		 Areas area= user.getAreas();
         if(area!=null){//非系统超级用户
        	 String code = user.getAreas().getCode();      	
        		 bu.append("select u.id as id, u.name as name,u.cname as cname,a.name as areaName,u.createtime from user as u, area as a  where u.areaid=a.id and  areaid in(");
        		 bu.append("select id from area where fathercode =");
        		 bu.append(code);
        		 bu.append(") limit ");
        		 bu.append(pg);
        		 bu.append(",");
        		 bu.append(rows);
        		 Query query = getCurrentSession().createSQLQuery(bu.toString());
        		 List lss =query.list();
        		ls= bindEntityUser(lss);		 
        	     String countsql= "select count(u.id) from user as u, area as a  where u.areaid=a.id and  areaid in(select id from area where fathercode =";
        	     countsql+=code;
        	     countsql+=")";
        	     List count= getCurrentSession().createSQLQuery(countsql).list();
        	     due.setRows(ls);
        	     due.setTotal(Integer.parseInt(count.get(0).toString()));       	     
        	// }
         }else{
        	//超级用户查询所有的地区用户
        	 //select u.name as username,u.cname,a.name  from user as u,area as a where u.areaid=a.id  order by areaid asc  limit 0,10 

        	 bu.append("select u.id as id, u.name as name,u.cname as cname ,a.name as areaName,u.createtime from user as u,area as a where u.areaid=a.id  order by areaid asc  limit ");
        	 bu.append(pg);
        	 bu.append(",");
        	 bu.append(rows);
        	 Query query= getCurrentSession().createSQLQuery(bu.toString());
        	 List lss=query.list();
        	 ls=bindEntityUser( lss );
        	 String totalsql="select count(u.id) from user as u,area as a where u.areaid=a.id ";
        	 Query tatolQuery= getCurrentSession().createSQLQuery(totalsql);
        	 List tatals= tatolQuery.list();
        	 due.setTotal(Integer.parseInt(tatals.get(0).toString()));
        	 due.setRows(ls);
         }
		return due;
	}
	
	
	
	
	
	
	//绑定实体
	public List<UserEntity> bindEntityUser(List ls ){
		List<UserEntity> Lseu=new ArrayList<UserEntity>() ;
	  if(!ls.isEmpty()){
		for (int i = 0; i < ls.size(); i++) {
			UserEntity eu=new UserEntity();
		  Object[] obj=(Object[])ls.get(i);
		  eu.setId(Integer.parseInt(obj[0].toString()));
		  eu.setName(obj[1].toString());
		  eu.setCname(obj[2].toString());
		  eu.setAreaName(obj[3].toString());
		  eu.setCreatetime(Timestamp.valueOf(obj[4].toString()));
		  Lseu.add(eu);
	   }	
	 }
		return Lseu;
	}

	//删除
	public int deleteByUid(String uid, String name) {
		int i=0;
		try {
		Query query=getCurrentSession().createQuery("delete from User where id=?");
		query.setString(0, uid);
		 i= query.executeUpdate();
		 log.info(name+"删除用户");
		} catch (Exception e) {
			i=0;
		}
		return i;
	}
	
	
	
	
	
}

