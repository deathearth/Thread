package com.chl.spider;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *58滑动验证码
 *https://www.jianshu.com/p/6a67c9e2c13e
 *相关文章：https://www.cnblogs.com/w-y-c-m/p/7359455.html
 *
 *
 *极验的破解可以参考：https://www.zhihu.com/question/28833985
 */
public class YZMProcessor implements PageProcessor{
	
	Logger logger = LoggerFactory.getLogger(YZMProcessor.class);
	// 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
//	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	public static String baseUrl = "https://callback.58.com/antibot/verifycode?serialId=07b8e8a846f1539ac376ac9a87c25990_cc3495e18c764ade9c34b29b1b98a7d4&code=22&sign=618807392986fd36644cf0619748b0a2&namespace=fangchan_business_pc&url=https%3A%2F%2Fcd.58.com%2Fshangpu%2F41903439232525x.shtml%3Fadtype%3D373";
	
	static
	{
		System.getProperties().setProperty("webdriver.chrome.driver", "/Users/chenhailong/Downloads/tools/nessarytool/chromedriver");
	}
	
	@Override
	public void process(Page page) {
		
		System.out.println(CollectionUtils.class.getProtectionDomain().getCodeSource().getLocation());
		
		WebDriver w = new ChromeDriver();
		
		w.get(baseUrl);
		try {
			Thread.sleep(1000);
			if(BaseUtil.doesWebElementExist(w, By.id("btnSubmit"))) {
				w.findElement(By.id("btnSubmit")).click();
				Thread.sleep(500);
				
				if(BaseUtil.doesWebElementExist(w, By.className("dvc-slider__handler"))) {
					WebElement we = w.findElement(By.className("dvc-slider__handler"));
					
					
					String img = w.findElement(By.className("dvc-captcha__bgImg")).getAttribute("src");
					FileUtil.downloadPicture(img, "/Users/chenhailong/Desktop/captcha.jpeg", null);
					
					
					Actions action = new Actions(w);
					action.moveToElement(we).perform();
					action.clickAndHold(we).perform();
					
					action.moveByOffset(300, 0);
					try {
						action.build().perform();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		w.quit();
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
		YZMProcessor yzm = new YZMProcessor();
		System.out.println(yzm);
		Spider
		.create(yzm)
		.addUrl(baseUrl)
		.thread(1)
		.run();
	}
}

