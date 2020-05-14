package com.chl.proxy.cglib;

import java.lang.reflect.Method;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

class CglibTest implements MethodInterceptor{
	
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(@SuppressWarnings("rawtypes") Class cls) {
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();//通过字节码技术创建子类实例
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("before");
		
		Object res = arg3.invokeSuper(arg0, arg2);
		System.out.println("before");
		return res;
	}

}

