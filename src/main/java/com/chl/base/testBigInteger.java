package com.chl.base;

import java.math.BigInteger;

/**
*
*
* @author By chl
* @date 2020年8月26日-上午10:08:21
*/
public class testBigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger bi = BigInteger.ONE;
		System.out.println(bi);
		bi = bi.shiftLeft(1);
		System.out.println(bi);
		System.out.println(new BigInteger("1").shiftLeft(1));
	}

}
