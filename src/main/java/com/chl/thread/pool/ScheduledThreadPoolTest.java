package com.chl.thread.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池
 * @author MST-KKL
 *
 */
public class ScheduledThreadPoolTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" begin = "+new Date());
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		for(int i=0; i<1; i++){  //如果多个线程是有问题的， 单个线程成功
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            WorkerThread worker = new WorkerThread("--" +i);
            scheduledThreadPool.scheduleWithFixedDelay(worker, 4, 2, TimeUnit.SECONDS);
        }
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduledThreadPool.shutdown();
		while(!scheduledThreadPool.isTerminated()){
        }
        System.out.println("Finished all threads");
	}

}

class WorkerThread implements Runnable{
	 
private String command;
     
    public WorkerThread(String s){
        this.command=s;
    }
 
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start"+command.toString()+" Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End"+command.toString()+" Time = "+new Date());
    }
 
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public String toString(){
        return this.command;
    }
}
