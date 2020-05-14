package com.chl.tools.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author chenhailong
 * 参考：https://www.iteye.com/blog/chenxu-8456-1322020(像素对比)
 * 参考：https://blog.csdn.net/u013248535/article/details/53929605/(图片获取像素)
 * 参考：https://blog.csdn.net/CY19980216/article/details/103339082(python版破解， 对比度增强相关)
 *
 */
public class CompareImages {
	
	//界定两个图片的RGB差值为多少之后，确定是阴影。因为有的背景图会设置干扰项，所以这个不一定准确（）
	private static int RANGE = 50;

	public static void main(String[] args) {
		CompareImagesNormal();
	}

	/**
	 * 循环坐标对比原图+缺口图的X轴坐标信息
	 * @return
	 */
	public static int CompareImagesNormal() {
		
		int[][] fullbg = getXY("/Users/chenhailong/Desktop/geetest_fullbg.webp");
		int[][] bg = getXY("/Users/chenhailong/Desktop/geetest_bg.webp");
		for(int i = 0; i< fullbg.length; i++) {
			for(int j = 0; j < fullbg[i].length ; j++) {
				if(tempCul(fullbg[i][j], bg[i][j])) {
					return i; //这里返回横坐标
				}
			}
		}
		return 0;
	}
	
	
	private static int[][] getXY(String image){
		int[][] list = null;
		try {
			BufferedImage bi = ImageIO.read(new File(image));
			int w = bi.getWidth();
			int h = bi.getHeight();
			int x = bi.getMinX();
			int y = bi.getMinY();
			list = new int[bi.getWidth()][bi.getHeight()];
			
			//第一种获取像素的方式，方便计算
			for(int i = x;i< w; i++) {
				for(int j = y; j< h; j++) {
					list[i][j] = bi.getRGB(i, j) ;
//	                System.out.printf("%s%s%s\t",rgb[0],rgb[1],rgb[2]);
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
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 获取旧/新的像素点，进行RGB对比，差值范围为RANGE(一些情况会有图片变暗等处理)
	 * @param origion 源
	 * @param news    新
	 * @return
	 */
	private static boolean tempCul(int origion, int news) {
		int[] a = getRGB(origion);
		int[] b = getRGB(news);
		for(int i = 0; i < 3; i++) {
			if(Math.abs( a[i] - b[i]) > RANGE) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 根据像素点获取rgb颜色
	 * @param pixel
	 * @return
	 */
	private static int[] getRGB(int pixel) {
		int[] rgb = new int[3];
		rgb[0] = (pixel & 0xff0000) >> 16; 
		rgb[1] = (pixel & 0xff00) >> 8;  
		rgb[2] = (pixel & 0xff); 
		return rgb;
	}
	
}
