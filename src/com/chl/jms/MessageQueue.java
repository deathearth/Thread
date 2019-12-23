package com.chl.jms;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消息机制的存放、读取实现。
 * 这里使用ArrayBlockingQueue来实现队列模型(最简化的话，可以使用vector、stack等集合对象，但是要考虑数据的存取方式【先进先出、现金后出等方式】，还要考虑多线程情况下的线程安全问题)
 * 
 * 该类有两个方法
 * 一个是往队列存储消息
 * 一个是从队列获取消息
 * 注：这里增加了同步锁，保证了数据的正确性。
 * 
 * @author chenhailong
 *
 */
public class MessageQueue {

	/** 这里的队列对象视情况使用，可以使用list\queue\map类的集合对象 */
	private static Queue<String> msgQueue = new ArrayBlockingQueue<String>(100);

	/**
	 * 生产消息
	 * 
	 * @param msg
	 */
	public static void produce(String msg) {
		// 这里锁msgQueue，保证同时只有一个线程操作msgQueue
		synchronized (msgQueue) {
			while (msgQueue.size() >= 100) {
				// 这里对 queue的大小做判断，当容量不足，线程等待
				try {
					msgQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			msgQueue.add(msg);
			System.out.println("当前队列的大小为" + msgQueue.size());
			// 生产消息后，唤醒其他等待线程
			msgQueue.notifyAll();
		}
	}

	/**
	 * 消费消息
	 */
	public static String consumer() {
		synchronized (msgQueue) {
			while (msgQueue.size() < 0) {
				// 这里对 queue的大小做判断，当小于0，不执行消费任务
				try {
					msgQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 获取并删除队列中的第一个元素
			String msg = msgQueue.poll();
			System.out.println("当前队列的大小为" + msgQueue.size());
			// 消费消息后，唤醒其他等待线程
			msgQueue.notifyAll();
			return msg;
		}
	}
}
