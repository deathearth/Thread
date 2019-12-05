package com.chl.jms;

public class CustomerA {

	public static void main(String[] args) throws Exception {

		QueueClient client = new QueueClient();
		client.cs();
		StringBuilder builder = new StringBuilder("begin-product");
		builder.append("---");
		client.pub(builder.toString());
	}

}
