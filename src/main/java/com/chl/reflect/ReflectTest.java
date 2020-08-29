package com.chl.reflect;

public class ReflectTest {

	public static void main(String[] args) {

		//第一种方式
//		Class s;
//		try {
//			s = Class.forName("com.chl.reflect.Person");
//
//			System.out.println("-----获取字段属性");
//			Field[] fs = s.getDeclaredFields();
//			for (int i = 0; i < fs.length; i++) {
//				System.out.println(fs[i]);
//			}
//
//			System.out.println("-----获取方法名称");
//			Method[] method = s.getDeclaredMethods();
//			for (int i = 0; i < method.length; i++) {
//				System.out.println(method[i]);
//			}
//
//			System.out.println("-----获取包名" + s.getPackage());
//
//			System.out.println("-----实例化对象");
//			Person p = (Person) s.newInstance();
//
//			p.setAge(14);
//
//			System.out.println("获取设置的年龄" + p.getAge());
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		//第二种
		Person p = new Person();
		System.out.println(p.getClass().getDeclaredFields().length);
		
		//第三种
		Class pp = Person.class;
		System.out.println(pp.getName());
		
	}
}

class Person {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	Person() {
		System.out.println("构造在newInstance之后加载");
	}

	static {
		System.out.println("构造在newInstance之前加载");
	}
}