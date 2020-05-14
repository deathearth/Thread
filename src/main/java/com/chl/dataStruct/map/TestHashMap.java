package com.chl.dataStruct.map;

import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Object> hm = new HashMap<String,Object>(2);
		
		String s = "abcdefg";
		
		int h ;
		System.out.println( (h = s.hashCode())^(h >>> 16));
		
		
		
		hm.put("s",s);
		
		
	}

}
