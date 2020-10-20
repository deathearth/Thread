package com.chl.thread.pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class LimiterTest {

	public static void main(String[] args) {
		
		int taskSize = 10;
		// 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        
        for(int i = 0;i < 100 ;i++) {
	        Calls c = new Calls();
	        Future f = pool.submit(c);
	        
	        String s;
			try {
				s = (String) f.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	        FutureTask<String> futureTask = new FutureTask<String>(c);
//	        futureTask.run();
//	        try {
//				String s = futureTask.get();
//				System.out.println("====="+s);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
	}
}


class Calls implements Callable<String> {
    @Override
    public String call() throws Exception {
      int num = new Random().nextInt(3);
      System.out.println(Thread.currentThread().getId() +":num :" + num);
      Thread.sleep( 3 * 1000);
      return num + "";
    }
  }
