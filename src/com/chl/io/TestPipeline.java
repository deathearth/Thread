package com.chl.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * IO中的 PipedOutputStream，PipedInputStream 从一个线程中读取另一个线程的数据
 * @author chenhailong
 *
 */
public class TestPipeline {

	public static void main(String[] args) throws IOException {
		
		// 分别创建输入和输出的管道流
		final PipedOutputStream outputPipe = new PipedOutputStream();
		// PipedInputStream(output);构造器将管道数据流和管道输入流建立通信
		final PipedInputStream inputPipe = new PipedInputStream(outputPipe);
		// 在第一个线程将数据写入管道输出流
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					outputPipe.write("Hello world, pipe!".getBytes());
				} catch (IOException e) {
				}
			}
		});
		// 第二个线程从管道输入流中读取数据
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = inputPipe.read();
					while (data != -1) {
						System.out.print((char) data);
						data = inputPipe.read();
					}
				} catch (IOException e) {
				}
			}
		});
		thread1.start();
		thread2.start();
	}

}
