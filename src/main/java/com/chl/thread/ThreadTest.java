package com.chl.thread;

import java.util.concurrent.Executor;

/**
 * java线程类 Thread
 * 
 * @author chenhailong
 * @date 2019年6月10日 下午4:51:09 
 */
public class ThreadTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    T t1 = new T();
    T t2 = new T();
    
    
    
    
    //run()只是一个方法，会在主线程内顺序执行
    t1.start();
    t2.start();
  }

  static class T extends Thread{
    @Override
    public void run() {
      for(int i = 0;i < 10;i++) {
        try {
          Thread.sleep(2 * 1000l);
          System.out.println("这是"+i);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }
}
