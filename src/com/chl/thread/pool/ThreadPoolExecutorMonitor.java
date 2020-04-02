package com.chl.thread.pool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 监控线程池
 * 
 * @author chenhailong
 *
 */
public class ThreadPoolExecutorMonitor extends ThreadPoolExecutor {

	public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println(Thread.currentThread().getName());
		System.out.println("在开始之后,time" + System.currentTimeMillis());
		super.afterExecute(r, t);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("在开始之前,time" + System.currentTimeMillis());
		super.beforeExecute(t, r);
	}

	@Override
	protected void terminated() {
		System.out.println("在中断时");
		super.terminated();
	}

	public static void main(String[] args) {
		ThreadPoolExecutorMonitor pool = new ThreadPoolExecutorMonitor(5, 10, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

		//10个线程
		for (int i = 0; i < 10; i++) {
			pool.submit(() -> {
				try {
					Thread.sleep((new Random().nextInt(5) + 1) * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("开始一个线程池的任务");
			});
		}
		info(pool);
	}

	public static void info(ThreadPoolExecutorMonitor pool) {
		System.out.println("要执行的任务数：" + pool.getTaskCount());
		System.out.println("已完成的任务数：" + pool.getCompletedTaskCount());
		System.out.println("曾达到的最大数：" + pool.getLargestPoolSize());
		System.out.println("活动中的线程数：" + pool.getActiveCount());

	}

}
