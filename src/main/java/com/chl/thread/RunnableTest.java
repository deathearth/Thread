package com.chl.thread;

/**
 * java线程类，runnable的实现
 * 
 * @author chenhailong
 * @date 2019年6月10日 下午5:14:34
 */
public class RunnableTest {

	public static String obj1 = "obj1";
    public static String obj2 = "obj2";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock1 l1 = new Lock1();
		Thread a = new Thread(l1);
		
		Lock2 l2 = new Lock2();
		Thread b = new Thread(l2);
		
		a.start();
		b.start();
	}

}

class Lock1 implements Runnable {
	@Override
	   public void run(){
	    try{
	     System.out.println("Lock1 running");
	     while(true){
	      synchronized(RunnableTest.obj1){
	       System.out.println("Lock1 lock obj1");
	       Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
//	       synchronized(RunnableTest.obj2){
//	        System.out.println("Lock1 lock obj2");
//	       }
	      }
	     }
	    }catch(Exception e){
	     e.printStackTrace();
	    }
	   }
}

class Lock2 implements Runnable {
	@Override
	   public void run(){
	    try{
	     System.out.println("Lock2 running");
	     while(true){
	      synchronized(RunnableTest.obj2){
	       System.out.println("Lock2 lock obj2");
	       Thread.sleep(3000);//获取obj2后先等一会儿，让Lock1有足够的时间锁住obj1
//	       synchronized(RunnableTest.obj1){
//	        System.out.println("Lock2 lock obj1");
//	       }
	      }
	     }
	    }catch(Exception e){
	     e.printStackTrace();
	    }
	   }
}