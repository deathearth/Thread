package com.chl.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 *
 * 自定义类加载器
 * @author chenhailong
 * @date 2019年5月22日 下午7:22:50
 */
public class MyClassLoader extends ClassLoader {

	private String root;

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	/**
	 * 找到类
	 */
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = loadClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	/**
	 * 加载类
	 * @param className
	 * @return
	 */
	@SuppressWarnings("resource")
	private byte[] loadClassData(String className) {
		String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		try {
			InputStream ins = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = 0;
			while ((length = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		
		
		MyClassLoader cc = new MyClassLoader();
		cc.setRoot("/Users/chenhailong/Desktop");
		Class<?> testClass = null;
		try {
			testClass = cc.loadClass("com.base.test.Fast");
			Object object = testClass.newInstance();
			Method[] mm = testClass.getMethods();
			for (Method m : mm) {
				System.out.println(
						"方法名称:" + m.getName() + "-参数个数:" + m.getParameterCount() + "-返回类型" + m.getReturnType());
			}

			try {
				Method main = testClass.getMethod("main", String[].class);
				String[] s = new String[1];
//				main.invoke(object, s);

			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

			System.out.println("");
			System.out.println("当前加载器:" + object.getClass().getClassLoader());
			System.out.println("父级加载器:" + object.getClass().getClassLoader().getParent());
			System.out.println("父父级加载器:" + object.getClass().getClassLoader().getParent().getParent());
			System.out.println("父父父级加载器:" + object.getClass().getClassLoader().getParent().getParent().getParent());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}

/**
 * //外部类,编译好之后放在固定目录后，执行上面的代码 
 * 
 * package com.base.test; 
 * 
 * public class Fast{
 * 
 * public static void main(String[] args) { 
 * 		System.out.println("--"); 
 * }
 * 
 * public void test(String s) { 
 * 		System.out.println("输出参数:"+s); 
 * } 
 * }
 *
 */