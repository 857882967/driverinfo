package com.driverinfo.listener;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.driverinfo.context.AreaContext;
import com.driverinfo.dao.AreaDAO;
import com.driverinfo.oldHibernateModel.Area;


/**
 * 存取地区数据 避免反复访问数据库
 * @author Mander
 *在Spring容器将所有的Bean都初始化完成之后，做一些操作，实现一个接口：
 */
public class AreaInit implements ApplicationListener<ContextRefreshedEvent> {
	
	
	@Resource(name="areaDAO",type=AreaDAO.class)
	private AreaDAO areaDAO;

	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}

	//所有地区集合
	private static List<Area> listArea =new ArrayList<>();
	

	
	/**
	 * 在web 项目中（spring mvc），
	 * 系统会存在两个容器，一个是root application context ,
	 * 另一个就是我们自己的 projectName-servlet context（作为root application context的子容器）。
	 * 初始化获取所有地区
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			//root application context 没有parent，他就是老大.
			//需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法
			//存储所有地区信息
			
		//	AreaContext.setListArea(areaDAO.findAll());
			
		}
	}
	
	
	
	
	

}
