package com.chl.thread;

import java.util.concurrent.Phaser;

/**
 * Java‘阶段器’工具类，类似于CyclicBarrier的多次实现，功能更多
 * @author chenhailong
 * @date 2019年6月10日 下午5:22:06
 */
public class PhaserTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // phaser简单处理
    // basicTest();

    // phaser另一个示例
    example();
  }

  /**
   * 简单实现phaser的功能
   */
  static void basicTest() {
    doPhaser dp = new doPhaser();
    MissionTask[] mt = new MissionTask[5]; // task数组
    for (int count = 0; count < mt.length; count++) {
      mt[count] = new MissionTask(dp);
      dp.register(); // 注册，表示phaser需要维护的线程个数
    }
    //开启线程
    Thread[] thread = new Thread[mt.length];
    for (int i = 0; i < thread.length; i++) {
      thread[i] = new Thread(mt[i], "mission" + i);
      thread[i].start();
    }
    //等待所有线程结束
    for (int i = 0; i < mt.length; i++) {
      try {
        thread[i].join(); // 等待所有任务结束，继续执行后边的逻辑
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("all finished!");
  }

  /**
   * 继承phaser类，并重写onAdvance方法，对Phaser的每一阶段进行处理
   * @author chenhailong
   * @date 2019年6月10日 下午7:43:42
   */
  static class doPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
      try {
        switch (phase) {
          case 0:
            Thread.sleep(1 * 1000l);
            System.out.println("第一阶段");
            break;
          case 1:
            Thread.sleep(1 * 2000l);
            System.out.println("第二阶段");
            break;
          case 2:
            Thread.sleep(1 * 3000l);
            System.out.println("第三阶段");
            break;
          case 3:
            Thread.sleep(1 * 4000l);
            System.out.println("第四阶段");
            break;
          case 4:
            Thread.sleep(1 * 5000l);
            System.out.println("第五阶段");
            break;
          default:
            System.out.println("nono!");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return super.onAdvance(phase, registeredParties);
    }
  }

  /**
   * 根据业务逻辑将线程执行过程分层
   * @author chenhailong
   * @date 2019年6月10日 下午7:47:54
   */
  static class MissionTask implements Runnable {
    private Phaser pha;

    MissionTask(Phaser pha) {
      this.pha = pha;
    }

    @Override
    public void run() {
      System.out.println("开始入场!");
      pha.arriveAndAwaitAdvance();
      System.out.println("开始选择!");
      pha.arriveAndAwaitAdvance();
      System.out.println("开始交流!");
      pha.arriveAndAwaitAdvance();
      System.out.println("交易结束");
      pha.arriveAndAwaitAdvance();
      System.out.println("游戏结束");
      pha.arriveAndAwaitAdvance();
    }
  }

  /***
   * =========================================== 第二个示例
   */
  static void example() {
    SwimingPhaser sp = new SwimingPhaser();
    for (int i = 0; i < 5; i++) {
      sp.register();
      new Thread(new SwimingTask(sp), "swiming" + i).start();
    }
  }

  static class SwimingTask implements Runnable {
    private Phaser p;

    public SwimingTask(Phaser p) {
      this.p = p;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + "选手入场");
      p.arriveAndAwaitAdvance();
      System.out.println(Thread.currentThread().getName() + "开始比赛");
      p.arriveAndAwaitAdvance();
      System.out.println(Thread.currentThread().getName() + "结束比赛");
      p.arriveAndAwaitAdvance();
    }
  }

  static class SwimingPhaser extends Phaser {
    private int phaseToTerminate = 2;//阶段个数

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
      System.out.println(phase + "----" + registeredParties);
      try {
        Thread.sleep(2 * 1000l);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("第" + phase + "阶段");
//      return super.onAdvance(phase, registeredParties); //效果和上一样
      return phase == phaseToTerminate || registeredParties == 0; // 返回true表示phaser逻辑结束
    }
  }

}
