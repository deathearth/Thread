package com.chl.designpatterns.dp22.nullobject.step4;

import com.chl.designpatterns.dp22.nullobject.step1.AbstractCustomer;
import com.chl.designpatterns.dp22.nullobject.step3.CustomerFactory;

public class NullPatternDemo {

	public static void main(String[] args){
		AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
		AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
		AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
		AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");
		
		System.out.println("Customers");
		System.out.println(customer1.getName());
		System.out.println(customer2.getName());
		System.out.println(customer3.getName());
		System.out.println(customer4.getName());
		
	}
	
}
