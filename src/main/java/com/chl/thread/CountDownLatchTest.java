package com.chl.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 同步辅助类，允许一个或多个线程等待其他的线程系列操作 结束之后开始执行
 * 
 * @author chenhailong
 * @date 2019年6月10日 上午11:04:30
 * 
 * 
 * await(带超时时间的处理，可以解决阻塞异常)
 */
public class CountDownLatchTest {

  /**
   * @param args
   */

  public static void main(String[] args) {
    //jdk代码中的示例
    //new CountDownLatchTest().officalExample();
    
    //简单示例
    new CountDownLatchTest().basicUse();
  }

  /**
   * jdk1.8的文档官方示例
   * 两个计数器，一个执行完之后等待另一个执行。
   */
  void officalExample() {
    int thread = 10;
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(thread);
    for (int i = 0; i < thread; i++) {
      new Thread(new Worker(startSignal, doneSignal)).start();
    }
    System.out.println("startSignal计数减1");
    startSignal.countDown();
    try {
      System.out.println("等待doneSignal的计数减为0!");
      doneSignal.await();
      System.out.println("开始执行其他业务");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
      this.startSignal = startSignal;
      this.doneSignal = doneSignal;
    }
    @Override
    public void run() {
      try {
        startSignal.await();
        //startSignal.await(111, TimeUnit.SECONDS); //boolean 可判断
        long sleepTime = (new Random().nextInt(4)+1) * 1000l;
        Thread.sleep(sleepTime);
        System.out.println("当前线程的执行时间为"+sleepTime+"s");
        doneSignal.countDown();
        System.out.println("计数减1,当前计数为"+doneSignal.getCount());
      } catch (InterruptedException ex) {
      }
    }
  }

  
  
  /**
   * 简单的使用CountDownLatch进行业务逻辑执行
   * 计数器记录两个线程的任务，完成之后，执行其他的任务
   */
  void basicUse() {
    final int countNum = 2;
    System.out.println("计数器初始化数据为：2");
    CountDownLatch cdl = new CountDownLatch(countNum);
    ExecutorService pool = Executors.newFixedThreadPool(30);
    for(int i = 0;i<2;i++) {
      final int turn = i+1;
      pool.execute(() -> {
        try {
          long randomCount = (new Random().nextInt(10)+1) * 1000l;
          System.out.println("第"+turn+"个线程随机执行x秒!"+randomCount);
          Thread.sleep(randomCount);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        cdl.countDown();
        System.out.println("第"+turn+"个线程执行完之后，计数减1");
      }); 
    }
    try {
      System.out.println("等待所有线程执行完毕...");
      cdl.await();
      System.out.println("计数减为0后，业务继续执行");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  
}
