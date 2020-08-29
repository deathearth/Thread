package com.chl.trycatch;

public class TryCatchFinally {

	public static void main(String[] args) {

	}

	private int abc() {
		try {
			int i = 10;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("1111");
			return 1;
		}
	}

}
