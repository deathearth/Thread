package com.chl.designpatterns.dp18.mediator.step2;

import com.chl.designpatterns.dp18.mediator.step1.ChatRoom;

public class User {

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public User(String name){
		this.name = name;
	}
	public void sendMessage(String message){
		ChatRoom.showMessage(this, message);
	}
}
