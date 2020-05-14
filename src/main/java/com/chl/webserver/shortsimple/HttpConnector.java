//package com.chl.webserver.shortsimple;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.security.AccessControlException;
//import java.util.Stack;
//import java.util.Vector;
//
//import org.apache.catalina.Lifecycle;
//import org.apache.catalina.LifecycleException;
//
///**
// * 简单示例 tomcat4默认连接器的 同时处理多个http请求 整理自 catalina-4.1.36.jar
// * 
// * @author chenhailong
// *
// */
//public class HttpConnector implements Runnable {
//
//	// 最小实例个数
//	protected int minProcessors = 5;
//
//	// 最大实例个数
//	private int maxProcessors = 20;
//	// 当前实例数量
//	private int curProcessors = 0;
//	// httpProcessor实例池
//	private Stack processors = new Stack();
//
//	private Vector created = new Vector();
//	
//	// serverSocket服务
//	private ServerSocket serverSocket = null;
//	//The thread synchronization object.
//	private Object threadSync = new Object();
//
//	private boolean initialized = false;
//	private boolean started = false;
//	private boolean stopped = false;
//	// 超时设置
//	private int connectionTimeout = 60000;
//	// 没有延时
//	private boolean tcpNoDelay = true;
//
//	@Override
//	public void run() {
//		while(!this.stopped) {
//			Socket socket = null;
//			
//			try {
//				socket = this.serverSocket.accept();
//				if(this.connectionTimeout > 0) {
//					socket.setSoTimeout(connectionTimeout);
//				}
//				socket.setTcpNoDelay(this.tcpNoDelay);
//			}catch(AccessControlException ace) {
//				continue;
//			}catch (IOException e) {
//				try {
//					//异常处理
//				}catch(Exception ee) {
//				
//				}
//				continue;
//			}
//			
//			//创建HttpProcessor实例对象进行请求响应
//			HttpProcessor processor = createProcessor();
//			if(processor == null) {
//				try {
//					socket.close();
//				}catch(IOException e) {
//					
//				}
//				continue;
//			}else {
//				processor.assign(socket);
//			}
//		}
//		
//		synchronized (this.threadSync)
//	    {
//	      this.threadSync.notifyAll();
//	    }
//		
//	}
//
//	//判断当前实例数量，进行创建
//	private HttpProcessor createProcessor() {
//		synchronized (this.processors) {
//			if (this.processors.size() > 0) {
//				return (HttpProcessor) this.processors.pop();
//			}
//			if ((this.maxProcessors > 0) && (this.curProcessors < this.maxProcessors)) {
//				return newProcessor();
//			}
//			if (this.maxProcessors < 0) {
//				return newProcessor();
//			}
//			return null;
//		}
//	}
//
//	//创建新的HttpProcessor实例
//	private HttpProcessor newProcessor() {
//		HttpProcessor processor = new HttpProcessor(this, this.curProcessors++);
//		if ((processor instanceof Lifecycle)) {
//			try {
//				processor.start();
//			} catch (LifecycleException e) {
//				return null;
//			}
//		}
//		this.created.addElement(processor);
//		return processor;
//	}
//	
//	//将当前实例放到栈顶，(对HttpProcessor资源的回收)
//	void recycle(HttpProcessor processor)
//	  {
//	    this.processors.push(processor);
//	  }
//	
//}
