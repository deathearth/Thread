package com.chl.designpatterns;

/**
 * 比双重检查锁简单一些
 * @author chenhailong
 *
 */
public class SingleTonStaticClass {
	
	private SingleTonStaticClass() {}

	private static class inner{
		
		private static final SingleTonStaticClass singleTon = new SingleTonStaticClass();
		
	}
	
	public static SingleTonStaticClass getInstance() {
		return inner.singleTon;
	}
	
	
}
