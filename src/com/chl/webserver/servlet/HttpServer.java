package com.chl.webserver.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {

	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer hs = new HttpServer();
		hs.await();
	}
	
	//循环等待请求
	public void await() {
		ServerSocket ss = null;
		int port = 8080;
		try {
			ss = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				
				socket = ss.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				
				Request req = new Request(input);
				req.parse();
				
				Response res = new Response(output);
				res.setRequest(req);
				
				if(req.getUri().startsWith("/servlet/")) {
					ServletProcessor sp = new ServletProcessor();
					sp.process(req, res);
				}else {
					StaticResourceProcessor sr = new StaticResourceProcessor();
					sr.process(req, res);
				}
				
				socket.close();
				shutdown = req.getUri().equals(SHUTDOWN_COMMAND);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		
	}
	
}
