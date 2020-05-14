package com.chl.designpatterns.dp15.command.step2;
/*��棬��Ʊ*/
public class Stock {

	private String name = "ABC";
	private int quantity = 10;
	public void buy(){
		System.out.println("Stock�� Name:"+name+",Quantity:"+quantity+"�� bought");
	}
	
	public void sell(){
		System.out.println("Stock�� Name:"+name+",Quantity:"+quantity+"�� sold");
	}
}
