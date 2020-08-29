package com.chl.dataConvert;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 数据类型转换
 * @author chenhailong
 * 参考：https://www.cnblogs.com/sam-cheng/p/7136392.html
 */
public class DataConvertTest {

	public static void main(String[] args) {
		
		int i = 100;
		
		long l = i;
		Long ll = Long.parseLong(i+"");
		
		byte[] s = new byte[3];
		String str = new String(s);
		
		
		// byte 转 long
		byte[] bye = new byte[3];
		
		ByteArrayInputStream in = new ByteArrayInputStream(bye);
		DataInputStream ins = new DataInputStream(in);
		try {
			ins.readLong();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( 3 * 0.1 == 3 ); // false, 不能将浮点数精确的表示出来
	}

}
