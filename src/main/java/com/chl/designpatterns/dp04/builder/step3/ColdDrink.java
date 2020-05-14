package com.chl.designpatterns.dp04.builder.step3;

import com.chl.designpatterns.dp04.builder.step1.Item;
import com.chl.designpatterns.dp04.builder.step1.Packing;
import com.chl.designpatterns.dp04.builder.step2.Bottle;

public abstract class ColdDrink implements Item {

	public Packing packing(){
		return new Bottle();
	}
	
	public abstract float price();
}
