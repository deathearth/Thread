package com.chl.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors 线程池工具类
 * 可以创建不同类型的线程池对象，按需选择
 * @author chenhailong
 *
 */
public class ExecutorsTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ExecutorService es1 = Executors.newCachedThreadPool();
		
		ExecutorService es2 = Executors.newFixedThreadPool(10);
		
		ExecutorService es3 = Executors.newSingleThreadExecutor();
		
		ExecutorService es4 = Executors.newScheduledThreadPool(10);
		
		ExecutorService es5 = Executors.newWorkStealingPool();

		
	}

}
