package com.chl.io.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Datagram - 服务端，接收信息并响应
 * @author chenhailong
 *
 */
public class ServerDatagramChannel {

	public static void main(String[] args) {
		try {
			DatagramChannel dc = DatagramChannel.open();
			dc.bind(new InetSocketAddress("localhost", 9999));  // connect()方法的使用没成功，说明参考 https://blog.csdn.net/xiaoyezi1001/article/details/12388269
			
			ByteBuffer bb = ByteBuffer.allocate(1024);
			while (true) {
				bb.clear();
				// 接收数据
				SocketAddress sa = dc.receive(bb);
				System.out.println("SocketAddress info :" + sa);
				if (sa != null) {
					int position = bb.position();
					byte b[] = new byte[position];
					bb.flip();
					for (int i = 0; i < position; i++) {
						b[i] = bb.get(i);
					}
					sendReback(sa, dc);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//响应数据
	public static void sendReback(SocketAddress socketAddress, DatagramChannel datagramChannel) throws IOException {
		String message = "已经收到数据!";
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put(message.getBytes("UTF-8"));
		buffer.flip();
		datagramChannel.send(buffer, socketAddress);
	}

}
