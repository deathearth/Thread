package com.chl.orc;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITessAPI.TessPageIteratorLevel;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tess4jOcrTest {

	public static void main(String[] args) {
//		System.setProperty("TESSDATA_PREFIX", "/opt/language/");
		
//		String bath = "/Users/chenhailong/Desktop/";
//		test1(bath + "test.jpeg");
		
		
		String bath = "/Users/chenhailong/Desktop/image12.png";
		
		getPosition(bath);
	}
	
	/**
	 * 根据路径识别文字结果
	 * @param path
	 */
	public static void test1(String path) {
		File file = new File(path);
		ITesseract it = new Tesseract();
//		it.setDatapath("/opt/language/");
		it.setDatapath("/usr/local/Cellar/tesseract/3.05.02/share/");
		it.setLanguage("chi_sim");
		try {
			String result = it.doOCR(file);
			System.out.println("识别结果:");
			System.out.println(result );
		} catch (TesseractException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据获取识别图片的坐标
	 * @param path
	 */
	public static void getPosition(String path) {
		File file = new File(path);
		ITesseract it = new Tesseract();
		it.setDatapath("/usr/local/Cellar/tesseract/3.05.02/share/");
		it.setLanguage("chi_sim");
		try {
			BufferedImage bi = ImageIO.read(file);
			
			/**
			  	RIL_BLOCK		按块分	Block of text/image/separator line
				RIL_PARA		按段分	Paragraph within a block
				RIL_TEXTLINE	按行分	Line within a paragraph
				RIL_WORD		按单词分	Word within a textline
				RIL_SYMBOL		按字母分
			 */
			
			List<Rectangle> list = it.getSegmentedRegions(bi, TessPageIteratorLevel.RIL_WORD);
			System.out.println("识别结果:");
			for(int i = 0;i < list.size(); i++) {
				Rectangle rect = list.get(i);
				System.out.println( it.doOCR(file, rect)+ "x:"+rect.x+"-y:"+ rect.y);
				
			}
			
			
		} catch (TesseractException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
