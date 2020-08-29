package com.chl.designpatterns;

/**
 * 单例模式，构造函数必须私有，防止外部创建对象
 * @author chenhailong
 * 
 * 懒汉式 线程不安全   【缺点：不支持多线程】
 * 懒汉式 线程安全(增加 synchronized)【缺点：效率低】
 *
 */
public class SingleTon {
	
	private static SingleTon instance = null;

	private SingleTon() {}
	
	public static synchronized SingleTon getInstance() {
		if(instance == null) {
			instance = new SingleTon();
		}
		return instance;
	}

}




