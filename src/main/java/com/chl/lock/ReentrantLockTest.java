package com.chl.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * java中唯一实现 Lock接口的类，可以查看当前线程持有锁数量和 队列中等待拿锁的长度
 * @author chenhailong
 */
public class ReentrantLockTest {

	public static void main(String[] args) {
		ReentrantLock rtl = new ReentrantLock();
		FlowTime ft = new FlowTime(rtl);
		FlowQueue fq = new FlowQueue(rtl);
		new Thread(ft).start();
		new Thread(fq).start();
	}

}

class FlowTime implements Runnable {
	private ReentrantLock rtl;

	FlowTime(ReentrantLock rtl) {
		this.rtl = rtl;
	}

	@Override
	public void run() {
		try {
			rtl.lock();
			Thread.sleep(1 * 1000l);
			System.out.println("当前FT" + Thread.currentThread().getName() + "持有该锁的数量" + rtl.getHoldCount() + "--queue长度"
					+ (rtl.getQueueLength() > 0 ? rtl.getQueueLength() + "--FT在等待" : 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		rtl.unlock();
	}

}

class FlowQueue implements Runnable {
	private ReentrantLock rtl;

	FlowQueue(ReentrantLock rtl) {
		this.rtl = rtl;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1 * 1000l);
			rtl.lock();
			int count = rtl.getHoldCount();
			System.out.println("当前FQ" + Thread.currentThread().getName() + "持有该锁的数量" + count + "--queue长度"
					+ (rtl.getQueueLength() > 0 ? rtl.getQueueLength() + "--FQ在等待" : 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		rtl.unlock();
	}

}