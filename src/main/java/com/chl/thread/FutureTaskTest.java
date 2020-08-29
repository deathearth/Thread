package com.chl.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * java线程接口，与runnable不同的是，可以抛出异常并有返回值 配合 FutureTask执行
 * 
 * 
 * dubbo底层的io处理是异步的。它的同步操作是通过 future.get(waittime)实现线程的阻塞
 * 
 * @author chenhailong
 * @date 2019年6月13日 下午7:07:17
 */
public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//    String poolStr = "";
		Calls cs = new Calls();
		try {

			// 一、如果直接调用call方法，并没有开启一个新的线程,打印线程id可以看出来
			System.out.println(Thread.currentThread().getName());
			cs.call();

			// 二、配合FutureTask运行
			FutureTask<String> ft = new FutureTask<String>(cs);
			System.out.println(Thread.currentThread().getId());
			new Thread(ft).start();
			
			ft.get(5, TimeUnit.SECONDS); // 执行结果

		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	static class Calls implements Callable<String> {
		@Override
		public String call() throws Exception {
			int num = new Random().nextInt(3);
			System.out.println("ThreadId : "+Thread.currentThread().getId());
			if (num % 2 == 0) {
				
			}
			Thread.sleep(5 * 1010);
			return num + "";
		}
	}

	// 线程池做法示例类
	static class pool implements Callable<String> {
		private String str;
		pool(String str) {
			this.str = str;
		}
		@Override
		public String call() throws Exception {
			return str;
		}
	}
}
