package com.chl.thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

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

	public static void main(String[] args) throws InterruptedException {
		
		//有结果的任务
		int[] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i+1;
		}
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> result = pool.submit(new ForkAndJoinTest().new SumTask(arr,0,arr.length));
		System.out.println("----"+result.invoke());
		pool.shutdown();
		
		//无结果的任务
		long[] a = new long[120];
		for(int i = 0;i< a.length; i++) {
			a[i] = (long)(Math.random() * 1000);
		}
		System.out.println("before sort"+Arrays.toString(a));
		pool = new ForkJoinPool();
		pool.submit(new SortTask(a));
		pool.awaitTermination(5, TimeUnit.SECONDS);
		pool.shutdown();
		
		System.out.println("after sort"+Arrays.toString(a));
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

	
	
	/**
	 * 排序处理
	 * @author chenhailong
	 * 使用了RecursiveAction没有返回结果的。
	 */
	@SuppressWarnings("serial")
	private static class SortTask extends RecursiveAction{

		static final int THRESHOLD = 100;
		
		long[] array;
		int lo,hi;
		
		public SortTask(long[] array,int lo,int hi) {
			this.array = array;
			this.lo = lo;
			this.hi = hi;
		}
		
		public SortTask(long[] array) {
			this(array,0,array.length);
		}
		
		public void sortSequentially(int lo,int hi) {
			Arrays.sort(array,lo,hi);
		}
		
		public void merge(int lo,int mid,int hi) {
			long[] buf = Arrays.copyOfRange(array, lo, mid);
			for(int i = 0,j = lo,k = mid;i < buf.length;j++) {
				array[j] = (k == hi || buf[i] < array[k]) ? buf[i++] : array[k++];
			}
		}
		
		@Override
		protected void compute() {
			if(hi - lo < THRESHOLD) {
				sortSequentially(lo,hi);
			}else {
				int mid = (lo + hi )>>> 1;
				invokeAll(new SortTask(array,lo,mid),new SortTask(array,mid,hi));
				merge(lo,mid,hi);
			}
		}
		
	}
}
