package com.chl.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.chl.rmi.Hello;

public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost",1099);
		Hello hello = (Hello)registry.lookup("h");
		
		System.out.println(hello.hel("abc"));
	}

}
