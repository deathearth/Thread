package com.chl.designpatterns.dp14.chainofresponsibility.step1;

public abstract class AbstractLogger {

	public static int INFO  = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	protected int level;
	//�������е�һ��Ԫ��
	protected AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger nextLogger){
		this.nextLogger = nextLogger;
//		System.out.println("���������Ϣ.." + this.nextLogger.getClass());
	}
	
	public void logMessage(int level,String message){
		System.out.println("this.level + "+this.level + "level " + level);
		if(this.level <= level){
			write(message);
		}
		if(nextLogger !=null){
			System.out.println("-----��ǰ����Ԫ��" +  nextLogger.getClass());
			nextLogger.logMessage(level, message);
		}
	}
	
	abstract protected void write(String message);
	
}
