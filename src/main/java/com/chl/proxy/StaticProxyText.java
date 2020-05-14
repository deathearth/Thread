package com.chl.proxy;

/**
 * 静态代理模式，简单示例
 * 代理模式优点：
	职责清晰 真实角色只需关注业务逻辑的实现，非业务逻辑部分，后期通过代理类完成即可。
	高扩展性 不管真实角色如何变化，由于接口是固定的，代理类无需做任何改动。
 * @author chenhailong
 *
 */
public class StaticProxyText {

	public static void main(String[] args) {
		employeeA a = new employeeA("小王");
		employeeB b = new employeeB(a);
		//b员工做代理，实际是a在做事情
		b.doSomething();
	}
}

/**
 * 通用员工行为
 */
interface Common {
	void doSomething();
}

/**
 * a员工
 */
class employeeA implements Common {

	private String name;

	employeeA(String name) {
		this.name = name;
	}

	@Override
	public void doSomething() {
		System.out.println("exec:" + name);
	}

}

/**
 * b员工
 */
class employeeB implements Common {

	private Common com;

	employeeB(Common com) {
		this.com = com;
	}

	@Override
	public void doSomething() {
		com.doSomething();
	}

}