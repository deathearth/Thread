package com.chl.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class QueueClient {
	
	static Socket server;
	
	//创建于服务端的连接
	public static void cs() throws UnknownHostException, IOException {
		server = new Socket(InetAddress.getLocalHost(),9999);
	}

	/**
	 * 发布消息
	 * @param msg 消息体
	 * @throws IOException 
	 */
	public static void pub(String msg) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(    
                server.getInputStream()));    
        PrintWriter out = new PrintWriter(server.getOutputStream());    
            out.println(msg);  
            out.flush();     
            System.out.println("--"+in.readLine());     
        server.close();    
	}
	
	/**
	 * 订阅消息
	 * @param action 触发类型
	 * @return 
	 * @throws IOException
	 */
	public static String sub(String action) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(    
                server.getInputStream()));    
        PrintWriter out = new PrintWriter(server.getOutputStream());    
            out.println(action);  
            out.flush();     
            String str = in.readLine();  
            System.out.println("获取的消息为:"+str);  
        return str;  
	}
}
