package com.chl.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * rmi接口
 * @author chenhailong
 *
 */
public interface Hello extends Remote {
	public String hel(String name) throws RemoteException;
}
