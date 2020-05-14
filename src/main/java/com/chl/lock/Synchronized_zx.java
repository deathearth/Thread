package com.chl.lock;

import java.util.HashMap;

public class Synchronized_zx {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("condition", 1);
		
		//一个线程在执行业务
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					Thread.sleep( 5 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第一个线程执行完毕");
				map.put("condition", 5);
				
			}
		}).start();
		
		//另一个线程在自旋等待其他线程释放资源
		while(true) {
			if(map.get("condition").toString().equals("5")) {
				System.out.println("自旋线程执行完毕");
				break;
			}else {
				try {
					System.out.println("自旋等待....");
					Thread.sleep( 1 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
