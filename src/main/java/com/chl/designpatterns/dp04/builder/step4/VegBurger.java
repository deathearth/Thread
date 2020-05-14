package com.chl.designpatterns.dp04.builder.step4;

import com.chl.designpatterns.dp04.builder.step3.Burger;

public class VegBurger extends Burger {

	public String name() {
		// TODO Auto-generated method stub
		return "Veg Burger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 25f;
	}

}
