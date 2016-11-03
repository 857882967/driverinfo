package com.driverinfo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

//禁止缓存过滤器
public class NoCacheFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 浏览器不缓存页面
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//设置禁止缓存的消息头  
	       ((HttpServletResponse)response).setHeader("Pragma","No-cache");       
	       ((HttpServletResponse)response).setHeader("Cache-Control","no-cache");       
	       ((HttpServletResponse)response).setHeader("Expires","0");//禁止缓存       
	         
	       chain.doFilter(request, response);  
	       System.out.print("NoCacheFilter");  
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
