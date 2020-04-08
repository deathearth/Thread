package com.chl.classloader;

public class TestClassForname {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		try {
			Class c = Class.forName("com.chl.classloader.MyClassLoader");
			
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
