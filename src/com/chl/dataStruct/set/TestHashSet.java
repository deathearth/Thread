package com.chl.dataStruct.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set set = new HashSet();
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		
		
		System.out.println(set.toString());
	}

}
