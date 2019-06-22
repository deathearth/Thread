package com.chl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 
 * @author chenhailong
 * @date 2019年6月10日 下午4:02:27 
 */
public class CyclicBarrierTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    new CyclicBarrierTest().basicUser();
  }
  
  /**
   * cyclicBarrier的基本使用
   * 10个线程任务全部执行完之后，才继续执行下面的任务
   */
  void basicUser() {
    final int threadNum = 10;
    CyclicBarrier cb = new CyclicBarrier(10);
    ExecutorService pool = Executors.newFixedThreadPool(threadNum);
    for(int i = 0;i<threadNum;i++ ) {
      final int turn = i;
      pool.execute(() -> {
        long randomCount = (new Random().nextInt(10)+1) * 1000l;
        System.out.println("第"+turn+"个线程随机执行"+randomCount+"秒!");
        try {
          Thread.sleep(randomCount);
          cb.await();
          System.out.println("全部执行完毕，所有任务开始继续执行");
        } catch (InterruptedException | BrokenBarrierException e) {
          e.printStackTrace();
        }
      });
    }
    
//    for(;;) {
//      int waiting = cb.getNumberWaiting();
//      try {
//        Thread.sleep(3 * 1000l);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      System.out.println("等待中的数量"+waiting);
//    }
  }
  
  
  /**
   * JDK1.8的源码示例代码说明
   * @author chenhailong
   * @date 2019年6月10日 下午4:49:39
   */
  class Solver{
    final int N;
    final float[][] data;
    final CyclicBarrier barrier;
    
    public Solver(float[][] matrix) {
      data = matrix;
      N = matrix.length;
      Runnable barrierAction = new Runnable() {
        @Override
        public void run() {
          //TODO 
          //do some mergeRows operations
          System.out.println("merge Action!");
        }
      };
      barrier = new CyclicBarrier(N,barrierAction);
      
      List<Thread> threads = new ArrayList<Thread>(N);
      for(int i = 0;i<N;i++) {
        Thread thread = new Thread(new Worker(i));
        threads.add(thread);
        thread.start();
      }
      
      //wait until done
      for(Thread thread: threads) {
        try {
          thread.join();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    
    class Worker implements Runnable{
      int myRow ;
      Worker(int row){
        myRow = row;
      }
      @Override
      public void run() {
        while(true) {
          System.out.println("continue;");
          try {
            barrier.await();
            break;
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (BrokenBarrierException e) {
            e.printStackTrace();
          }
        }
        
      }
      
    }
  }
 
}
