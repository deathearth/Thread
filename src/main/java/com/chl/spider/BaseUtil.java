package com.chl.spider;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import us.codecraft.webmagic.Site;

public class BaseUtil {

//	private static final Logger logger = LoggerFactory.getLogger(BaseUtil.class);

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9|\\.]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void copyCookies(Site source, Site des) {
		Map<String, String> sourceCookies = source.getCookies();
		if ((sourceCookies == null) || (sourceCookies.isEmpty())) {
			return;
		}
		for (Map.Entry<String, String> entry : sourceCookies.entrySet()) {
			des.addCookie((String) entry.getKey(), (String) entry.getValue());
		}
	}

	public static Map<String, String> getCookiesFromHeaders(Header[] headers) {
		Map<String, String> result = new HashMap<String, String>();
		if (headers.length < 1) {
			return result;
		}
		for (Header header : headers) {
			String headStr = header.getValue();
			if (!StringUtils.isEmpty(headStr)) {
				String[] headerArr = headStr.split(";");
				for (String str : headerArr) {
					String[] strArr = str.split("=");
					if ((strArr.length > 1) && (!StringUtils.isEmpty(strArr[1])) && (!"/".equals(strArr[1]))) {
						result.put(strArr[0], strArr[1]);
					}
				}
			}
		}
		return result;
	}

	public static boolean doesWebElementExist(WebDriver driver, By selector) {
		try {
			WebElement ele = driver.findElement(selector);
			if (!ele.isDisplayed()) {
				return false;
			}
			return true;
		} catch (NoSuchWindowException e) {
			throw e;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean doesWebElementExist(WebElement webElement, By selector) {
		try {
			WebElement ele = webElement.findElement(selector);
			if (!ele.isDisplayed()) {
				return false;
			}
			return true;
		} catch (NoSuchWindowException e) {
			throw e;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getCookiesStr(Set<Cookie> cookies) {
		if (CollectionUtils.isEmpty(cookies)) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		for (Cookie ck : cookies) {
			result.append(ck.getName()).append("=").append(ck.getValue()).append(";");
		}
		return result.toString();
	}

	@SuppressWarnings("deprecation")
	public static WebDriver getChromeDriver() {

		// 设置必要参数
		DesiredCapabilities dcaps = new DesiredCapabilities();
		// ssl证书支持
		dcaps.setCapability("acceptSslCerts", true);
		// 截屏支持
		dcaps.setCapability("takesScreenshot", true);
		// css搜索支持
		dcaps.setCapability("cssSelectorsEnabled", true);
		// js支持
		dcaps.setJavascriptEnabled(true);

		return new ChromeDriver(dcaps);
	}

	public static WebDriver getChromeDriver_new() {
		ChromeOptions options = new ChromeOptions();
		options.setCapability("acceptSslCerts", true);
		options.setCapability("takesScreenshot", true);
		options.setCapability("cssSelectorsEnabled", true);
		options.addArguments("start-maximized");

		return new ChromeDriver(options);
	}

//	public static WebDriver getHtmlUnitDriver() {
//		// 设置必要参数
//		DesiredCapabilities dcaps = new DesiredCapabilities();
//		// ssl证书支持
//		dcaps.setCapability("acceptSslCerts", true);
//		// 截屏支持
//		dcaps.setCapability("takesScreenshot", true);
//		// css搜索支持
//		dcaps.setCapability("cssSelectorsEnabled", true);
//		// js支持
//		dcaps.setJavascriptEnabled(true);
//		// 创建无界面浏览器对象
//		return new HtmlUnitDriver(dcaps);
//	}

	public static WebDriver getFirefoxDriver() {
		return new FirefoxDriver();
	}

	public static String getUUID32() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void threadSleep(Long sleepMills) {
		try {
			Thread.sleep(sleepMills);
		} catch (Exception e) {
		}
	}

	public static boolean compareDate(String date, Date startDate, Date endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date dt1 = sdf.parse(date);
			if (dt1.getTime() >= startDate.getTime() && dt1.getTime() <= endDate.getTime()) {
				return true;
			}
		} catch (ParseException e) {
		}

		return false;
	}

	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}

}