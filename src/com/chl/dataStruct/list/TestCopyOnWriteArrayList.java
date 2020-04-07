package com.chl.dataStruct.list;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<String>();
		
		cow.add("s");
		
		System.out.println(cow.get(0));
	}

}
