package com.chl.rpc.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.chl.rpc.common.HelloService;
import com.chl.rpc.common.SerializeTool;

/**
 * Rpc客户端
 * @author chenhailong
 */
public class RpcClient {
	
	public static Object send(byte[] bs) {
		try {
			Socket socket = new Socket("127.0.0.1",9999);
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(bs);
			InputStream in = socket.getInputStream();
			byte[] buf = new byte[1024];
			in.read(buf);
			Object formatDate = SerializeTool.deSerialize(buf);
			socket.close();
			return formatDate;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {

		HelloService hs = ProxyFactory.getInstance(HelloService.class);
		
		System.out.println("say------:"+  hs.sayHello("pikaqiu") );
		System.out.println("persion--:" + hs.getPersion("miaowazhognzi "));
		
	}

}
