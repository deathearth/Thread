package com.chl.tools.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 处理图片信息
 * @author chenhailong
 *
 */
public class CutImages {

	public static void main(String[] args) {
		
//		String path = "/Users/chenhailong/Desktop/test1.jpg";
//		String dir = "/Users/chenhailong/Desktop/new-test1.jpg";
		
		String path = "/Users/chenhailong/Desktop/test2.jpg";
		String dir = "/Users/chenhailong/Desktop/new-test2.jpg";
		
		File f = new File(path);
		
		try {
			System.out.println(f.getCanonicalPath());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!f.exists()) {
			try {
				BufferedImage bi = ImageIO.read(f);
				
				int width = bi.getWidth();   //原始宽度
				int height = bi.getHeight(); //原始高度
				
				BufferedImage newImg = bi.getSubimage(0, 0, width, height-100); 
				
				ByteArrayOutputStream out =new ByteArrayOutputStream();
				ImageIO.write(newImg, "png", out);
				byte[] barray = out.toByteArray();
				
				FileOutputStream fos = new FileOutputStream(dir);
				fos.write(barray);
				
				if(out != null) {
					out.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				
			}
		}
	}
}
