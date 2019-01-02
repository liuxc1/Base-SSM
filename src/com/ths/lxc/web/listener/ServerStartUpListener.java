package com.ths.lxc.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerStartUpListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}
     /**
      * 监听启动的时候
      */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//获取上下文对象
		ServletContext context = arg0.getServletContext();
		String path = context.getContextPath();
		
		System.out.println("BASE_PATH=======>"+path);
		context.setAttribute("BASE_PATH", path);
		
	}

}
