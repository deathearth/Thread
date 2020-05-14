package com.chl.proxy.cglib;

import com.chl.proxy.DynamicProxyText;

public class Test{
	
	public static void main(String[] args) {
		
		CglibTest ct = new CglibTest();
		DynamicProxyText s = (DynamicProxyText)ct.getProxy(DynamicProxyText.class);
		s.main(args);
	}
	
}

