package com.chl.io.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 在NIO中，使用Pipe来从另一个线程中获取数据。
 * @author chenhailong
 *
 */
public class TestPipe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pipeExample();
	}

	public static void pipeExample() {
		Pipe pipe = null;
		ExecutorService exec = Executors.newFixedThreadPool(2);
		try {
			// 创建pipe
			pipe = Pipe.open();
			final Pipe pipeTemp = pipe;
			// 线程一向管道中写入数据
			exec.submit(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					Pipe.SinkChannel sinkChannel = pipeTemp.sink();// 向通道中写数据
					while (true) {
						TimeUnit.SECONDS.sleep(1);
						String newData = "hello world" + System.currentTimeMillis();
						ByteBuffer buf = ByteBuffer.allocate(1024);
						buf.clear();
						buf.put(newData.getBytes());
						// 反转后可读
						buf.flip();
						while (buf.hasRemaining()) {
							System.out.println(buf);
							sinkChannel.write(buf);
						}
					}
				}
			});
			// 线程二读取管道中的数据
			exec.submit(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					Pipe.SourceChannel sourceChannel = pipeTemp.source();// 向通道中读数据
					while (true) {
						TimeUnit.SECONDS.sleep(1);
						ByteBuffer buf = ByteBuffer.allocate(1024);
						buf.clear();
						// 可读大小
						int bytesRead = sourceChannel.read(buf);
						System.out.println("bytesRead=" + bytesRead);
						while (bytesRead > 0) {
							buf.flip();
							byte b[] = new byte[bytesRead];
							int i = 0;
							while (buf.hasRemaining()) {
								b[i] = buf.get();
								System.out.printf("%X", b[i]);
								i++;
							}
							String s = new String(b);
							System.out.println("========>>>>>>" + s);
							// 无数据时跳出当前循环体
							bytesRead = sourceChannel.read(buf);
						}
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			exec.shutdown();
		}
	}

}
