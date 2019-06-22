package com.chl.rpc.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.chl.rpc.common.CommonModel;
import com.chl.rpc.common.SerializeTool;

/**
 * 代理工厂
 * @author chenhailong
 *
 */
public class ProxyFactory {
	
	private static InvocationHandler handler = new InvocationHandler() {
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

			/**这个是通用的传输对象*/
			CommonModel cm = new CommonModel();
			
			Class<?>[] classes = proxy.getClass().getInterfaces();
			String className = classes[0].getName();
			
			cm.setClassName(className);
			cm.setArgs(args);
			cm.setMethod(method.getName());
			
			String[] types = null;
			if(args != null) {
				types = new String[args.length];
				for(int i = 0;i < types.length; i++) {
					types[i] = args[i].getClass().getName();
				}
			}
			
			cm.setTypes(types);
			
			byte[] byteArray = SerializeTool.serialize(cm);
			Object send = RpcClient.send(byteArray);
			
			return send;
		}
	};
	
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> Clazz) {
		return (T) Proxy.newProxyInstance(Clazz.getClassLoader(), new Class[]{Clazz}, handler);
	}
}
