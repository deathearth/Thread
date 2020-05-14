package com.chl.thread;


/**
 * java线程类，runnable的实现
 * 
 * @author chenhailong
 * @date 2019年6月10日 下午5:14:34
 */
public class RunnableTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    R r = new R();
    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    
    t1.start();
    t2.start();
  }

  static class R implements Runnable {
    @Override
    public void run() {
      try {
        for (int i = 0; i < 10; i++) {
          System.out.println("这是++"+i);
          Thread.sleep(2 * 1000l);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
