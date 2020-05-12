package com.chl.spider;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chl.tools.image.CompareImages;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * 极验测试地址：https://www.geetest.com/demo/click-bind.html
 * 
 * 
 * 百度OCR识别测试地址：https://ai.baidu.com/tech/ocr/general
 * python相关示例代码：https://blog.csdn.net/diegen8187/article/details/85265113
 * 利用深度学习破解点击验证码：https://zhuanlan.zhihu.com/p/34186397
 */
public class GeetestClickProcessor implements PageProcessor {

	Logger logger = LoggerFactory.getLogger(GeetestClickProcessor.class);
	public static String baseUrl = "https://www.geetest.com/demo/click-bind.html";

	static {
		System.getProperties().setProperty("webdriver.chrome.driver",
				"/Users/chenhailong/Downloads/tools/nessarytool/chromedriver");
	}

	@Override
	public void process(Page page) {
		try {
			WebDriver w = new ChromeDriver();
			w.get(baseUrl);
			Thread.sleep(1 * 1000);

			if (BaseUtil.doesWebElementExist(w, By.id("btn"))) {

				w.findElement(By.id("btn")).click();
				Thread.sleep(3 * 1000);

				String path = "/Users/chenhailong/Desktop/base.png";
				String base = w.findElement(By.className("geetest_tip_img")).getAttribute("style");
				String img = base.split("url(\"")[1];
				img = img.substring(0, img.indexOf("\")"));
				
				path = "/Users/chenhailong/Desktop/find.png";
				String find = w.findElement(By.className("geetest_item_img")).getAttribute("src");
				FileUtil.downloadPicture(find, path, null);
				Thread.sleep(3 * 1000); //下载图片后对比
				
				int x = CompareImages.CompareImagesNormal(); //获取缺口x坐标
				x = x - 5;  //有时候滑块并不是在x=0的位置上，有偏移
				
				WebElement move = w.findElement(By.className("geetest_slider_button"));
				Actions action = new Actions(w);
				action.moveToElement(move).perform();
				action.clickAndHold(move).perform();
				
//				//第一种：水平匀速移动，  怪物吃了拼图
//				int mod = 0;
//				if(x > 10) { mod = x/10; }
//				for (int i = 0; i < mod; i++) {
//					  action.moveByOffset(10, 0).perform();
//					  Thread.sleep(200);
//				}
//				action.dragAndDropBy(move,(x - mod*10), 0).perform();
				
//				//第二种：前快中匀后快，超过后返回，   怪物吃了拼图
//				int mod = 0;
//				if(x > 0) {mod = x/10;}
//				for(int i = 0; i< mod;i++) {
//					if(i<2) {
//						action.moveByOffset(10, 0).perform();
//						Thread.sleep(new Random().nextInt(5) * 200 );
//					}else if(mod - i > 2) {
//						action.moveByOffset(10, 0).perform();
//						Thread.sleep(5 * 200 );
//					}else {
//						action.moveByOffset(10, 0).perform();
//						Thread.sleep(2 * 200 );
//					}
//				}
//				int d = new Random().nextInt(20);
//				action.moveByOffset((x - mod*10) + d, 0).perform();
//				Thread.sleep(4 * 200 );
//				action.dragAndDropBy(move,-d, 0).perform();
							
				//第三种：前快中匀后快，超过后返回，+纵向抖动   居然成功了
				int mod = 0;
				if(x > 0) {mod = x/10;}
				for(int i = 0; i< mod;i++) {
					if(i<2) {
						action.moveByOffset(10, new Random().nextInt(5) -new Random().nextInt(5)).perform();
						Thread.sleep(new Random().nextInt(5) * 200 );
					}else if(mod - i > 2) {
						action.moveByOffset(10, new Random().nextInt(5) -new Random().nextInt(5)).perform();
						Thread.sleep(5 * 100 );
					}else {
						action.moveByOffset(10, new Random().nextInt(5) -new Random().nextInt(5)).perform();
						Thread.sleep(2 * 150 );
					}
					System.out.println(move.getLocation().toString());
				}
				int d = new Random().nextInt(20);
				action.moveByOffset((x - mod*10) + d, new Random().nextInt(5) -new Random().nextInt(5)).perform();
				Thread.sleep(4 * 150 );
				action.dragAndDropBy(move,-d, 0).perform();
				
				
				
				Thread.sleep(10000);
			} 
			w.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(30000);

	@Override
	public Site getSite() {
		site.addHeader("User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
		site.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		site.addHeader("X-Requested-With", "XMLHttpRequest");
		site.addHeader("Accept-Encoding", "gzip, deflate, br");
		return site;
	}

	public static void main(String[] args) {
		GeetestClickProcessor yzm = new GeetestClickProcessor();
		System.out.println(yzm);
		Spider.create(yzm).addUrl(baseUrl).thread(1).run();

	}
}
