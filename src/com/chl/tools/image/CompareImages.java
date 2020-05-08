package com.chl.tools.image;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author chenhailong
 * 参考：https://www.iteye.com/blog/chenxu-8456-1322020(像素对比)
 * 参考：https://blog.csdn.net/u013248535/article/details/53929605/(图片获取像素)
 *
 */
public class CompareImages {

	public static void main(String[] args) {

		
		getXY("/Users/chenhailong/Desktop/cigar.png");
	}

	
	
	
	public static int CompareImagesNormal() {
		
		
		return 0;
	}
	
	
	private static String[][] getXY(String image){
		String[][] list = null;
		int[] rgb = new int[3];
		try {
			BufferedImage bi = ImageIO.read(new File(image));
			int w = bi.getWidth();
			int h = bi.getHeight();
			int x = bi.getMinX();
			int y = bi.getMinY();
			list = new String[bi.getWidth()][bi.getHeight()];
			
			//第一种获取像素的方式
			for(int i = x;i< w; i++) {
				for(int j = y; j< h; j++) {
					list[i][j] = bi.getRGB(i, j) + "";
	                System.out.printf("%s%s%s\t",rgb[0],rgb[1],rgb[2]);
				}
			}
			
			//第二种获取像素的方式，(这个调整有点繁琐)
//			Raster raster = bi.getData();
//			int[] temp = new int[raster.getWidth()*raster.getHeight()*raster.getNumBands()];
//			int [] pixels  = raster.getPixels(0,0,raster.getWidth(),raster.getHeight(),temp);
//            for (int i=0;i<pixels.length;) {
//                if((i%raster.getWidth()*raster.getNumBands())==0)//输出一列数据比对
//                    System.out.printf("ff%x%x%x\t",pixels[i],pixels[i+1],pixels[i+2]);
//                i+=3;
//            }
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	private void tempCul(int pixel) {
//		  rgb[0] = (pixel & 0xff0000) >> 16;  
//        rgb[1] = (pixel & 0xff00) >> 8;  
//        rgb[2] = (pixel & 0xff); 

	}
	
}
