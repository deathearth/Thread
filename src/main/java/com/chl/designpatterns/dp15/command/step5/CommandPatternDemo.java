package com.chl.designpatterns.dp15.command.step5;

import com.chl.designpatterns.dp15.command.step2.Stock;
import com.chl.designpatterns.dp15.command.step3.BuyStock;
import com.chl.designpatterns.dp15.command.step3.SellStock;
import com.chl.designpatterns.dp15.command.step4.Broker;

public class CommandPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stock abcStock = new Stock();
		
		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);
		
		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);
		
		broker.placeOrders();
		
	}

}
