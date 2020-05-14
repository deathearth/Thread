package com.chl.webserver;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	// 输入流
	private InputStream input;
	// 地址
	private String uri;

	public Request(InputStream input) {
		this.input = input;
	}
	
	public String getUri() {
		return uri;
	}

	//解析http请求中的原始数据。
	void parse() {
		 //Read a set of characters from the socket
		 StringBuffer request = new StringBuffer(2048);
		 int i ;
		 byte[] buffer = new byte[2048];
		 try {
			 i = input.read(buffer);
		 }catch(IOException e) {
			 e.printStackTrace();
			 i = -1;
		 }
		 for(int j = 0; j< i;j++) {
			 request.append((char)buffer[j]);
		 }
		 System.out.println(request.toString());
		 uri = parseUri(request.toString());
	 }

	//从 url中返回uri
	private String parseUri(String requestString) {
		int index1 , index2;
		index1 = requestString.indexOf(" ");
		if(index1 != -1) {
			index2 = requestString.indexOf(" ", index1 + 1);
			if(index2 > index1) {
				return requestString.substring(index1+1, index2);
			}
		}
		return null;
	}
}
