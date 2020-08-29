package com.chl.dataStruct.automic;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoTest {
	
	

	public static void main(String[] args) {

		AtomicInteger ai = new AtomicInteger();
		ai.incrementAndGet();
		
		System.out.println(ai.get());
	
	}

}
