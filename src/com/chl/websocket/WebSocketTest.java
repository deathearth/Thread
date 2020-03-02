package com.chl.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 * webSocket.jar  使用来自以下地址
 * https://repo1.maven.org/maven2/org/java-websocket/Java-WebSocket/1.4.0/ 
 * @author chenhailong
 */
public class WebSocketTest extends WebSocketServer {

	/**
	 * 构造函数
	 * @param port
	 * @throws UnknownHostException
	 */
	public WebSocketTest( int port ) throws UnknownHostException {
		super( new InetSocketAddress( port ) );
	}

	/**
	 * 构造函数
	 * @param address
	 */
	public WebSocketTest( InetSocketAddress address ) {
		super( address );
	}

	/**
	 * 打开连接时的监听事件
	 * conn.send(msg);   //发送信息给最新的客户端
	 * broadcast();      //广播模式，发送给所有连接此端口的客户端
	 */
	@Override
	public void onOpen( WebSocket conn, ClientHandshake handshake ) {
		conn.send("欢迎访问webSocket服务!");  
		broadcast( "new connection: " + handshake.getResourceDescriptor() );  
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " 来到了这个聊天室!" );
	}

	/**
	 * 关闭连接时的监听事件
	 * 
	 */
	@Override
	public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
		broadcast("连接为："+ conn + "的端已经离开了这个聊天室 !" );
		System.out.println("连接为："+ conn + "的端已经离开了这个聊天室 !");
	}

	/**
	 * 监听字符串消息，并广播
	 */
	@Override
	public void onMessage( WebSocket conn, String message ) {
		broadcast( message );
		System.out.println("连接为："+ conn + "的端发送消息: " + message );
	}
	
	/**
	 * 监听字节消息，并广播
	 */
	@Override
	public void onMessage( WebSocket conn, ByteBuffer message ) {
		broadcast( message.array() );
		System.out.println("连接为："+ conn + "的端发送消息: " + message );
	}

	/**
	 * main方法，创建并开启webSocket服务端， 轮询消息并输出
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main( String[] args ) throws InterruptedException , IOException {
		int port = 9999; 
		try {
			port = Integer.parseInt( args[ 0 ] );
		} catch ( Exception ex ) {
		}
		WebSocketTest s = new WebSocketTest( port );
		s.start();
		System.out.println( "WebSocket 服务端已经运行，端口为: " + s.getPort() );

		//这里是控制台输入，可以更改为数据库读取或者nosql查询等
		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		while ( true ) { //可以设置查询时间
			String in = sysin.readLine();
			s.broadcast( in );
			if( in.equals( "exit" ) ) {
				s.stop(1000);
				break;
			}
		}
	}
	
	/**
	 * 监听错误事件
	 */
	@Override
	public void onError( WebSocket conn, Exception ex ) {
		ex.printStackTrace();
		if( conn != null ) {
			// some errors like port binding failed may not be assignable to a specific websocket
		}
	}

	/**
	 * 监听开启事件
	 */
	@Override
	public void onStart() {
		System.out.println("WebSocket 服务端已经正常开启!");
		setConnectionLostTimeout(0);
		setConnectionLostTimeout(100);
	}

}
