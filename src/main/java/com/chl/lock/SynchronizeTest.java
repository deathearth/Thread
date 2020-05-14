package com.chl.lock;

import java.math.BigDecimal;

/**
 * java同步关键字
 * 同步普通方法，锁的是当前对象。同步静态方法，锁的是当前 Class 对象。同步块，锁的是 {} 中的对象。
 * 如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。 
 * @author chenhailong
 */
public class SynchronizeTest {
	
	public static void main(String[] args) {
		
		//第一部分，简单的线程执行过程控制
		
//		BlockAsync ba = new BlockAsync();
//		new Thread(ba).start();
//		new Thread(ba).start();
//
//		BlockSync bs = new BlockSync();
//		new Thread(bs).start();
//		new Thread(bs).start();
		
		//输出结果看，这里是无序的
//		currentThread:Thread-0---count:0
//		currentThread:Thread-1---count:1
//		currentThread:Thread-0---count:2
//		currentThread:Thread-1---count:3
//		currentThread:Thread-0---count:4
//		currentThread:Thread-1---count:5
//		currentThread:Thread-0---count:6
//		currentThread:Thread-1---count:7
//		currentThread:Thread-0---count:8
//		currentThread:Thread-1---count:9
		
		//这里是有序的
//		currentThread:Thread-2---count:0
//		currentThread:Thread-2---count:1
//		currentThread:Thread-2---count:2
//		currentThread:Thread-2---count:3
//		currentThread:Thread-2---count:4
//		currentThread:Thread-3---count:5
//		currentThread:Thread-3---count:6
//		currentThread:Thread-3---count:7
//		currentThread:Thread-3---count:8
//		currentThread:Thread-3---count:9

		
		//第二部分，模拟账户控制,  Synchronize的添加与否对结果影响很大
		Account a = new Account("小明",new BigDecimal(1000));
		AccountOperation ao = new AccountOperation(a);
		for(int i = 0;i<5;i++) {
			new Thread(ao).start();
		}
	}
}

/**
 * 异步的执行线程
 */
class BlockAsync implements Runnable{
	private static int count ;
	
	BlockAsync(){
		count = 0;
	}

	@Override
	public void run() {
		for(int i = 0;i<5;i++) {
			System.out.println("currentThread:"+Thread.currentThread().getName()+"---count:"+count++);
		}
	}
	
}

/**
 * 同步的执行线程
 */
class BlockSync implements Runnable{
	private static int count ;
	
	BlockSync(){
		count = 0;
	}

	@Override
	public void run() {
		synchronized (this) {
			for(int i = 0;i<5;i++) {
				System.out.println("currentThread:"+Thread.currentThread().getName()+"---count:"+count++);
			}
		}
	}
	
}




/**
 * 设定一个账户类，统一的操作方法
 */
class Account {
	String name;
	BigDecimal money;
	
	Account(String name,BigDecimal money){
		this.name = name;
		this.money = money;
		System.out.println("小明一开始有"+money+"元");
	}
	
	void Get(BigDecimal get) {
		money = money.subtract(get);
		System.out.println("小明取钱"+get+"元");
	}
	
	void Put(BigDecimal put) {
		money = money.add(put);
		System.out.println("小明存钱"+put+"元");
	}
	
	BigDecimal getMoney() {
		return money;
	}
}

/**
 * 单独的线程操作每个账户
 */
class AccountOperation implements Runnable{
	
	private Account accout;
	
	AccountOperation(Account account){
		accout = account;
	}

	@Override
	public synchronized void run() {
		accout.Get(new BigDecimal(150));
		accout.Put(new BigDecimal(200));
		System.out.println("小明现在还有 "+ accout.getMoney()+"钱");
	}
}
