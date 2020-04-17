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
		//每个插入操作必须等待另一个线程的对应移除操作 -> 无队列长度
		ExecutorService es1 = Executors.newCachedThreadPool();
		//固定10个 -> 无界队列
		ExecutorService es2 = Executors.newFixedThreadPool(10);
		//单个线程 -> 无界队列
		ExecutorService es3 = Executors.newSingleThreadExecutor();
		//延时队列 -> 无界，到时才从队列中取出
		ExecutorService es4 = Executors.newScheduledThreadPool(10);
		//抢占式线程池
		ExecutorService es5 = Executors.newWorkStealingPool();

		
	}

}
