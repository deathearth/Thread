package com.chl.map;

import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap hm = new HashMap();
		
		String s = "abcdefg";
		
		int h ;
		System.out.println( (h = s.hashCode())^(h >>> 16));
	}

}
