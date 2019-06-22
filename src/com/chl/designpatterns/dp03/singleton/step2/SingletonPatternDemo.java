package com.chl.designpatterns.dp03.singleton.step2;

import com.chl.designpatterns.dp03.singleton.step1.SingleObject;
import com.chl.designpatterns.dp03.singleton.step1.SingleObject.Singleton;

public class SingletonPatternDemo {
	
	public static void main(String args[]){
//		SingleObject so = SingleObject.getInstance();
//		so.showMessage();
		
		Singleton so = SingleObject.Singleton.INSTANCE;
		String s = so.name();
		System.out.println(s);
	}
	
}
