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
import com.driverinfo.entity.CompanyDataGrid;
import com.driverinfo.entity.EntityCompany;
import com.driverinfo.hibernateEntity.Areas;
import com.driverinfo.hibernateEntity.Company;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.drivercms.cdcms.Company
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class CompanyDAO {
	private static final Logger log = Logger.getLogger(CompanyDAO.class);
	// property constants
	public static final String ALL_NAME = "allName";
	public static final String SIMPLE_NAME = "simpleName";
	public static final String PHONE = "phone";
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

	public void save(Company transientInstance) {
		log.debug("saving Company instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Company persistentInstance) {
		log.debug("deleting Company instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Company findById(java.lang.Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			Company instance = (Company) getCurrentSession().get(
					"com.drivercms.cdcms.Company", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Company instance) {
		log.debug("finding Company instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.Company")
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
		log.debug("finding Company instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Company as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAllName(Object allName) {
		return findByProperty(ALL_NAME, allName);
	}

	public List findBySimpleName(Object simpleName) {
		return findByProperty(SIMPLE_NAME, simpleName);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List findAll() {
		log.debug("finding all Company instances");
		try {
			String queryString = "from Company";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Company merge(Company detachedInstance) {
		log.debug("merging Company instance");
		try {
			Company result = (Company) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Company instance) {
		log.debug("attaching dirty Company instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Company instance) {
		log.debug("attaching clean Company instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CompanyDAO) ctx.getBean("CompanyDAO");
	}

	
    ///查询用户下所有的下级公司
	public CompanyDataGrid findAll(User user,Integer page,Integer rows) {
		 int pg=(page - 1)* rows;
		 Query query=null;
		 CompanyDataGrid cdg=new CompanyDataGrid();
		 try {
			 //公司用户,直接取出公司
			 Integer i= user.getCompanyid();//所属公司
			 Areas area=user.getAreas();//所属地区
			 if(area==null){//全部查看
				query=  getCurrentSession().createSQLQuery("select c.id, c.allName,c.simpleName,c.phone,c.createtime, a.name from company as c inner join area as a on c.areaid=a.id order by a.code");
				query.setFirstResult(pg);
				query.setMaxResults(rows);
			    List listCom=	query.list();
			    query=getCurrentSession().createSQLQuery("select count(c.id) from company as c inner join area as a on c.areaid=a.id");
				cdg.setRows(bindEntity(listCom));
			    List obj= query.list();
				cdg.setTotal(Integer.parseInt(obj.get(0).toString()));
			//地区用户
			}else{
				String hql="select c.id, c.allName,c.simpleName,c.phone,c.createtime, a.name from company as c inner join area as a on c.areaid=a.id and c.areaid="+area.getId();
				hql+="order by a.code";
				String totalHql="select count(c.id)from company as c inner join area as a on c.areaid=a.id and c.areaid="+area.getId();
				query= getCurrentSession().createSQLQuery(hql);
				query.setInteger(0,user.getAreas().getId());
				query.setInteger(1,pg);
				query.setInteger(2, rows);
				List<Company> listCom= query.list();
				 
				query= getCurrentSession().createSQLQuery(totalHql);
				query.setInteger(0, user.getAreas().getId());
				List obj= query.list();
				cdg.setRows(bindEntity(listCom));
				cdg.setTotal(Integer.parseInt(obj.get(0).toString()));
			}
		} catch (Exception e) {
			
		}
		 
		return cdg;
	}
	
	
	//实体绑定
	private List<EntityCompany> bindEntity(List list){
		List<EntityCompany> ls= new ArrayList<EntityCompany>();
		if(list!=null&&list.size()!=0){
			for (int i = 0; i < list.size(); i++) {
				EntityCompany ne=new EntityCompany();
				Object[] obj=(Object[])list.get(i);
				ne.setId(Integer.parseInt(obj[0].toString()));
				ne.setAllName(obj[1].toString());
				ne.setSimpleName(obj[2].toString());
			    ne.setPhone(obj[3].toString());
			    ne.setCreatetime(Timestamp.valueOf(obj[4].toString()));
			    ne.setArea(obj[5].toString());
			    ls.add(ne);
			}
		}
		return ls;
	}
	
	
	
	
	
}