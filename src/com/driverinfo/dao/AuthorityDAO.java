package com.driverinfo.dao;

import java.util.ArrayList;
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

import com.driverinfo.hibernateEntity.Authority;
import com.driverinfo.hibernateEntity.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authority entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.drivercms.cdcms.Authority
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class AuthorityDAO {
	private static final Logger log = Logger
			.getLogger(AuthorityDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TITLE = "title";
	public static final String CODE = "code";
	public static final String FATHERCODE = "fathercode";
	public static final String TYPE = "type";
	public static final String URL = "url";
	public static final String ICON = "icon";
	public static final String DESCIPTION = "desciption";
	public static final String CREATORID = "creatorid";
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

	public void save(com.driverinfo.hibernateEntity.Authority transientInstance) {
		log.debug("saving Authority instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Authority persistentInstance) {
		log.debug("deleting Authority instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Authority findById(java.lang.Integer id) {
		log.debug("getting Authority instance with id: " + id);
		try {
			Authority instance = (Authority) getCurrentSession().get(
					"com.drivercms.cdcms.Authority", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Authority instance) {
		log.debug("finding Authority instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.drivercms.cdcms.Authority")
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
		log.debug("finding Authority instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Authority as model where model."
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

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findByFathercode(Object fathercode) {
		return findByProperty(FATHERCODE, fathercode);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByDesciption(Object desciption) {
		return findByProperty(DESCIPTION, desciption);
	}

	public List findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List findByAreaid(Object areaid) {
		return findByProperty(AREAID, areaid);
	}

	public List findAll() {
		log.debug("finding all Authority instances");
		try {
			String queryString = "from Authority";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Authority merge(Authority detachedInstance) {
		log.debug("merging Authority instance");
		try {
			Authority result = (Authority) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Authority instance) {
		log.debug("attaching dirty Authority instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Authority instance) {
		log.debug("attaching clean Authority instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AuthorityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AuthorityDAO) ctx.getBean("AuthorityDAO");
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Authority> findbyRoleid(String userid) {
		
		StringBuffer bu=new StringBuffer("select * from authority where id in(");
		bu.append("SELECT authorityid from roleAuth where roleid in (");
		bu.append("select roleid from userRole WHERE userid=");
		bu.append(userid);
		bu.append("))");
		
		
		System.out.println(bu.toString());
		Query query= getCurrentSession().createSQLQuery(bu.toString()).addEntity(Authority.class);
		 List<Authority> ls= query.list();
		return ls;
	}

	//查询用户匹配的角色功能模块的名称的功能按钮
	@SuppressWarnings("unchecked")
	public List<Authority> findAuthorityButton(String userid, String authorithName) {
		List<Authority> liau=new ArrayList<Authority>();
		StringBuffer buffer=new StringBuffer("select au.id,au.name,au.title,au.code,au.fathercode, au.type,au.url,au.icon from authority as au inner join roleAuth as ro on au.id=ro.authorityid  where ro.roleid=");
		buffer.append("(select roleid from userRole where userid=");
		buffer.append(userid+")");
		buffer.append("and type='button' and name='");
		buffer.append(authorithName);
		buffer.append("'");
		Query query=getCurrentSession().createSQLQuery(buffer.toString());
		List list=query.list();
		if(list!=null&&list.size()!=0){
	    	for (Object object : list) {
				Object[] obj=(Object[])object;
				Authority au=new Authority();
				au.setId(Integer.parseInt(obj[0].toString()));
				au.setName(obj[1].toString());
				au.setTitle(obj[2].toString());
				au.setCode(obj[3].toString());
				if(obj[4]!=null){
					au.setFathercode(obj[4].toString());
				}
				au.setType(obj[5].toString());
				au.setUrl(obj[6].toString());
				au.setIcon(obj[7].toString());
				liau.add(au);
			}
	    }
		
		return liau;
	}
	
	

	//查角色的所有功能
	@SuppressWarnings("unchecked")
	public List<Authority> findByRoleid(String roleId) {	
		String hql="select au.id,au.name,au.title,au.code,au.fathercode, au.type,au.url,au.icon from Authority as au INNER JOIN RoleAuth as ro on ro.authorityid=au.id where ro.roleid=";
		Query query=getCurrentSession().createSQLQuery(hql+roleId);
		List<Authority> liau=new ArrayList<Authority>();
		try {
			List list= query.list();
		    if(list!=null&&list.size()!=0){
		    	for (Object object : list) {
					Object[] obj=(Object[])object;
					Authority au=new Authority();
					au.setId(Integer.parseInt(obj[0].toString()));
					au.setName(obj[1].toString());
					au.setTitle(obj[2].toString());
					au.setCode(obj[3].toString());
					if(obj[4]!=null){
						au.setFathercode(obj[4].toString());
					}
					au.setType(obj[5].toString());
					au.setUrl(obj[6].toString());
					au.setIcon(obj[7].toString());
					liau.add(au);
				}
		    }
		} catch (Exception e) {
			
		}
		
	  return liau;
	}
	
	
	//类型转换
	private List<Authority>  convertToAuthority(List ls){
		List<Authority> list=new ArrayList<>();
	   if(ls.size()!=0&&ls!=null){
		   for (int i = 0; i <ls.size(); i++) {
			Authority auth=new Authority();
	    	Object[] obj= (Object[]) ls.get(i);
	    	auth.setId(Integer.parseInt(obj[0].toString()));
	    	auth.setName(obj[1].toString());
	    	auth.setTitle(obj[2].toString());
	    	auth.setCode(obj[3].toString());
	    	if(obj[4]!=null){
	    		auth.setFathercode(obj[4].toString());
	    	}
	    	auth.setType(obj[5].toString());
	    	auth.setUrl(obj[6].toString());
	    	auth.setIcon(obj[7].toString());
	    	auth.setDesciption(obj[8].toString());
	    	list.add(auth);
		} 
	   }	return list;
	}

	
	/**
	 * 查询用户功能
	 * @param user
	 * @return
	 */
	public List<Authority> findByUser(User user) {
		//select * from authority as au where id in(
		 //select ro.authorityid from roleAuth as ro inner join userRole as us on ro.roleid=us.roleid and us.roleid=1)
		List<Authority> ls=new ArrayList<Authority>();
		try {
			StringBuffer bu=new StringBuffer("select * from Authority as au where id in(");
			bu.append("select ro.authorityid from RoleAuth as ro inner join UserRole as us on ro.roleid=us.roleid and us.roleid in (");
			bu.append("select roleid from userRole where userid=");
			bu.append(user.getId());
			bu.append("))");
			Query query=getCurrentSession().createSQLQuery(bu.toString());
		   List list= query.list();	
		   ls= convertToAuthority(list);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ls;
	}
	
	
	
	
}
