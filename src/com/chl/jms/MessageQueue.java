package com.chl.jms;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MessageQueue {

	/**这里的队列对象视情况使用，可以使用list\queue\map类的集合对象 */
	private static Queue<String> msgQueue = new ArrayBlockingQueue<String>(100);
	
	/**
	 * 生产消息
	 * @param msg
	 */
	public static void produce(String msg) {
		//这里锁msgQueue，保证同时只有一个线程操作msgQueue
		synchronized (msgQueue) {
			while(msgQueue.size() >= 100) {
				//这里对 queue的大小做判断，当容量不足，线程等待
				try {
					msgQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			msgQueue.add(msg);
			
			//生产消息后，唤醒其他等待线程
			msgQueue.notifyAll();
		}
	}
	
	/**
	 * 消费消息
	 */
	public static String consumer() {
		synchronized (msgQueue) {
			while(msgQueue.size() < 0) {
				//这里对 queue的大小做判断，当小于0，不执行消费任务
				try {
					msgQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//获取并删除队列中的第一个元素
			String msg = msgQueue.poll();
			//消费消息后，唤醒其他等待线程
			msgQueue.notifyAll();
			return msg;
		}
	}
}
