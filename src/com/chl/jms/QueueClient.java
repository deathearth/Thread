package com.chl.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 消息机制的客户端
 * 
 * 可以创建于服务器的socket连接。并提供了pub\sub两个方法
 * 
 * 
 * @author chenhailong
 *
 */
public class QueueClient {
	
	 Socket server;
	
	//创建于服务端的连接
	public  void cs() throws UnknownHostException, IOException {
		server = new Socket(InetAddress.getLocalHost(),9999);
	}

	/**
	 * 发布消息
	 * @param msg 消息体
	 * @throws IOException 
	 */
	public  void pub(String msg) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(    
//                server.getInputStream()));    
        PrintWriter out = new PrintWriter(server.getOutputStream());    
            out.println(msg);  
            out.flush();     
        server.close();    
	}
	
	/**
	 * 订阅消息
	 * @param action 触发类型
	 * @return 
	 * @throws IOException
	 */
	public  String sub(String action) throws IOException {
        PrintWriter out = new PrintWriter(server.getOutputStream());    
            out.println(action);  
            out.flush();     
            BufferedReader in = new BufferedReader(new InputStreamReader(    
                    server.getInputStream()));  
            
          String str = "";
            
//            char[] ret = new char[8096];
//            int len = 0;
//            while((len=in.read(ret, 0, ret.length))!=-1)
//            {
//                str = new String(ret,0,len);
//            }
            
           str = in.readLine(); //readLine方法某些情况会阻塞线程(如果信息流中没有回车或换行符，就会阻塞、所以要考虑使用环境)
            
            System.out.println("获取的消息为:"+str);  
        return str;  
	}
}
