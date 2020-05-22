package com.chl.http;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpClientProxy {
	// change 参数: false-换ip ，true-不换ip
	public static String authHeader(String orderno, String secret, int timestamp, String change) {
		// 拼装签名字符串
		String planText = String.format("orderno=%s,secret=%s,timestamp=%d", orderno, secret, timestamp);

		// 计算签名
		String sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(planText).toUpperCase();

		// 拼装请求头Proxy-Authorization的值;change 参数: false-换ip ,true-不换ip
		String authHeader = String.format("sign=%s&orderno=%s&timestamp=%d&change=%s", sign, orderno, timestamp,
				change);
		return authHeader;
	}

	public static void main(String[] args) throws IOException {
		final String url = "http://2017.ip138.com/ic.asp";
		final int port = 8089;//这里以正式服务器端口地址为准
		final String ip = "dynamic.xiongmaodaili.com";//这里以正式服务器ip地址为准
		int timestamp = (int) (new Date().getTime()/1000);
		//以下订单号，secret参数 须自行改动；最后一个参数: true-换ip ,false-不换ip
		final String authHeader = authHeader("DT20180509194022jdckZQX0", "61963bc3416ec051a1273b19ee272275", timestamp,"true");
		System.out.println(authHeader);
		ExecutorService thread = Executors.newFixedThreadPool(10);
		for (int i=0;i<10;i++) {
			thread.execute(new Runnable() {
				@Override
				public void run() {
					Document doc = null ;
					try {
						long a = System.currentTimeMillis();
						doc = Jsoup.connect(url)
								//.proxy(ip, port,null)   //这个需要下载有代理功能的jsoup包
								.validateTLSCertificates(false)//忽略证书认证,每种语言客户端都有类似的API
								.header("Proxy-Authorization", authHeader)
								.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
								.timeout(10000)
								.get();
						Thread.sleep(1000);
					} catch (Exception e) {
						
					}
				}
			});
		}
		thread.shutdown();
	}

	//利用httpclient设置代理
	public void httpClient() {
		// 请求返回
		CloseableHttpResponse httpResp = null;
		try {
			// 设置代理IP、端口、协议（请分别替换）
			HttpHost proxy = new HttpHost("你的代理的IP", 8080, "http");
			// 把代理设置到请求配置
			RequestConfig defaultRequestConfig = RequestConfig.custom().setProxy(proxy).build();
			// 实例化CloseableHttpClient对象
			CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
			// 访问目标地址
			HttpGet httpGet = new HttpGet("http://www.baidu.com");
			
			httpGet.addHeader("Proxy-Authorization", "三方代理身份凭证"); //是一个请求首部,其中包含了用户代理提供给代理服务器的用于身份验证的凭证
			httpResp = httpclient.execute(httpGet);
			int statusCode = httpResp.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				System.out.println("成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpResp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}