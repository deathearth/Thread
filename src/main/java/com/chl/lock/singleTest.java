package com.chl.lock;
public class singleTest {
	void test() {
		synchronized(this) {
			System.out.println("Hello World!");
		}
	}
}
