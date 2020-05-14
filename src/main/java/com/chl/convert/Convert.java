package com.chl.convert;

/**
 * 进制转换
 * @author chenhailong
 *
 */
public class Convert {

	public static void main(String[] args) {
		
		String x = "0201";
		String hex_ = "0033";
		long desc = Long.parseLong(x, 16);
		System.out.println(desc);
		desc = Long.parseLong(hex_, 16);
		System.out.println(desc);
	}

}
