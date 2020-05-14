package com.chl.jms;

/**
 * 消费端的生产实现
 * @author chenhailong
 *
 */
public class CustomerA {

	public static void main(String[] args) throws Exception {
		QueueClient qc = new QueueClient();
		qc.cs();
		StringBuilder builder = new StringBuilder("begin-product");
		qc.pub(builder.toString());
		System.out.println("pub消息");
	}

}
