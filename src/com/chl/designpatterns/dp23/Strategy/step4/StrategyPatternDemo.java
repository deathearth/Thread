package com.chl.designpatterns.dp23.Strategy.step4;

import com.chl.designpatterns.dp23.Strategy.step2.OperationAdd;
import com.chl.designpatterns.dp23.Strategy.step2.OperationMultiply;
import com.chl.designpatterns.dp23.Strategy.step2.OperationSubstract;
import com.chl.designpatterns.dp23.Strategy.step3.Context;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Context context = new Context(new OperationAdd());
		System.out.println("10+5 = "+context.executeStrategy(10, 5));
		
		context = new Context(new OperationSubstract());
		System.out.println("10-5 = "+context.executeStrategy(10, 5));
		
		context = new Context(new OperationMultiply());
		System.out.println("10*5 = "+context.executeStrategy(10, 5));
	}

}
