package com.chl.designpatterns.dp14.chainofresponsibility.step2;

import com.chl.designpatterns.dp14.chainofresponsibility.step1.AbstractLogger;

public class ErrorLogger extends AbstractLogger {

	@Override
	protected void write(String message) {
		// TODO Auto-generated method stub
		System.out.println("xxxxx--Standard Console::Logger:"+ message);
	}
	
	public ErrorLogger(int level){
		this.level = level;
		
		System.out.println("-------step1"+level);
	}
	

}
