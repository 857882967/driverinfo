package com.driverinfo.context;

import java.util.ArrayList;
import java.util.List;

import com.driverinfo.oldHibernateModel.Area;

//地区类
public class AreaContext {

	//所有地区集合
	private static List<Area> listArea =new ArrayList<>();
		
	
	
	
	public static void setListArea(List<Area> list){
		for (Area area : list) {
			listArea.add(area);
		}
	}
	
	//存
	public static void setArea(Area area){
		listArea.add(area);
	}
	//取所有
	public static List<Area> getAllArea(){
		return listArea;
	}
	
	
	
	
}
