package com.chl.orc;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tess4jOcrTest {

	public static void main(String[] args) {
//		System.setProperty("TESSDATA_PREFIX", "/opt/language/");
		
		String bath = "/Users/chenhailong/Desktop/";
		test1(bath + "test.jpeg");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
