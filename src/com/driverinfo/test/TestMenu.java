package com.driverinfo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.driverinfo.entity.Menu;

public class TestMenu {

	// testMenu

	public static void buildtree() {
		List<Menu> lt = new ArrayList<>();
		Menu m1 = new Menu();
		m1.setName("usermanager");
		m1.setLevel(1);
		m1.setGroup(1);

		Menu m2 = new Menu();
		m1.setName("Carmanager");
		m1.setLevel(1);
		m1.setGroup(2);

		Menu m5 = new Menu();
		m1.setName("addCar");
		m1.setLevel(2);
		m1.setGroup(2);

		Menu m4 = new Menu();
		m4.setName("Drivermanager");
		m4.setLevel(1);
		m4.setGroup(2);

		Menu m3 = new Menu();
		m3.setName("Rolemanager");
		m3.setLevel(1);
		m3.setGroup(3);

		lt.add(m1);
		lt.add(m2);
		lt.add(m3);
		lt.add(m4);
		lt.add(m5);
		
		List<Menu> lm1=new ArrayList<>();
		
		for (int i = 0; i < lt.size(); i++) {
			switch (lt.get(i).getGroup()) {
			case 1:
				lm1.add(lt.get(i));
				break;
			case 2:
				lm1.add(lt.get(i));
				break;
			case 3:
				lm1.add(lt.get(i));
				break;
			
		}
		
		}
		
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		   Set set=new HashSet();
		 
		   
		    List list = new ArrayList();
		    list.add("abc");
		    list.add("abc");
		    list.add("abc");
		    list.add("abc");
		    list.add("abc");
		    list.add("aaa");
		    list.add("fff");
		    set.addAll(list); //将list中的值加入set,并去掉重复的abc
		        
		    System.out.println("size="+ set.size() );
		   for( Iterator   it = set.iterator(); it.hasNext(); )
		    {             
		         System.out.println("value="+it.next().toString());            
		    }
		
		
	}
}
