package com.chl.webserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一个简单的web服务器( Tomcat )
 * @author chenhailong
 *
 */
public class WebServer {
	
	/**
	 * 可以存放一些测试应用程序的静态资源或servlet.是工作目录
	 */
	public static final String WEB_ROOT = 
			System.getProperty("user.dir") + File.separator + "webroot";
	
	//服务停止命令
	public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

	//控制服务状态
	private boolean shutdown = false;
	
	public static void main(String[] args) {

		
		WebServer ws = new WebServer();
		ws.await();
		
	}
	
	
	//socket服务端一直接收消息
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		//循环等待请求
		while(!shutdown) {
		
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			try {
				//接收到请求之后，await方法从accept方法返回的socket实例中获取input、output对象
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				//创建一个Request对象并且调用parse方法解析HTTP请求的原始数据
				Request request = new Request(input);
				request.parse();
				
				//创建一个Response响应对象
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();
				
				//关闭socket
				socket.close();
				// 判断http请求的uri是不是一个shutdown命令。如果是，则shutdown会置为true,从而推出循环
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
				
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
	}

}
