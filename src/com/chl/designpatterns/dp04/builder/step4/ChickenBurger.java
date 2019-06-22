package com.chl.designpatterns.dp04.builder.step4;

import com.chl.designpatterns.dp04.builder.step3.Burger;

public class ChickenBurger extends Burger {

	public float price(){
		return 50.5f;
	}
	
	public String name(){
		return "chicken burger";
	}
	
}
