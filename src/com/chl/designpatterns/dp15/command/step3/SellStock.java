package com.chl.designpatterns.dp15.command.step3;

import com.chl.designpatterns.dp15.command.step1.Order;
import com.chl.designpatterns.dp15.command.step2.Stock;

public class SellStock implements Order {

	private Stock abcStock;
	
	public SellStock(Stock abcStock){
		this.abcStock = abcStock;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		abcStock.sell();
	}

}
