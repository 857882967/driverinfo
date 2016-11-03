package com.driverinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.driverinfo.dao.AuthorityDAO;
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
 * @see com.driverinfo.model.oldhbm.drivercms.test.Authority
 * @author MyEclipse Persistence Tools
 */
@Service
public class AuthorityService {

	@Resource(name = "authorityDAO", type = AuthorityDAO.class)
	private AuthorityDAO authorityDAO;

	public void setAuthorityDAO(AuthorityDAO authorityDAO) {
		this.authorityDAO = authorityDAO;
	}

	public List<Authority> findByroleid(String userid) {
		return authorityDAO.findbyRoleid(userid);
	}

	public List<Authority> findbyuserid() {
		return null;
	}

	// 筛选菜单
	public List<Authority> getMenu(List<Authority> lsau) {
		List<Authority> ls = new ArrayList<>();
		// 获取menu类型
		for (int i = 0; i < lsau.size(); i++) {
			if (lsau.get(i).getType().equals("menu")) {
				ls.add(lsau.get(i));
			}
		}

		//菜单组
//		List<Authority> menus1 = new ArrayList<>();
//		List<Authority> menus2 = new ArrayList<>();
//		List<Authority> menus3 = new ArrayList<>();
//		List<Authority> menus4 = new ArrayList<>();
//		
//		for (int j = 0; j < ls.size(); j++) {
//			switch (ls.get(j).getGroupid()) {
//			case 1:
//				menus1.add(ls.get(j));
//				break;
//			case 2:
//				menus2.add(ls.get(j));
//				break;
//			case 3:
//				menus3.add(ls.get(j));
//				break;
//			case 4:
//				menus4.add(ls.get(j));
//				break;
//			default:
//				break;
//			}
//		}
		//在每一组中筛选菜单级别-拼接数据
		
		return ls;
	}

	public List<Authority> findAuthorityButton(String userid, String authorithName) {
		
		return authorityDAO.findAuthorityButton(userid,authorithName);
	}

	public List<Authority> findByRoleid(String roleId) {
		
		return authorityDAO.findByRoleid(roleId);
	}

	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityDAO.findAll();
	}

	
	public List<Authority> findByUser(User user) {
		// TODO Auto-generated method stub
		return  authorityDAO.findByUser(user);
	}

	
	
	
	
 }