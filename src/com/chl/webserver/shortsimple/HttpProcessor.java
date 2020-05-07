//package com.chl.webserver.shortsimple;
//
//import java.net.Socket;
//
//import org.apache.catalina.Lifecycle;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.LifecycleListener;
//import org.apache.catalina.util.LifecycleSupport;
//
//public class HttpProcessor implements Runnable, Lifecycle {
//
//	private HttpConnector connector = null;
//	private boolean available = false;
//	private Socket socket = null;
//	private Thread thread = null;
//	private boolean started = false;
//	private Object threadSync = new Object();
//	private String threadName = null;
//	private LifecycleSupport lifecycle = new LifecycleSupport(this);
//
//	// 构造函数
//	public HttpProcessor(HttpConnector connector, int id) {
//		// this.connector = connector;
//		// this.debug = connector.getDebug();
//		// this.id = id;
//		// this.proxyName = connector.getProxyName();
//		// this.proxyPort = connector.getProxyPort();
//		// this.request = ((HttpRequestImpl)connector.createRequest());
//		// this.response = ((HttpResponseImpl)connector.createResponse());
//		// this.serverPort = connector.getPort();
//		// this.threadName = ("HttpProcessor[" + connector.getPort() + "][" + id + "]");
//	}
//	
//	//由HttpConnector调用
//	synchronized void assign(Socket socket) {
//		while (this.available) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//			}
//		}
//		this.socket = socket;
//		this.available = true;
//		notifyAll();
//		// if ((this.debug >= 1) && (socket != null)) {
//		// log(" An incoming request is being assigned");
//		// }
//	}
//
//	//启动HttpProcessor时调用(与上面的不在同一个线程运行)
//	private synchronized Socket await() {
//		while (!this.available) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//			}
//		}
//		Socket socket = this.socket;
//		this.available = false;
//		notifyAll();
//		// if ((this.debug >= 1) && (socket != null)) {
//		// log(" The incoming request has been awaited");
//		// }
//		return socket;
//	}
//
//
//	@Override
//	public void run() {
//		while(!this.started) {
//			Socket socket = await();
//			if(socket != null) {
//				try {
//					process(socket);
//				}catch(Throwable t) {
//					// ..
//				}
//				this.connector.recycle(this);
//			}
//		}
//		synchronized (this.threadSync) {
//			this.thread.notifyAll();
//		}
//	}
//	
//	//解析请求头等信息
//	private void process(Socket socket) {
//		//处理请求流信息..
//	}
//
//	//开始当前线程
//	private void threadStart() {
//		// log(this.sm.getString("httpProcessor.starting"));
//		this.thread = new Thread(this, this.threadName);
//		this.thread.setDaemon(true);
//		this.thread.start();
//		// if (this.debug >= 1) {
//		// log(" Background thread has been started");
//		// }
//	}
//
//	// Lifecycle 实现类
//	
//	@Override
//	public void start() throws LifecycleException {
//
//		this.lifecycle.fireLifecycleEvent("start", null);
//		this.started = true;
//		threadStart();
//	}
//	
//	@Override
//	public void addLifecycleListener(LifecycleListener arg0) {
//	}
//
//	@Override
//	public LifecycleListener[] findLifecycleListeners() {
//		return null;
//	}
//
//	@Override
//	public void removeLifecycleListener(LifecycleListener arg0) {
//
//	}
//
//	@Override
//	public void stop() throws LifecycleException {
//	}
//
//	
//}
