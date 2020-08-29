package com.chl.designpatterns;

/**
 * 双重检验锁
 * @author chenhailong
 *
 * 并发情况下保持高性能
 */
public class SingleTonDCL {

	private volatile static SingleTonDCL dcl;
	
	private SingleTonDCL() {}
	
	public static SingleTonDCL getInstance() {
		if(dcl == null) {
			synchronized (SingleTonDCL.class) {
				if(dcl == null) {
					dcl = new SingleTonDCL();
				}
			}
		}
		return dcl;
	}
	
	
	
}
