package com.chl.thread;

import java.util.concurrent.Executor;

public class ExecutorTest implements Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorTest et = new ExecutorTest();
		
		et.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("abc");
			}
		});
		
	}

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		System.out.println("bbc");
		command.run();
		
	}

}
