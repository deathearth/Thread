package com.chl.designpatterns.dp14.chainofresponsibility.step2;

import com.chl.designpatterns.dp14.chainofresponsibility.step1.AbstractLogger;

public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level){
		this.level = level;
		
		
		System.out.println("-------step3"+level);
	}

	@Override
	protected void write(String message) {
		// TODO Auto-generated method stub
		System.out.println("zzzzzzzzz--Standard Console::Logger:"+message);
	}
}
