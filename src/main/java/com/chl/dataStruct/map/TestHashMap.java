package com.chl.dataStruct.map;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Object> hm = new HashMap<String,Object>(2);
		
		hm.put("734449887340363776", 1);
		hm.put("742720327904821248", 1);
		hm.put("742799312353394688", 0);
		hm.put("742720327904821248", 0);
		hm.put("742720327904821248", 0);
		hm.put("742720327904821248", 1);
		hm.put("743239374702542848", 0);
		
		System.out.println(JSON.toJSON(hm));
		
		
		
		
		
		
		
		
		
		
	}

}
