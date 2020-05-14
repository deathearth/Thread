package com.chl.spider;

import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 * 极验测试地址：https://www.geetest.com/demo/slide-bind.html
 * 
 */
public class GeetestSlideProcessor implements PageProcessor {

	Logger logger = LoggerFactory.getLogger(GeetestSlideProcessor.class);
	public static String baseUrl = "https://www.geetest.com/demo/slide-bind.html";

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

				long t = Calendar.getInstance().getTimeInMillis();
				System.out.println(t);

				JavascriptExecutor jsExecutor = (JavascriptExecutor) w;
				String JS = "return document.getElementsByClassName('geetest_canvas_bg geetest_absolute')[0].toDataURL('image/png');";
				Object obj = jsExecutor.executeScript(JS);
				FileUtil.generateImage(obj.toString().split(",")[1], "/Users/chenhailong/Desktop/geetest_bg.webp");

				JS = "return document.getElementsByClassName('geetest_canvas_fullbg geetest_fade geetest_absolute')[0].toDataURL('image/png');";
				obj = jsExecutor.executeScript(JS);
				FileUtil.generateImage(obj.toString().split(",")[1], "/Users/chenhailong/Desktop/geetest_fullbg.webp");
				
				JS = "return document.getElementsByClassName('geetest_canvas_slice geetest_absolute')[0].toDataURL('image/png');";
				obj = jsExecutor.executeScript(JS);
				FileUtil.generateImage(obj.toString().split(",")[1], "/Users/chenhailong/Desktop/geetest_block.webp");
				
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
		GeetestSlideProcessor yzm = new GeetestSlideProcessor();
		System.out.println(yzm);
		Spider.create(yzm).addUrl(baseUrl).thread(1).run();

	}
}
