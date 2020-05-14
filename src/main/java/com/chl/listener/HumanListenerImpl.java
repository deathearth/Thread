package com.chl.listener;

import com.chl.listener.event.Event;

/**
 * 事件监听器的实现类
 * @author chenhailong
 *
 */
public class HumanListenerImpl implements HumanListener {

	@Override
	public void doSTH(Event event) {
		System.out.println("before to do !");
	}
	
}
