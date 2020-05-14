package com.chl.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 它用来替代传统的Object的wait()、notify()实现线程间的协作，使用Condition的await()、signal()这种方式实现线程间协作更加安全和高效。
 * @author chenhailong
 */
public class ConditionTest {
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();

	public static void main(String[] args) {

		ConditionTest ct = new ConditionTest();
		new Thread(ct.new PlanA()).start();
		new Thread(ct.new PlanB()).start();
	}
	
	class PlanA implements Runnable{

		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("planA:waiting for planB finished!");
				con.await();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("planA:ok, finished it over!");
				lock.unlock();
			};
		}
	}
	
	class PlanB implements Runnable{

		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("planB:i need finish this work quickly, and push the entire plan!");
				con.signalAll();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("planB:i did it ");
				lock.unlock();
			}
		}
	}
	
}

