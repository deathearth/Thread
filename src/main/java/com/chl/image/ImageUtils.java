package com.chl.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * 图片处理
 * 国内 红底白字
 * 国际 在观察
 * @author chenhailong
 *
 */
public class ImageUtils {
	
	public static int w  = 300;
	public static int h = 150;
	public static int f = 60; //默认字体大小 -像素
	public static int n = 10;   //默认每行6个字
	public static String pub = "中华人民共和国";
	
	
	
	public static String createPictureUn(String title, String path) throws Exception {
		
		String dw = title + ".jpg";
		
		//得到图片缓冲区 (宽度、高度，图片类型)
		BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		//得到它的绘制环境(这张图片的笔) 
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.fillRect(0,0,w,h);//填充一个矩形 左上角坐标(0,0),宽70,高150;填充整张图片 
		g2.setColor(Color.white); //填充颜色
		g2.fillRect(0,0,w,h);//填充整张图片(其实就是设置背景颜色)
//		g2.setColor(Color.black);//边框
//		g2.drawRect(0,0,w-1,h-1); //画边框
		g2.setFont(new Font("微软雅黑",Font.BOLD,100)); //设置字体:字体、字号、大小 
		g2.setColor(Color.black);//设置背景颜色
		
		g2.drawString(title, 30 , 105); //同等大小
		ImageIO.write(bi,"JPEG",new FileOutputStream(path+"/"+dw));
		return title;
	}
	
	
	
	
	public static void main(String[] args) {
		String path = "C:\\Users\\MST-KKL\\Desktop\\";
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("ESTP");
//		al.add("ISFJ");
//		al.add("INFJ");
//		al.add("INTJ");
//		al.add("ISTP");
//		al.add("ISFP");
//		al.add("INFP");
//		al.add("INTP");
//		
//		al.add("ESTP");
//		al.add("ESFP");
//		al.add("ENFP");
//		al.add("ENTP");
//		al.add("ESTJ");
//		al.add("ESFJ");
//		al.add("ENFJ");
//		al.add("ENTJ");
//		
//		al.add("MBTI");
		try {
			for(int i = 0 ; i < al.size() ; i++) {
				createPictureUn(al.get(i), path);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
