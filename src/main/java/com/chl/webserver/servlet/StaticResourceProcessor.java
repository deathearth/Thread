package com.chl.webserver.servlet;

import java.io.IOException;

/**
 * 处理对静态资源的请求
 * @author chenhailong
 *
 */
public class StaticResourceProcessor {

	public void process(Request request, Response response) {
		
		try {
			response.sendStaticResource();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
