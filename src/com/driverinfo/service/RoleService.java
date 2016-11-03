package com.driverinfo.service;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.driverinfo.dao.RoleDAO;
import com.driverinfo.hibernateEntity.Role;
/**
 * A data access object (DAO) providing persistence and search support for Role
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.driverinfo.model.oldhbm.drivercms.test.Role
 * @author MyEclipse Persistence Tools
 */
@Service
public class RoleService {
	
	@Resource(name="roleDAO",type=RoleDAO.class)
	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	
	//
	public List<Role> findAll() {
		return roleDAO.findAll();
	}




//	public List<Role> findbyUser(String userid){
//	 return roleDAO.findbyUser(userid);	
//	}
	
}