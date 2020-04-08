package com.chl.dataStruct.queue;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestPriorityBlockingQueue {

	public static void main(String[] args) {

		Queue<String> q = new PriorityBlockingQueue<String>();
		System.out.println(q.size());
	}

}
