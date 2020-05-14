package com.chl.webserver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

/**
 * Servlet implementation class PrimitiveServlet
 * 所有的servlet程序都必须实现该接口或继承自实现了该接口的类。
 */
public class PrimitiveServlet implements Servlet {

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//生命周期方法，可以通过覆盖该方法来初始化对象，如加载数据库，值初始化
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//req包含HTTP请求信息，res可以封装servlet的响应。
		System.out.println("are you ok !");
		PrintWriter out = res.getWriter();
		out.println("Hello , Roses are red.");
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		//通常在servlet容器正在关闭正在被关闭或者servlet容器需要一些空闲内存的时候调用，尽在所有servlet线程的service方法已经退出或者超时淘汰的时候。            
		System.out.println("des !");
	}

    

}
