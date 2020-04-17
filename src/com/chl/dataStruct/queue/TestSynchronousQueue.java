package com.chl.dataStruct.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * 每个插入操作必须等待另一个线程的对应移除操作.SynchronousQueue没有容纳元素的能力，即它的isEmpty()方法总是返回true，但是给人的感觉却像是只能容纳一个元素。
 * @author chenhailong
 * 参考：https://blog.csdn.net/zmx729618/article/details/52980158
 */
public class TestSynchronousQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SynchronousQueue<String> queue =  new SynchronousQueue<String>(false);
		
		queue.offer("123");
		queue.offer("234");
		
		System.out.println(queue.size());
		
	}

}
