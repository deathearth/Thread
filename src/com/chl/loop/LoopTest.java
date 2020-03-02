package com.chl.loop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class LoopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//知道数组长度使用较好
		for(int i = 0; i< 100000; i++) {
			
		}
		
		//是iterator的变种（）
		Set<String> s = new HashSet<String>();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("...");
		for(String str:s) {
			
		}
		
		ArrayList al = new ArrayList();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("...");
		
		//可以在循环中处理更改对象的值，不需要知道位置
		Iterator iter = al.iterator();
		while(iter.hasNext()) {
			iter.next();
		}
		
		
	}

}
