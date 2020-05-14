package com.chl.thread.pool;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 利用concurrentHashMap达到线程隔离目的
 * 
 * @author chenhailong
 */
public class ThreadIsolateTest {

	public static void main(String[] args) {
		ExecutorWrong ew = new ExecutorWrong();

		// //错误现象演示
		// for (int i = 0; i < 10; i++) {
		// new Thread(() -> {
		// try {
		// //初始化对象
		// Properties pr = new Properties();
		// pr.setId(new Random().nextInt(100));
		// pr.setName(UUID.randomUUID().toString());
		//
		// ew.set(pr);
		// //Thread.sleep(1 * 1000);//逻辑处理时间越长，出错率越高
		// System.out.println("wrong===="+ Thread.currentThread().getName() +"-before:
		// "+ pr +"-after：" + ew.get());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// }).start();
		// }
		//
		// try {
		// Thread.sleep(3 * 1000);
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		System.out.println("隔离线输出-------------");

		// 隔离现象演示
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					// 初始化对象
					Properties pr = new Properties();
					pr.setId(new Random().nextInt(100));
					pr.setName(UUID.randomUUID().toString());

					ew.set(pr);
					// Thread.sleep(1 * 1000);//逻辑处理时间越长，出错率越高
					System.out.println(
							"wrong====" + Thread.currentThread().getName() + "-before: " + pr + "-after：" + ew.get());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}).start();
		}
	}

}

/**
 * 测试对象
 */
class Properties {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Properties [id=" + id + ", name=" + name + "]";
	}
}

class ExecutorWrong {
	private Properties pro;

	void set(Properties pro) {
		this.pro = pro;
	}

	Properties get() {
		return pro;
	}

}

class ExecutorRight {
	Map<Thread, Properties> map = new ConcurrentHashMap<Thread, Properties>();

	@SuppressWarnings("unused")
	private Properties pro;

	void set(Properties pro) {
		this.pro = pro;
		map.put(Thread.currentThread(), pro);
	}

	Properties get() {
		return map.get(Thread.currentThread());
	}

}