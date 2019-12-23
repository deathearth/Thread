package com.chl.jms;

/**
 * 消费端的订阅实现
 * @author chenhailong
 *
 */
public class CustomerB {

	public static void main(String[] args) throws Exception {
		QueueClient qc = new QueueClient();
		qc.cs();
		StringBuilder builder = new StringBuilder("consumer");
		String msg = qc.sub(builder.toString());
		System.out.println("获取的消息为："+ msg);
		
	}

}
