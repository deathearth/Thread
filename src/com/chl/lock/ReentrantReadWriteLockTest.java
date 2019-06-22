package com.chl.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * ReadWriteLock接口，获取读锁和写锁
 * 写操作时，读锁要释放
 * @author chenhailong
 */
public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {

		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		WriteLock wl = lock.writeLock();
		ReadLock rl = lock.readLock();

		WriteBus wb = new WriteBus(wl);
		ReadBus rb = new ReadBus(rl);
		new Thread(wb).start();
		new Thread(rb).start();
	}

}

class WriteBus implements Runnable {
	private WriteLock wl;

	WriteBus(WriteLock wl) {
		this.wl = wl;
	}

	@Override
	public void run() {
		try {
			for (;;) {
				Thread.sleep(3 * 1000l);
				wl.lock();
				System.out.println("开启写锁,持续1s");
				Thread.sleep(1 * 1000l);
				wl.unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class ReadBus implements Runnable {
	private ReadLock rl;

	ReadBus(ReadLock rl) {
		this.rl = rl;
	}

	@Override
	public void run() {
		try {
			for (;;) {
				rl.lock();
				Thread.sleep(1000l);
				System.out.println("开启读锁，一直读取");
				rl.unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
