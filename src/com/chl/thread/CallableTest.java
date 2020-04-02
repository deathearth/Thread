package com.chl.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java线程接口，与runnable不同的是，可以抛出异常并有返回值
 * 配合 FutureTask执行
 * 
 * @author chenhailong
 * @date 2019年6月13日 下午7:07:17
 */
public class CallableTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    ExecutorService es = Executors.newFixedThreadPool(5);
    String poolStr = "";
    Calls cs = new Calls();
    try {


      // 一、如果直接调用call方法，并没有开启一个新的线程,打印线程id可以看出来
//       System.out.println(Thread.currentThread().getName());
//       cs.call();

      // 二、配合FutureTask运行
//      FutureTask<String> ft = new FutureTask<String>(cs);
//      System.out.println(Thread.currentThread().getId());
//      new Thread(ft).start();
//      ft.get(); //执行结果
      
      //二、2 配合Future运行
      Future<String> f = es.submit(cs);
      System.out.println(f.get());
      
//      //三、线程池处理
//      for(int i = 0;i< 10;i++) {
//        pool p = new pool(i+"");
//        poolStr = poolStr +"---"+ es.submit(p).get();
//        System.out.println(poolStr);
//      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  static class Calls implements Callable<String> {
    @Override
    public String call() throws Exception {
      int num = new Random().nextInt(3);
      System.out.println(Thread.currentThread().getId());
      if (num % 2 == 0) {
        Integer.parseInt("s");
      }
      return num + "";
    }
  }
  
  //线程池做法示例类
  static class pool implements Callable<String> {
    private String str;
    
    pool(String str){
      this.str = str;
    }
    @Override
    public String call() throws Exception {
      return str;
    }
  }

}
