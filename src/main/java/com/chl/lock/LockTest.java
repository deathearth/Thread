package com.chl.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock: java锁对象，实现了比synchronized更广泛的锁操作
 * lock是一个接口，只有 ReentrantLock
 * @author chenhailong
 */
public class LockTest {

	public static void main(String[] args) {
		
		//无锁的场景设置
		
//		NormalQueue nq =  new NormalQueue();
//		JumpAQueue jaq =  new JumpAQueue();
//		
//		new Thread(nq).start();
//		try {
//			Thread.sleep(1 * 1000l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		new Thread(jaq).start();
		
		//有锁的场景设置
		
		Lock lock = new ReentrantLock();
		LockQueue lq = new LockQueue(lock);
		CutInLine cil = new CutInLine(lock);
		
		new Thread(lq).start();
		try {
			Thread.sleep(1 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(cil).start();
	}

}


/**
 * 一个正常的线程
 */
class NormalQueue implements Runnable{
	@Override
	public void run() {
		System.out.println("小明正在排队入场，需要等待10s!");
		try {
			for(int i = 0;i<10;i++) {
				Thread.sleep(1 * 1000l);
				System.out.println("还剩"+(9-i)+"秒");
			}
			System.out.println("小明正式入场!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 一个插队队列
 */
class JumpAQueue implements Runnable{

	@Override
	public void run() {
		System.out.println("小王想插队!");
		try {
			Thread.sleep(1 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("小王插队成功!,小明多等了1s");
	}
}

/**
 * 一个带锁的线程队列
 */
class LockQueue implements Runnable {

	Lock lock;
	
	LockQueue(Lock lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		System.out.println("小丽正在排队上厕所，需要等待10s!");
		try {
			
			/**
			 * 如果当前线程未被中断，则获取锁；如果锁可用，则获取锁并立即返回；
			 * 如果锁不可用，则禁用当前线程，并且处于以下情况处休眠种
			 * 【当前线程获得锁，其他线程中断当前线程，并支持对锁获取的中断。
			 * */
//			lock.lockInterruptibly();
			
			lock.lock();
			for(int i = 0;i<10;i++) {
				Thread.sleep(1 * 1000l);
				System.out.println("还剩"+(9-i)+"秒");
			}
			System.out.println("小丽进去了!");
			lock.unlock();
			System.out.println("资源释放了!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * 一个线程尝试获取锁
 */
class CutInLine implements Runnable{

	Lock lock;
	
	CutInLine(Lock lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("小红想插队!");
			for(;;) {
				if(!lock.tryLock()) {
					Thread.sleep(1 * 1000l);
					System.out.println("小红问小丽可以插队吗？小丽说no!");
				}else {
					break;
				}
			}
			System.out.println("小红尿湿了裤子!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
