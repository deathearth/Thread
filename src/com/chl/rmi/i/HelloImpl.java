package com.chl.rmi.i;

import java.io.Serializable;
import java.rmi.RemoteException;

import com.chl.rmi.Hello;

public class HelloImpl implements Hello,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6513105475936692234L;

	/**
	 * 构造函数
	 * @throws RemoteException
	 */
	public HelloImpl() throws RemoteException{
		
	}

	@Override
	public String hel(String name) throws RemoteException {
		return "Hello, "+ name;
	}

}
