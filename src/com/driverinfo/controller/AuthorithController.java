package com.driverinfo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.driverinfo.context.ContextData;
import com.driverinfo.entity.AuthJson;
import com.driverinfo.entity.Menu;
import com.driverinfo.hibernateEntity.Authority;
import com.driverinfo.hibernateEntity.Role;
import com.driverinfo.service.AreaService;
import com.driverinfo.service.AuthorityService;
import com.driverinfo.service.RoleService;

@Controller
@RequestMapping(value = "/auth")
public class AuthorithController {

	private Logger logger = Logger.getLogger(AuthorithController.class);

	@Resource(name = "authorityService", type = AuthorityService.class)
	private AuthorityService authorityService;

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	@Resource(name="roleService",type=RoleService.class)
	private RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}




	@RequestMapping(value = "/index")
	public String index(String authorithName,HttpServletRequest request, HttpServletResponse response) {
		
		try {
			// 获取角色列表
			List<Role> listRole= roleService.findAll();
			for (int i = 0; i <listRole.size(); i++) {
				System.out.println(listRole.get(i).getTitle());
			}
			request.setAttribute("listRole",listRole);
			
			//获取所有权限动作
			List<Authority> lsAuth= authorityService.findAll();
			//筛选排序
		//	AuthJson json=new AuthJson();//单个功能模块
			List<Authority> menus=new ArrayList<>();
			for (int i = 0; i < lsAuth.size(); i++) {
				if(lsAuth.get(i).getType().equals("menu")){
					menus.add(lsAuth.get(i));	
				}
			}
			
			List<AuthJson> listAuthJson=new ArrayList<>();
			for (int i = 0; i < menus.size(); i++) {
				AuthJson json =new AuthJson();
				json.setMenuAuthority(menus.get(i));
				List<Authority> buttons=new ArrayList<>();
				for (int j = 0; j < lsAuth.size(); j++) {
					if(menus.get(i).getName().equals(lsAuth.get(j).getName())&&lsAuth.get(j).getType().equals("button")){
						buttons.add(lsAuth.get(j));
					}
				}
				json.setButtonAuthority(buttons);
				listAuthJson.add(json);
			}
			//删除没有按钮的模块名称
			for (int i = 0; i <listAuthJson.size(); i++) {
				AuthJson aj= listAuthJson.get(i);
				if(aj.getButtonAuthority()==null||aj.getButtonAuthority().size()==0){
					listAuthJson.remove(i);
				}
			}
			request.setAttribute("listMenu",listAuthJson);
			return "auth/auth";
		} catch (Exception e) {
			// respones.sendRedirect("user/error");
			return "user/loginout";
		}
	}
	
	
	
	@RequestMapping(value = "/findByRoleId")
	@ResponseBody
	public List<Authority> findByRoleId(String roleId, HttpServletRequest request,HttpServletResponse response) {
		
		return authorityService.findByRoleid(roleId);
	}
	
	
	
	@RequestMapping(value = "getByroleid")
	public String findByNamePass(String userid, HttpServletRequest request) {
		// list authorityService.findByroleid(userid);

		Menu menu1 = new Menu();
		menu1.setName("角色管理");
		menu1.setLevel(1);
		menu1.setGroup(1);

		Menu menu2 = new Menu();
		menu2.setName("新增角色");
		menu2.setLevel(2);
		menu2.setGroup(1);

		Menu menu3 = new Menu();
		menu3.setName("删除角色");
		menu3.setLevel(2);
		menu3.setGroup(1);

		Menu menu4 = new Menu();
		menu4.setName("用户管理");
		menu4.setLevel(1);
		menu4.setGroup(2);

		Menu menu5 = new Menu();
		menu5.setName("新增角色");
		menu5.setLevel(1);
		menu5.setGroup(2);

		Menu menu6 = new Menu();
		menu6.setName("删除角色");
		menu6.setLevel(1);
		menu6.setGroup(2);

		Menu menu7 = new Menu();
		menu7.setName("用户管理");
		menu7.setLevel(1);
		menu7.setGroup(3);

		Menu menu8 = new Menu();
		menu8.setName("新增角色");
		menu8.setLevel(2);
		menu8.setGroup(3);

		Menu menu9 = new Menu();
		menu9.setName("删除角色");
		menu9.setLevel(3);
		menu9.setGroup(3);

		List<Menu> ls = new ArrayList<>();
		ls.add(menu9);
		ls.add(menu8);
		ls.add(menu7);
		ls.add(menu6);
		ls.add(menu5);
		ls.add(menu4);
		ls.add(menu3);
		ls.add(menu2);
		ls.add(menu1);

		request.setAttribute("LsMenu", ls);

		return "test/testAuth";
	}

	public static void bubbleSort(int[] numbers) {
		int temp; // 记录临时中间值
		int size = numbers.length; // 数组大小
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] < numbers[j]) { // 交换两数的位置
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		for (int i : numbers) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 43, 4, 6, 5, 7, 7, 77, 7 };
		bubbleSort(nums);
		// Collections.sort(list);
		List<Integer> lt = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < lt.size(); i++) {

		}
		ls.add(2);
		ls.add(8);
		ls.add(2);
		ls.add(3);
		ls.add(2);
		ls.add(2);

		Collections.sort(ls);
		System.out.println("/////");
		for (Integer integer : ls) {
			System.out.println(integer);
		}

	}

}
