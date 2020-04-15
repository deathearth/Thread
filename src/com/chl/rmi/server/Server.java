package com.chl.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.chl.rmi.Hello;
import com.chl.rmi.i.HelloImpl;

/**
 * rmi 服务端
 * @author chenhailong
 * 
 * Registry先启动，并监听一个端口，一般为1099
 * Server向Registry注册远程对象
 * Client从Registry获得远程对象的代理（这个代理知道远程对象的在网络中的具体位置：ip、端口、标识符），然后Client通过这个代理调用远程方法，
 * Server也是有一个代理的，Server端的代理会收到Client端的调用的方法、参数等，然后代理执行对应方法，并将结果通过网络返回给Client。
 */
public class Server {

	public static void main(String[] args) throws RemoteException {

		Hello hello = new HelloImpl();
		
		Registry registry =  LocateRegistry.createRegistry(1099);
		registry.rebind("h", hello);
		
		while(true) {
			
		}
	}

}
