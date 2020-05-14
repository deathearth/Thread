package com.chl.base;

import org.apache.commons.lang.StringUtils;

/**
 * 拼接字符串
 * @author chenhailong
 *
 */
public class TestString {

	public static void main(String[] args) {

		
		//1
		String s = "abc";
		s.concat("def");
		
		//2
		StringBuffer sb = new StringBuffer();
		sb.append("a");
		
		//3
		StringBuilder ssb = new StringBuilder();
		ssb.append("c");
		
		//4
		String[] ls = {"123","123"};
		StringUtils.join(ls);
		
		//5
		s = s+"def";  //Java中的+对字符串的拼接，其实现原理是使用StringBuilder.append
	}

}
