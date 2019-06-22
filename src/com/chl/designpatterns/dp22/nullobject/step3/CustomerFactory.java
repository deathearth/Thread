package com.chl.designpatterns.dp22.nullobject.step3;

import com.chl.designpatterns.dp22.nullobject.step1.AbstractCustomer;
import com.chl.designpatterns.dp22.nullobject.step2.NullCustomer;
import com.chl.designpatterns.dp22.nullobject.step2.RealCustomer;

public class CustomerFactory {

	public static final String[] names = {"Rob","Joe","Julie"};
	
	public static AbstractCustomer getCustomer(String name){
		for(int i = 0;i<names.length;i++){
			if(names[i].equalsIgnoreCase(name)){
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}
