package com.chl.designpatterns.dp14.chainofresponsibility.step3;

import com.chl.designpatterns.dp14.chainofresponsibility.step1.AbstractLogger;
import com.chl.designpatterns.dp14.chainofresponsibility.step2.ConsoleLogger;
import com.chl.designpatterns.dp14.chainofresponsibility.step2.ErrorLogger;
import com.chl.designpatterns.dp14.chainofresponsibility.step2.FileLogger;

public class ChainPatternDemo {

	private static AbstractLogger getChanOfLoggers(){
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		System.out.println(errorLogger);
		fileLogger.setNextLogger(consoleLogger);
		System.out.println(fileLogger);
		return errorLogger;
	}
	
	
	public static void main(String[] args){
		AbstractLogger loggerChain  = getChanOfLoggers();
//		System.out.println(loggerChain);
		
		loggerChain.logMessage(AbstractLogger.INFO, 
				"This is an information.");
		
		loggerChain.logMessage(AbstractLogger.DEBUG, 
				"This is an debug level information.");
		
		loggerChain.logMessage(AbstractLogger.ERROR, 
				"This is an error information.");

	}
	
}
