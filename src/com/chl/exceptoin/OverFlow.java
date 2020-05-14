package com.chl.exceptoin;

/**
 * 数据溢出的问题
 * @author chenhailong
 *
 */
public class OverFlow {

	public static void main(String[] args) {

		int i = Integer.MAX_VALUE;
		int j = Integer.MAX_VALUE;
		
		int x = i + j;
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(x);
	}

}
