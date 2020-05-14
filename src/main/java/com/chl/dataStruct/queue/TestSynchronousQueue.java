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

		
		SynchronousQueue<String> queue =  new SynchronousQueue<String>(true);
		
		new Thread(new Product(queue)).start();
		new Thread(new Consumer(queue)).start();
	}

	
	
	static class Product implements Runnable{
		SynchronousQueue<String> queue;
		
		Product(SynchronousQueue<String> queue){
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				queue.put("a");
				System.out.println(System.currentTimeMillis() + "--" + "输入内容!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static class Consumer implements Runnable{
		SynchronousQueue<String> queue;
		
		Consumer(SynchronousQueue<String> queue){
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				String s = queue.take();
				System.out.println("输出："+s);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
