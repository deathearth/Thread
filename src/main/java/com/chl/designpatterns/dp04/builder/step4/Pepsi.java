package com.chl.designpatterns.dp04.builder.step4;

import com.chl.designpatterns.dp04.builder.step3.ColdDrink;

public class Pepsi extends ColdDrink{

	public String name() {
		// TODO Auto-generated method stub
		return "Pepsi";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 35.5f;
	}
	
}
