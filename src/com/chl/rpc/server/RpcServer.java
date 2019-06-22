package com.chl.rpc.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.chl.rpc.common.CommonModel;
import com.chl.rpc.common.SerializeTool;

public class RpcServer {

	public static void main(String[] args) {

		try {
			openServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void openServer() throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		try {
			System.out.println("服务端开启");
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress());
				InputStream in = socket.getInputStream();
				byte[] buf = new byte[1024];
				in.read(buf);
				byte[] formatDate = formatData(buf);
				OutputStream out = socket.getOutputStream();
				out.write(formatDate);
				socket.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
			serverSocket.close();
		}
	}
	
	public static byte[] formatData(byte[] bs) {
		try {
			/**
			 * 将接收的数据反序列化为CommonModel
			 */
			CommonModel cm = (CommonModel)SerializeTool.deSerialize(bs);
			String className = cm.getClassName();
			String[] types = cm.getTypes();
			Object[] args  = cm.getArgs();
			
			/**
			 * 1.通过映射获取实现类(接口和实现类的关系)
			 * 2.通过反射原理调用具体方法并返回
			 */
			Class<?> cls = Class.forName(getMapValue(className));
			Class<?>[] typeCls = null; //参数类型类对象
			if(types != null) {
				typeCls = new Class[types.length];
				for(int i = 0;i< typeCls.length;i++) {
					typeCls[i] = Class.forName(types[i]);
				}
			}
			Method method = cls.getMethod(cm.getMethod(), typeCls);
			Object object = method.invoke(cls.newInstance(), args);
			byte[] byteArray = SerializeTool.serialize(object);
			return byteArray;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 简单的map映射
	 * @param key
	 * @return
	 */
	public static String getMapValue(String key) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("com.chl.rpc.common.HelloService", "com.chl.rpc.common.HelloServiceImpl");
		return map.get(key);
	}
	
	/**
	 * 通过配置中心读取
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getPropertyValue(String key) throws IOException{
		Properties pro = new Properties();
		FileInputStream in = new FileInputStream("xxx/xx/x.properties");
		pro.load(in);
		in.close();
		return pro.getProperty(key);
	}
}
