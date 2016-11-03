package com.driverinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.hibernate.integrator.spi.Integrator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.driverinfo.context.ContextData;
import com.driverinfo.entity.DatagridUserEntity;
import com.driverinfo.entity.MessModule;
import com.driverinfo.hibernateEntity.Areas;
import com.driverinfo.hibernateEntity.Authority;
import com.driverinfo.hibernateEntity.Role;
import com.driverinfo.hibernateEntity.User;
import com.driverinfo.hibernateEntity.UserRole;
import com.driverinfo.service.AreaService;
import com.driverinfo.service.AuthorityService;
import com.driverinfo.service.UserRoleService;
import com.driverinfo.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Resource(name = "userService", type = UserService.class)
	private UserService userService;

	@Resource(name = "authorityService", type = AuthorityService.class)
	private AuthorityService authorityService;

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	@Resource(name="userRoleService" ,type=UserRoleService.class)
	private UserRoleService userRoleService;
	
	@Resource(name="areaService" ,type=AreaService.class)
	private AreaService areaService;
	

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login")
	public String tologin() {
		return "login/login";
	}

	@RequestMapping(value = "/error")
	public String toerror() {
		return "error/error";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/top")
	public String top() {
		return "frame/top";
	}

	/**
	 * 菜单列
	 * 
	 * @return
	 */
	@RequestMapping(value = "/left")
	public String left(HttpServletRequest request, HttpServletResponse response) {
		// 获取菜单
		Object obj = request.getSession().getAttribute(ContextData.sessionUser);
		User user = (User) obj;
		List<Authority> list = authorityService.findByUser(user);
		request.setAttribute("leftMenu", list);
		Object objs = request.getAttribute("");

		return "frame/left";
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping(value = "/food")
	public String food() {
		return "frame/food";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/default")
	public String defaultmain() {
		return "frame/main";
	}

	// 进入用户管理
	/**
	 * @param authorithName
	 *            权限模块名称
	 * @param request
	 * @param respones
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "index")
	public String index(String authorithName, HttpServletRequest request, HttpServletResponse respones)
			throws IOException {
		//获取用户管理关的功能按钮
		try {
			Object objuser = request.getSession().getAttribute(ContextData.sessionUser);
			User user = (User) objuser;
			// 查询用户角色的功能按钮
			List<Authority> lsAuto = authorityService.findAuthorityButton(user.getId().toString(), authorithName);
			request.setAttribute("lsauth", lsAuto);
			return "user/user";
		} catch (Exception e) {
			// respones.sendRedirect("user/error");
			return "user/loginout";
		}
	}

	@RequestMapping(value = "tologin")
	public String findByNamePass(String usname, String psword, HttpServletRequest request) {
		if (usname != null && usname.length() != 0 && psword != null && psword.length() != 0) {
			List<User> list = userService.findByNamePasss(usname, psword);
			if (list.size() != 0 && list != null) {
				User user = list.get(0);
				request.getSession().setAttribute(ContextData.sessionUser, user);
				// 获取功能
				List<Authority> listAuth = authorityService.findByroleid(user.getId().toString());
				List<Authority> menus = authorityService.getMenu(listAuth);
				// 删选功能菜单
				if (listAuth.size() != 0 && listAuth != null) {
					request.setAttribute("auths", menus);
					return "frame/frame";
				} else {
					request.setAttribute("auths", "null");
					return "login/login";
				}
				// return "home/index";
			} else {
				request.getSession().setAttribute(ContextData.sessionUser, "null");
				return "login/login";
			}
		} else {
			request.getSession().setAttribute(ContextData.sessionUser, "");
			return "login/login";
		}
	}

	// 查询所属用户()
	/**
	 * 按用户所属地区查询地区查询
	 * 
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findUsersbyUserid")
	@ResponseBody
	public DatagridUserEntity findbyUserid(String page, String rows, HttpServletRequest request,
			HttpServletResponse response) {
		DatagridUserEntity due = new DatagridUserEntity();
		Object obj = request.getSession().getAttribute(ContextData.sessionUser);
		User us = (User) obj;
		return userService.findUsersByUser(page, rows, us);

	}

	// 分页显示
	@RequestMapping(value = "/findUsersbyParm")
	@ResponseBody
	public DatagridUserEntity findbyUserid(String page, String rows, String parm, HttpServletRequest request,
			HttpServletResponse response) {
		DatagridUserEntity due = new DatagridUserEntity();
		try {
			Object obj = request.getSession().getAttribute(ContextData.sessionUser);
			User u = (User) obj;
			userService.findUsersByParm(page, rows, parm, u.getId().toString());
		} catch (Exception e) {

		}

		return null;
	}

	// 添加用户
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		try {
			Object obj= request.getSession().getAttribute(ContextData.sessionUser);
	        User user=null;
			if(obj!=null){
			  user=(User)obj;			
			 //初始化用户所在省
			 
			  //获取用户所在省
			  List<MessModule> lsProvince=new ArrayList<>();
			  List<Areas> lsareas= areaService.findAllProvince();
			  if(lsareas!=null){
				  for (Areas area : lsareas) {
					  MessModule mm=new MessModule();
					   mm.setName(area.getCode());
					   mm.setName(area.getName());
					   lsProvince.add(mm);
				}
			  }
			  request.setAttribute("lsProvince",lsProvince);
			  
			  //用户角色的下级角色
			  List<Role> lsRole=  userRoleService.findNextByUserid(user.getId());
			  request.setAttribute("lsRole", lsRole);
			  for (int i = 0; i <lsRole.size(); i++) {
				System.out.println(lsRole.get(i).getName()+"=lsRole");
			}
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "user/add";
	}

	// 删除用户
	@RequestMapping(value = "/delete")
	@ResponseBody
	public MessModule deletebyid(String userid,HttpServletRequest request,HttpServletResponse response) {
		MessModule mm = new MessModule();
		mm.setName("成功");
		mm.setDesc("删除信息成功");
		try {
		String uid= userid.trim();
		Object obj= request.getSession().getAttribute(ContextData.sessionUser);
		User user=(User)obj;
		if(uid.length()!=0&&uid!=null){
		  int i=userService.deleteByUid(uid,user.getName());
		  if(i>0){
			mm.setName("成功");
			mm.setDesc("删除成功");
		  }else{
			mm.setName("失败");
			mm.setDesc("删除信息失败");  
		  }
		}else{
			mm.setName("失败");
			mm.setDesc("删除信息失败");
		}
		} 
		catch (Exception e) {
			mm.setName("失败");
			mm.setDesc("删除信息失败");
		}
		return mm;
	}

	// 修改用户
	@RequestMapping(value = "/update")
	public String update(String userid) {
		System.out.println("跟新用户id="+userid);
		return "user/update";
	}

	/**
	 * 添加地区(省市县分开添加)
	 * 进入添加地区页面
	 * @param areaName
	 * @return
	 */
	@RequestMapping(value = "/addArea")
	public String addArea(String areaName) {
		return "area/add";
	}

	@RequestMapping(value = "/test")
	public String test(String areaName) {

		return "frame/frame";
	}

	public static void main(String[] args) {
		AreaService as = new AreaService();
		as.findAll();
	}
	
	
}
