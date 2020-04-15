package com.chl.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQStest extends AbstractQueuedSynchronizer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		AQStest aqs = new AQStest();
		
		
//		aqs.tryReleaseShared(1);
		
		aqs.setState(2);
		
		System.out.println(aqs.getState());
		
		System.out.println(aqs.getQueueLength());

		System.out.println(aqs.toString());
	}

	
}
