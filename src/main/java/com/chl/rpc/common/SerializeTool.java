package com.chl.rpc.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * @author chenhailong
 */
public class SerializeTool {
	
	/**
	 * 序列化操作
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static byte[] serialize(Object object) throws IOException{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream outputStream = new ObjectOutputStream(os);
		outputStream.writeObject(object);
		outputStream.flush();
		byte[] byteArray = os.toByteArray();
		outputStream.close();
		os.close();
		return byteArray;
	}
	
	/**
	 * 反序列化操作
	 * @param buf
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerialize(byte[] buf) throws IOException ,ClassNotFoundException{
		ByteArrayInputStream is = new ByteArrayInputStream(buf);
		ObjectInputStream inputStream = new ObjectInputStream(is);
		Object object = inputStream.readObject();
		inputStream.close();
		is.close();
		return object;
		
	}

}
