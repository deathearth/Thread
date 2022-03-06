package com.chl.qzzbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {

		
		String s = "/Users/chenhailong/Desktop/book/心理学书籍343本/《变态心理学》罗伯特·G·迈耶\\保罗·萨门-著，1988年(美)pdf格式下载-心理学书籍.zip";
//		s = "/Users/chenhailong/Desktop/book/心理学书籍343本/《变态人格心理分析》S.R曼格尔-著，1988年(印)pdf格式下载-心理学书籍.zip";
		File fb = new File(s);
		if(!fb.exists()) {
			try {
				fb.createNewFile();
			} catch (IOException e) {
				
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		
		try {
			FileOutputStream fos2 = new FileOutputStream(fb);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
