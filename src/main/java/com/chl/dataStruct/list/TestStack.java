package com.chl.dataStruct.list;

import java.util.Iterator;
import java.util.Stack;


public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<Integer>();
		
		s.add(1);
		s.add(1, 2);
		s.add(3);
		
		System.out.println("取出栈顶元素:" + s.peek());
		System.out.println("取出栈顶元素并移除:" + s.pop());
		System.out.println("放一个元素:" + s.push(4));
		
		Iterator<Integer> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
