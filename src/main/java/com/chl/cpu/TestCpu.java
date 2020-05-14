package com.chl.cpu;

public class TestCpu {

	public static void main(String[] args) {

		int num = Runtime.getRuntime().availableProcessors();
		System.out.println(num+"个CPU");
	}

}
