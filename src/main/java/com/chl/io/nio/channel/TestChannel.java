package com.chl.io.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO Channel + Buffer 实例
 * 
 * @author chenhailong
 *
 */
public class TestChannel {

	public static void main(String[] args) {
		// 项目当前路径
		// System.out.println(System.getProperty("user.dir"));
		try {
			// 读取当前文件相对路径的资源文件
			RandomAccessFile aFile = new RandomAccessFile("src/com/chl/nio/channel/data.txt", "r");
			FileChannel fChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(24); // 每次读取的大小
			int byteRead = fChannel.read(buf); // 读取到buffer中
			while (byteRead != -1) {
				System.out.println("Read--" + byteRead);
				buf.flip(); // 写模式切换到读模式
				while (buf.hasRemaining()) { // 告诉当前位置和limit之间是否有任何元素。
					System.out.println((char) buf.get());
				}
				buf.clear(); // 读完之后清空缓冲区，继续读取
				byteRead = fChannel.read(buf);
			}
			aFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
