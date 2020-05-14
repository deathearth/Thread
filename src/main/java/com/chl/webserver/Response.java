package com.chl.webserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
	
	private static final int BUFFER_SIZE = 1024;
	
	Request request;
	OutputStream output;
	
	//构造函数创建output对象
	public Response(OutputStream output) {
		this.output = output;
	}
	
	//传递request对象给reponse
	public void setRequest(Request request) {
		this.request = request;
	}
	
	// 输出一个静态资源
	public void sendStaticResource() throws IOException{
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(WebServer.WEB_ROOT,request.getUri());
			if(file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(bytes,0,BUFFER_SIZE);
				while( ch != -1) {
					output.write(bytes,0,BUFFER_SIZE);
					ch = fis.read(bytes,0,BUFFER_SIZE);
				}
			}else { //如果不存在，则发送一个异常信息
				String errorMessage = "HTTP/1.1 404 File Not Found \r\n"+
					"Content-Type : text/html\r\n"+
					"Content-Length:23\r\n"+
					"\r\n"+
					"<h1>File Not Found</h1>";
				System.out.println(errorMessage);
				output.write(errorMessage.getBytes());
			}
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			if(fis != null)
				fis.close();
		}
	}
}
