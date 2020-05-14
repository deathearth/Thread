package com.chl.thread;

import java.util.concurrent.Exchanger;

/**
 * java工具类，两个工作线程之间交换数据
 * 
 * @author chenhailong
 * @date 2019年6月11日 上午10:39:43
 */
public class ExchangerTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Exchanger<Integer> a = new Exchanger<Integer>();
    Fills f = new Fills(a);
    Pulls p = new Pulls(a);
    
    new Thread(f).start();
    new Thread(p).start();
    
  }

  static class Fills implements Runnable {
    private Exchanger<Integer> exchanger;

    Fills(Exchanger<Integer> exchanger) {
      this.exchanger = exchanger;
    }
    int water = 10;
    @Override
    public void run() {
      for (;;) {
        try {
          Thread.sleep(2 * 1000l);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
        System.out.println("the current water is " + water);
        if (water == 0) {
          try {
            water = exchanger.exchange(water);
            System.out.println("after change data the water is " + water);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          water--;
        }
      }
    }
  }

  static class Pulls implements Runnable {
    private Exchanger<Integer> exchanger;

    Pulls(Exchanger<Integer> exchanger) {
      this.exchanger = exchanger;
    }
    int air = 0;
    @Override
    public void run() {
      for (;;) {
        try {
          Thread.sleep(2 * 1000l);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
        System.out.println("the current air is " + air);
        if (air == 10) {
          try {
            air = exchanger.exchange(air);
            System.out.println("after change data the air is " + air);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          air++;
        }
      }
    }
  }
}
