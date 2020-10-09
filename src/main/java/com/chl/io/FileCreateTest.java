package com.chl.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCreateTest {


	public static void main(String[] args) {
		 File f = new File("C:\\Users\\MST-KKL\\Desktop\\testing.pdf");
			try {
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	@Deprecated
   public static byte[] File2byte(File tradeFile){
       byte[] buffer = null;
       try
       {
           FileInputStream fis = new FileInputStream(tradeFile);
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
           byte[] b = new byte[1024];
           int n;
           while ((n = fis.read(b)) != -1)
           {
               bos.write(b, 0, n);
           }
           fis.close();
           bos.close();
           buffer = bos.toByteArray();
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }
       return buffer;
   }

}
