package com.chl.dataStruct.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String,Object> ht = new Hashtable<String,Object>(10);
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("aaa", 111);
		map.put("bbb", 222);
		map.put("ccc", 333);
		map.put("", 111);
		
		System.out.println(map.toString());
		
		ht.putAll(map);
		
		System.out.println(ht.toString());
		

	}

}
