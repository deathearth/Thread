package com.chl.dataStruct.set;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> set = new HashSet<Integer>(3);
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		set.add(11);

		
		System.out.println(set.toString());
	}

}
