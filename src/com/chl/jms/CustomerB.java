package com.chl.jms;

public class CustomerB {

	public static void main(String[] args) throws Exception {

		QueueClient client = new QueueClient();
		client.cs();
		StringBuilder builder = new StringBuilder("consumer");
		String msg = client.sub(builder.toString());
		System.out.println("获取的消息为："+ msg);
	}

}
