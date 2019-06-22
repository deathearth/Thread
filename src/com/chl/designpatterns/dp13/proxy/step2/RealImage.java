package com.chl.designpatterns.dp13.proxy.step2;

import com.chl.designpatterns.dp13.proxy.step1.Image;

/** ����ʵ�ֽӿڵ�ʵ����*/
public class RealImage implements Image {

	private String fileName;
	
	public RealImage(String fileName){
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying "+ fileName);
	}

	private void loadFromDisk(String fileName){
		System.out.println("Loading "+ fileName);
	}
	
}
