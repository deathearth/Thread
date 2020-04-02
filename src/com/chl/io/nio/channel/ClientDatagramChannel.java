package com.chl.io.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * DatagramChannel-> test  发送数据到服务器端，并返回服务端的响应信息
 * @author chenhailong
 *
 */
public class ClientDatagramChannel {

	public static void main(String[] args) {
		
		try {
			final DatagramChannel dc = DatagramChannel.open();
			
			// 接收信息
			new Thread(() -> {
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				while (true) {
					try {
						SocketAddress sa = dc.receive(buffer);
						if (sa != null) {
							int position = buffer.position();
							byte b[] = new byte[position];
							buffer.flip();
							for (int i = 0; i < position; i++) {
								b[i] = buffer.get(i);
							}
							System.out.println("接收到的信息为：" + new String(b));
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			// 发送控制台输入消息
			while (true) {
				Scanner sc = new Scanner(System.in);
				String next = sc.next();
				try {
					sendMessage(dc, next);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 发送信息
	 * @param channel
	 * @param mes
	 * @throws IOException
	 */
	public static void sendMessage(DatagramChannel channel, String mes) throws IOException {
        if (mes == null || mes.isEmpty()) {
            return;
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(mes.getBytes("UTF-8"));
        buffer.flip();
        System.out.println("send msg:" + mes);
        channel.send(buffer, new InetSocketAddress("localhost", 9999));
    }
}
