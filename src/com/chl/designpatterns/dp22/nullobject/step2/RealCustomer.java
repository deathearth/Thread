package com.chl.designpatterns.dp22.nullobject.step2;

import com.chl.designpatterns.dp22.nullobject.step1.AbstractCustomer;

public class RealCustomer extends AbstractCustomer{

	public RealCustomer(String name){
		this.name = name;
	}

	@Override
	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}
