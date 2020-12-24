package com.chl.dataStruct.map;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 应用场景：实现比较
 * @author chenhailong
 *
 */
public class TestTreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
		tm.put(1, 1);
		tm.put(2, 2);
		tm.put(3, 3);
		
		for(Map.Entry<Integer,Integer> entry:tm.entrySet()) {
			System.out.println(entry.getKey());
		}
		
		
	}

}
