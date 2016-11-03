package com.driverinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.driverinfo.context.ContextData;
import com.driverinfo.entity.MessModule;
import com.driverinfo.hibernateEntity.Role;
import com.driverinfo.hibernateEntity.User;
import com.driverinfo.service.RoleService;

@Controller
@RequestMapping(value="/role")
public class RoleController {
	
	@Resource(name="roleService",type=RoleService.class)
	private RoleService roleService;
	
	//根据用户名获取对应权限列表(添加用户时获取可设定的权限列表Combobox)
	@RequestMapping(value="/findByUser")
	@ResponseBody
	public List<Role> findbyUser(HttpServletRequest request,HttpServletResponse response){
		Object obj= request.getSession().getAttribute(ContextData.sessionUser);
		User user=(User) obj;
		return null;//roleService.findbyUser(user.getId().toString());
	}
	
	@RequestMapping(value="/findAll")
	@ResponseBody
	public List<Role> findbyAll(HttpServletRequest request,HttpServletResponse response){
		return roleService.findAll();
	}
	
	@RequestMapping(value="/findbyAllToConvert")
	@ResponseBody
	public List<MessModule> findbyAllToConvert(HttpServletRequest request,HttpServletResponse response){
		List<Role> ls= roleService.findAll();
		List<MessModule> lsMess=new ArrayList<>();
		if(ls.size()!=0){
			for (Role role : ls) {
				MessModule mm=new MessModule();
				 mm.setName(role.getId().toString());
				 mm.setDesc(role.getTitle());
				 lsMess.add(mm);
			}
		}
		return lsMess;
	}
	
	
	
	
	

}
