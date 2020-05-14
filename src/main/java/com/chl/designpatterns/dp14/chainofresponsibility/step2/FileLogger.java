package com.chl.designpatterns.dp14.chainofresponsibility.step2;

import com.chl.designpatterns.dp14.chainofresponsibility.step1.AbstractLogger;

public class FileLogger extends AbstractLogger {

	@Override
	protected void write(String message) {
		// TODO Auto-generated method stub
		System.out.println("yyyyyyyyyyyyy--File::Logger: "+message);
	}

	public FileLogger(int level){
		this.level = level;
		
		System.out.println("-------step2"+level);
	}
}
