package com.chl.listener;

import com.chl.listener.event.Event;

/**
 * 具体对象
 * @author chenhailong
 *
 */
public class Human {

	private HumanListener ls;
	
	public void registerListener(HumanListener ls) {
		this.ls = ls;
	}
	
	public void doSTH() {
		if(ls != null) {
			Event event = new Event(this);
			this.ls.doSTH(event);
		}
		System.out.println("人吃饭!");
	}
}
