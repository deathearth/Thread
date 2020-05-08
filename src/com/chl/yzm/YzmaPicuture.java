package com.chl.yzm;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图形验证码的生成
 * 
 * @author chenhailong 可以使用工具 jar：https://mvnrepository.com/search?q=captcha
 *         示例：jcaptcha , 官网：http://jcaptcha.sourceforge.net/
 *
 */
public class YzmaPicuture {

	public static void main(String[] args) {
		try {
			
			PictureMaker pm = new PictureMaker();
			BufferedImage image = new BufferedImage(pm.getWidth(), pm.getHeight(), BufferedImage.TYPE_INT_BGR);
			Graphics2D g = image.createGraphics();
			// 定义字体样式
			Font myFont = new Font("黑体", Font.BOLD, 50);
			// 设置字体
			g.setFont(myFont);
			g.setColor(pm.getRandomColor(200, 250));
			// 绘制背景
			g.fillRect(0, 0, pm.getWidth(), pm.getHeight());
			g.setColor(pm.getRandomColor(180, 200));
			pm.drawRandomLines(g, 20);
			
			//先出现，再画线
			String verifyCode = pm.drawRandomString(4, g);
			
			
			System.out.println("verifyCode:" + verifyCode);
			g.dispose();

			String path = "/Users/chenhailong/Desktop/test.jpeg";
			File f = new File(path);
			ImageIO.write(image, "JPEG", f);
			
//			Tess4jOcrTest.test1(path); //识别效果不准
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
