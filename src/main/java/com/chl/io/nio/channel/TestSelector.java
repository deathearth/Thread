package com.chl.io.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
/**
 * NIO简单实现
 * @author chenhailong
 * 注: 通道必须配置为 非阻塞模式。如果通道在某个事件上被阻塞，那么服务器就不能响应其他事件。 FileChannel不能配置为非阻塞，所以不能使用
 * 示例参考：https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html
 */
public class TestSelector {
	private int ports[];
	private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

	public TestSelector(int ports[]) throws IOException {
		this.ports = ports;
		go();
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private void go() throws IOException {
		// 创建一个选择器
		Selector selector = Selector.open();

		// 监听并注册不同的通道/端口
		for (int i = 0; i < ports.length; ++i) {
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ServerSocket ss = ssc.socket();
			InetSocketAddress address = new InetSocketAddress(ports[i]);
			ss.bind(address);
			SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Going to listen on " + ports[i]);
		}

		while (true) {
			//一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了
			selector.select();
			//访问“已选择键集（selected key set）”中的就绪通道。
			Set selectedKeys = selector.selectedKeys();
			Iterator it = selectedKeys.iterator();

			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();
				if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
					// Accept the new connection
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					// 注册到选择器新的通道
					SelectionKey newKey = sc.register(selector, SelectionKey.OP_READ);
					it.remove();//处理完后从通道移除
					System.out.println("Got connection from " + sc);
				} else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
					// Read the data
					SocketChannel sc = (SocketChannel) key.channel();

					// Echo data，  对缓冲区的操作
					int bytesEchoed = 0;
					while (true) {
						echoBuffer.clear();
						int r = sc.read(echoBuffer);
						if (r <= 0) {
							break;
						}
						echoBuffer.flip();
						sc.write(echoBuffer);
						bytesEchoed += r;
					}
					System.out.println("Echoed " + bytesEchoed + " from " + sc);
					it.remove();//处理完后从通道移除
				}

			}
		}
	}

	static public void main(String args[]) throws Exception {
		if (args.length <= 0) {
			System.err.println("Usage: java MultiPortEcho port [port port ...]");
			System.exit(1);
		}
		int ports[] = new int[args.length];
		for (int i = 0; i < args.length; ++i) {
			ports[i] = Integer.parseInt(args[i]);
		}
		new TestSelector(ports);
	}
}
