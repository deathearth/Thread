/*
 * Copyright 2016 kaistart.com All right reserved. This software is the
 * confidential and proprietary information of kaistart.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with kaistart.com.
 */
package com.chl.thread;

/**
 * java本地线程变量,在每个线程内对该变量创建一个副本，在线程任何地方都可以使用，相互之间不影响。但是要考虑内存的占用率
 * 
 * @author chenhailong
 * @date 2019年6月11日 下午1:48:38
 */
public class ThreadLocalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadLocalTest tt = new ThreadLocalTest();

		new Thread(tt.new test()).start();
		new Thread(tt.new print()).start();
	}

	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	class test implements Runnable {
		
		@Override
		public void run() {
			try {
				for(int i = 0;i<10;i++) {
					Thread.sleep(500);
					threadLocal.set(i);
					System.out.println("current set-"+i+";thread-1-"+threadLocal.get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
	}

	class print implements Runnable {
		
		@Override
		public void run() {
			try {
				for(int i = 10;i>0;i--) {
					Thread.sleep(1 * 1000);
					threadLocal.set(i);
					System.out.println("current set-"+i+";thread-2-"+threadLocal.get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
