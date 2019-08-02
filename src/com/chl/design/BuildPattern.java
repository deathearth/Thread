package com.chl.design;

public class BuildPattern {

	public static void main(String[] args) {
		
		Person pp = Person.p().setAge(23).setName("小明").setSex(1).setCol(new College("早稻田大学","种地专业"));
		
		System.out.println(pp.toString());
	}
	
}


class Person{
	/**姓名*/
	private String name;
	/**年龄*/
	private int age;
	/**性别*/
	private int sex;
	/**学校*/
	private College col;
	
	static Person p(){
		return new Person();
	}
	
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	public Person setSex(int sex) {
		this.sex = sex;
		return this;
	}
	public Person setCol(College col) {
		this.col = col;
		return this;
	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSex() {
		return sex;
	}

	public College getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", col=" + col + "]";
	}
	
}


class College{
	/**
	 * 大学名称
	 */
	private String name;
	/**
	 * 专业
	 */
	private String major;
	
	/**
	 * 学校构造函数
	 * @param name
	 * @param major
	 */
	public College(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "College [name=" + name + ", major=" + major + "]";
	}
	
}