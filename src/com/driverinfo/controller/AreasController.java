package com.driverinfo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.driverinfo.context.ContextData;
import com.driverinfo.entity.MessModule;
import com.driverinfo.hibernateEntity.Area;
import com.driverinfo.hibernateEntity.Areas;
import com.driverinfo.hibernateEntity.User;
import com.driverinfo.service.AreaService;
import com.driverinfo.service.AreasService;

@Controller
@RequestMapping(value="/areas")
public class AreasController {
	
	
	private Logger logger=Logger.getLogger(AreasController.class);
	
	
	@Resource(name="areasService",type=AreasService.class)
	private AreasService areasService;	
	public void setAreaService(AreasService areasService) {
		this.areasService = areasService;
	}

	
	
	/**
	 * 获取所有省市
	 * @return
	 */
	@RequestMapping(value="/getAllProvince")
	@ResponseBody
	public List<MessModule> getAllProvince(){
		List<MessModule> lsmm=new ArrayList<MessModule>();
		List<Areas> laAreas= areasService.findAllProvince();
		if(laAreas!=null&&laAreas.size()!=0){
			for (int i = 0; i < laAreas.size(); i++) {
				MessModule mm=new MessModule();
				mm.setName(laAreas.get(i).getId().toString());
				mm.setDesc(laAreas.get(i).getName());
				lsmm.add(mm);
			}
			
			
		}
		 return lsmm;
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/toAdd")
	public String toAdd(HttpServletRequest request,HttpServletResponse response){
		
		return "area/add";
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return 省集合
	 */
	@RequestMapping(value="/findProvinceByuserid")
	@ResponseBody
	public List<MessModule> getAll(HttpServletRequest request,HttpServletResponse response){
       
        
		return null;
	}
	
	//根据省名获取省内城市
	@RequestMapping(value="/findCityByProvince")
	@ResponseBody
	public List<MessModule> findCityByProvinceid(String areaid,HttpServletRequest request,HttpServletResponse response){
       
		return null;
	}
	
	@RequestMapping(value="/findCountyByuserid")
	@ResponseBody
	public List<MessModule> findCountyByuserid(HttpServletRequest request,HttpServletResponse response){
        
		
		return null;
	}
	
	/////////////////查询数据库
	
	
	
	
	
	
	
	
	
	
    public static void main(String[] args) {
    
	}
	
	

}
