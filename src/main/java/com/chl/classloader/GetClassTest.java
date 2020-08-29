package com.chl.classloader;

/**
 * 获取类对象
 * @author chenhailong
 *
 */
public class GetClassTest {

	public static void main(String[] args) {

		
		Class c = MyClassLoader.class;
		
		Class c1 = new MyClassLoader().getClass();
		
		try {
			Class c2 = Class.forName("com.chl.classloader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
