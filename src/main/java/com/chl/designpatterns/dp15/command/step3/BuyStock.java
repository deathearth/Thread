package com.chl.designpatterns.dp15.command.step3;

import com.chl.designpatterns.dp15.command.step1.Order;
import com.chl.designpatterns.dp15.command.step2.Stock;

public class BuyStock implements Order {

	private Stock abcStock;
	
	public BuyStock(Stock abcStock){
		this.abcStock = abcStock;
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		abcStock.buy();
	}

}
