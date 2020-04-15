package com.chl.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 将任务分割成多个子任务，然后合并成大任务 ForkJoinPool
 * @author chenhailong
 * 参考：https://www.cnblogs.com/cjsblog/p/9078341.html
 * 
 * ForkJoinTask需要通过ForkJoinPool来执行，
 * 任务分割出的子任务会添加到当前工作线程所维护的双端队列中，
 * 进入队列的头部。当一个工作线程的队列里暂时没有任务时，
 * 它会随机从其他工作线程的队列的尾部获取一个任务。
 * 
 */
public class ForkAndJoinTest {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i+1;
		}
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> result = pool.submit(new ForkAndJoinTest().new SumTask(arr,0,arr.length));
		System.out.println("----"+result.invoke());
		pool.shutdown();
		
	}
	
	/**
	 * 创建一个ForkJoin任务
	 * @author chenhailong
	 * RecursiveTask：有返回结果
	 * RecursiveAction：没有返回结果
	 */
	@SuppressWarnings("serial")
	private class SumTask extends RecursiveTask<Integer>{

		private static final int THRESHOLD = 2; //阈值，差值小于这个数就不再拆分
		
		private int arr[];
		private int start;
		private int end;
		
		public SumTask(int[] arr,int start,int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}
		
		/**
		 * 主要计算体
		 * 小于阈值进行汇总计算，否则继续拆分
		 */
		@Override
		protected Integer compute() {
			if((end - start) <= THRESHOLD) { 
				return subtotal();
			}else {
				int middle = (start+end)/2;
				SumTask left = new SumTask(arr,start,middle);
				SumTask right = new SumTask(arr,middle,end);
				left.fork();
				right.fork();
				
				return left.join() + right.join();
			}
		}
		
		/**
		 * 将段内的数据叠加
		 * @return
		 */
		private Integer subtotal() {
			Integer sum = 0;
			for(int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;
		}
	}

}
