package com.chl.listener;

/**
 * 测试监听
 * @author chenhailong
 *
 */
public class TestListener {

	public static void main(String[] args) {

		Human hm = new Human();
		hm.registerListener(new HumanListenerImpl());
		hm.doSTH();
	}

}
