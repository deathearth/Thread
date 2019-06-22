package com.chl.designpatterns.dp04.builder.step3;

import com.chl.designpatterns.dp04.builder.step1.Item;
import com.chl.designpatterns.dp04.builder.step1.Packing;
import com.chl.designpatterns.dp04.builder.step2.Wrapper;

public abstract class Burger implements Item {

	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

	public abstract float price() ;

}
