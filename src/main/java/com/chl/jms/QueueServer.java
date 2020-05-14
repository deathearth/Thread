package com.chl.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 消息机制的服务端实现
 * 服务端集成了thread类，增加了吞吐量。每一次请求都会开启一个新的线程。
 * 注：这里根据客户端请求的关键字进行判断，处理不同的业务|事件
 * @author chenhailong
 *
 */
public class QueueServer extends Thread {
	
	//构造函数，初始化socket对象
	QueueServer(Socket socket){
		this.socket = socket;
	}
	//独立线程的socket对象
	private Socket socket;
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		//获取信息流
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
			PrintWriter out = new PrintWriter(socket.getOutputStream());  
			while(true) {
				String msg = in.readLine();
				if(msg != null) {
					System.out.println("接收到的消息为：" + msg);
					if(msg.equals("begin-product")) {
						//如果是生产消息，则创建
						MessageQueue.produce(msg);
					}
					if(msg.equals("consumer")) {
						//如果是消费消息，则输出
						out.println(MessageQueue.consumer());  //如果这里用 out.print， client端将收不到信息。
						out.flush();
					}
					if(msg.equals("error")) {
						break;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果没有消息，则关闭退出
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("JMS-server启动");
			while(true) {
				//多线程处理生产、消费
				QueueServer server = new QueueServer(ss.accept());
				server.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
