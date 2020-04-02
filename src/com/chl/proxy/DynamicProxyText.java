package com.chl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * 静态代理
创建一个接口，然后创建被代理的类实现该接口并且实现该接口中的抽象方法。
之后再创建一个代理类，同时使其也实现这个接口。
在代理类中持有一个被代理对象的引用，而后在代理类方法中调用该对象的方法。


动态代理
利用反射机制在运行时创建代理类。





 */




/**
 * 动态代理实现
 * 通过实现InvocationHandler接口达到目的
 * 代理对象无需实现接口，免去了编写很多代理类的烦恼，同时接口增加方法也无需再维护目标对象和代理对象，只需在事件处理器中添加对方法的判断即可
 * @author chenhailong
 */
public class DynamicProxyText {

	public static void main(String[] args) {
		//被代理对象
		elephant el = new elephant();
		//中介类
		landAnimals la = new landAnimals(el);
		//类加载器
		ClassLoader loader = el.getClass().getClassLoader();
		//代理类一
		animals a = (animals)Proxy.newProxyInstance(loader, el.getClass().getInterfaces(), la);
		a.growUpTime();
		
		//代理类二
		animals b = vegetarianAnimals.getInstance(animals.class);
		b.growUpTime();
	}
}

/**
 * 通用动物操作
 */
interface animals{
	void growUpTime();
}

/**
 * 大象的成长
 */
class elephant implements animals{
	
	@Override
	public void growUpTime() {
		try {
			Thread.sleep(5 * 1000l);
			System.out.println("after 5 s,elephant is getting bigger !");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * 代理为陆地动物
 */
class landAnimals implements InvocationHandler{
	
	private animals als ;
	
	landAnimals(animals als){
		this.als = als;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before growup--!"+ System.currentTimeMillis());
		method.invoke(als, args);
		System.out.println("after  growup--!"+ System.currentTimeMillis());
		return null;
	}
}

/**
 * 素食动物
 */
class vegetarianAnimals{
	
	static InvocationHandler handler = new InvocationHandler() {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//获取proxy的接口类
			System.out.println(proxy.getClass().getInterfaces()[0].getName());
			System.out.println("before eat--!"+ System.currentTimeMillis());
			method.invoke(new elephant(), args);
			System.out.println("after  eat--!"+ System.currentTimeMillis());
			return null;
		}
	};
	
	@SuppressWarnings("unchecked")
	static <T> T getInstance(Class<T> cls) {
		return (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, handler);
	}
}
