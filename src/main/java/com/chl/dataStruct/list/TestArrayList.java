package com.chl.dataStruct.list;

import java.util.ArrayList;

public class TestArrayList {

	public static int unit = 1024*1024;//1MB
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> al = new ArrayList<Object>(10);
		
		
//		for(int i = 0;i<6;i++) {
//			al.add(new byte[1 * unit]);
//		}
//		
//		
//		al.add(5,new byte[1 * unit]);
//		
//		System.out.println(al.toString());
//		
//		System.out.println(al.subList(0, 7));
		
		al.add(111l);
		al.add(112l);
		System.out.println(al.toString());
		
	}

}
