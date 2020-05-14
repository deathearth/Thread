package com.chl.designpatterns.dp13.proxy.step2;

import com.chl.designpatterns.dp13.proxy.step1.Image;

public class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;
	
	public ProxyImage(String fileName){
		this.fileName = fileName;
	}
	
	public void display() {
		// TODO Auto-generated method stub
		if(realImage == null){
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}
