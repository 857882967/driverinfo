package com.driverinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.driverinfo.context.ContextData;
import com.driverinfo.entity.CompanyDataGrid;
import com.driverinfo.hibernateEntity.Authority;
import com.driverinfo.hibernateEntity.User;
import com.driverinfo.service.AreaService;
import com.driverinfo.service.AuthorityService;
import com.driverinfo.service.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	private Logger logger = Logger.getLogger(CompanyController.class);

	@Resource(name = "companyService", type = CompanyService.class)
	private CompanyService companyService;

	
	@Resource(name = "authorityService", type = AuthorityService.class)
	private AuthorityService authorityService;
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}


	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}


	// 进入公司管理
	/**
	 * @param authorithName  权限模块名称
	 * @param request
	 * @param respones
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "index")
	public String index(String authorithName, HttpServletRequest request, HttpServletResponse respones) throws IOException {
		// 获取用户管理关的功能按钮
		try {
			Object objuser = request.getSession().getAttribute(ContextData.sessionUser);
				User user = (User) objuser;
				//查询用户角色的车辆功能按钮
				List<Authority> lsAuto = authorityService.findAuthorityButton(user.getId().toString(),authorithName);
				for (int i = 0; i <lsAuto.size(); i++) {
					System.out.println(lsAuto.get(i).getDesciption()+"==========");
				}
				request.setAttribute("lsauth",lsAuto);
				return "company/company";
		} catch (Exception e) {
			//respones.sendRedirect("user/error");
			return "user/loginout";
		}
	}

	
	
	
	
	
	@RequestMapping(value = "findAll")
	@ResponseBody
	public CompanyDataGrid findAll(Integer page,Integer rows, HttpServletRequest request, HttpServletResponse respones) {
		CompanyDataGrid companyDataGrid=null;
		try {
			Object obj= request.getSession().getAttribute(ContextData.sessionUser);
			User user=(User)obj;  
		     companyDataGrid=  companyService.findAll(user,page,rows);
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return companyDataGrid;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		AreaService as = new AreaService();
		as.findAll();
	}
	
	
	
}
