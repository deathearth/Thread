package com.chl.spider;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

//https://api.geetest.com/get.php?is_next=true&type=slide3&gt=019924a82c70bb123aae90d483087f94&challenge=592172715bfdcb3dc755b648ecbe0706&lang=zh-cn&https=true&protocol=https%3A%2F%2F&offline=false&product=embed&api_server=api.geetest.com&isPC=true&width=100%25&callback=geetest_1588921065545
//https://api.geetest.com/get.php?is_next=true&type=slide3&gt=019924a82c70bb123aae90d483087f94&challenge=185dc108d60a27f5c71c4191e462a97a&lang=zh-cn&https=true&protocol=https%3A%2F%2F&offline=false&product=embed&api_server=api.geetest.com&isPC=true&width=100%25&callback=geetest_1588921092747

/**
 * 极验测试地址：https://www.geetest.com/demo/slide-bind.html
 *
 *
 * 极验的破解可以参考：https://www.zhihu.com/question/28833985
 */
public class GeetestProcessor implements PageProcessor {

	Logger logger = LoggerFactory.getLogger(GeetestProcessor.class);
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
		GeetestProcessor yzm = new GeetestProcessor();
		System.out.println(yzm);
		Spider.create(yzm).addUrl(baseUrl).thread(1).run();

		// try {
		// String JS = "return document.getElementsByClassName('geetest_canvas_bg
		// geetest_absolute')[0].toDataURL('image/png');";
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}
