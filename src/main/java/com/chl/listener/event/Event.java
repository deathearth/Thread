package com.chl.listener.event;

import com.chl.listener.Human;
/**
 * 事件对象
 * @author chenhailong
 *
 */
public class Event {
	
	private Human human;
	
	public Event(Human human) {
		this.human = human;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}
	

}
