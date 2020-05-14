package com.chl.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 同步关键类，
 * 可以做流量控制、池类处理
 * 
 * @author chenhailong
 * @date 2019年6月6日 上午10:25:40
 */
public class SemaphoreTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 示例一
    // Pool pl = new Pool();
    // pl.putItem("b");

    // 示例二
    FlowController fc = new FlowController();
    fc.test();

  }

  /**
   * jdk源码中的semaphore示例
   * @author chenhailong
   * @date 2019年6月10日 上午10:38:47
   */
  static class Pool {
    private static final int MAX_AVAILABLE = 2;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
    protected Object[] items = new Object[] {'a', 'b'};
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    public Object getItem() throws InterruptedException {
      available.acquire(); // 获得许可
      return getNextAvailableItem();
    }

    public void putItem(Object x) {
      System.out.println(available.availablePermits());
      if (markAsUnused(x))
        available.release(); // 释放资源
    }

    protected synchronized Object getNextAvailableItem() {
      for (int i = 0; i < MAX_AVAILABLE; ++i) {
        if (!used[i]) {
          used[i] = true;
          return items[i];
        }
      }
      return null;
    }

    protected synchronized boolean markAsUnused(Object item) {
      for (int i = 0; i < MAX_AVAILABLE; ++i) {
        if (item == items[i]) {
          if (used[i]) {
            used[i] = false;
            return true;
          } else
            return false;
        }
      }
      return false;
    }
  }


  /**
   * 简单流控处理，每次执行10个线程。
   * @author chenhailong
   * @date 2019年6月10日 上午11:01:04
   */
  static class FlowController {
    final int THREAD_NUMS = 30;
    ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUMS);
    void test() {
      Semaphore sh = new Semaphore(10);
      for (int i = 0; i < 30; i++) {
        final String num = i+"";
        pool.execute(() -> {
          try {
            sh.acquire();
            Thread.sleep(1 * 1000);
            System.out.println("doSomething:"+num+";executeTime:"+System.currentTimeMillis());
            sh.release();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        });
      }
      pool.shutdown();
    }
  }

}
