package com.chl.rpc.common;

import java.io.Serializable;

/**
 * 公共网络通信类，通过序列化该类,将客户端调用接口、方法、参数、参数类型封装，然后服务端反序列化,再通过反射,调取相应实现类的方法。
 * @author chenhailong
 *
 */
public class CommonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**接口名称*/
	private String className;
	/**方法名称*/
	private String method;
	/**方法参数*/
	private Object[] args;
	/**参数类型*/
	private String[] types;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	

}
