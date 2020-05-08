package com.chl.http;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTTPClient 工具类
 * 
 * @author chenhailong 2018-09-15
 * 
 */
public class HttpClientUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	public static String get(String url) {
		CloseableHttpClient httpCilent = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);
		String responseContent = "";
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpCilent.execute(get);
			HttpEntity entity = httpResponse.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (Exception e) {
			logger.info("GET请求时发生异常 url={} msg={}", url, e.getMessage(), e);
		} finally {
			// 释放资源
			try {
				httpCilent.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	/**
	 * 测试接口转线上接口
	 * 
	 * @param url
	 * @param body
	 * @return
	 */
	public static String post(String url, String body) {
		CloseableHttpClient httpCilent = HttpClients.createDefault();
		String responseContent = "";
		HttpPost post = new HttpPost(url);
		try {
			// 构建消息实体
			StringEntity beforeentity = new StringEntity(body, Charset.forName("UTF-8"));
			beforeentity.setContentEncoding("UTF-8");
			// 发送Json格式的数据请求
			beforeentity.setContentType("application/json");
			post.setEntity(beforeentity);

			// 设置post求情参数
			HttpResponse httpResponse = httpCilent.execute(post);
			HttpEntity entity = httpResponse.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (IOException e) {
			logger.info("POST请求时发生异常{}", e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				httpCilent.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

}
