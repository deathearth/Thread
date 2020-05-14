package com.chl.designpatterns.dp15.command.step4;

import java.util.ArrayList;
import java.util.List;

import com.chl.designpatterns.dp15.command.step1.Order;

public class Broker {

	private List<Order> orderList = new ArrayList<Order>();
	
	public void takeOrder(Order order){
		orderList.add(order);
	}
	
	public void placeOrders(){
		for(Order order: orderList){
			order.execute();
		}
		orderList.clear();
	}
}
