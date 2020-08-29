package com.chl.io;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File f = new File("/‎⁨Users⁩/⁨chenhailong⁩/Desktop⁩/book");
		getD(f);
	}

	
	public static void getD(File f) {
//		if(f.isDirectory()) {
			File[] ff = f.listFiles();
			for(int i = 0; i < ff.length ; i++) {
				if(ff[i].isDirectory()) {
					getD(ff[i]);
				}
				System.out.println(ff[i].getName());
			}
//		}else {
//			System.out.println(f.getName());
//		}
		
	}
	
}
