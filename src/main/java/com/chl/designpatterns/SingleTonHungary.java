package com.chl.designpatterns;

/**
 * 单例模式，构造函数必须私有，防止外部创建对象
 * @author chenhailong
 * 
 * 饿汉式, 加载时就初始化对象 -> 浪费内存
 *
 */
public class SingleTonHungary {
	
	private static SingleTonHungary instance = new SingleTonHungary();

	private SingleTonHungary() {}
	
	public static SingleTonHungary getInstance() {
		return instance;
	}

}




