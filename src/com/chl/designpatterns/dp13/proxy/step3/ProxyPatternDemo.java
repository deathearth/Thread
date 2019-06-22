package com.chl.designpatterns.dp13.proxy.step3;

import com.chl.designpatterns.dp13.proxy.step1.Image;
import com.chl.designpatterns.dp13.proxy.step2.ProxyImage;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Image image = new ProxyImage("test_10mb.jpg");
		
		
		image.display();
		
		System.out.println("--");
		
		image.display();
		
	}

}
