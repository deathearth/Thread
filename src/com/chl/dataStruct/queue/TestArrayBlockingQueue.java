package com.chl.dataStruct.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TestArrayBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new ArrayBlockingQueue<>(10);
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.offer(4);
		
		System.out.println(q.peek());
		System.out.println(q.poll()); //去除并移除
		System.out.println(q.peek());
		System.out.println(q.poll()); //去除并移除
		System.out.println(q.peek());
		System.out.println(q.poll()); //去除并移除
		System.out.println(q.peek());
	}

}
