package com.chl.designpatterns.dp18.mediator.step1;

import java.util.Date;

import com.chl.designpatterns.dp18.mediator.step2.User;

public class ChatRoom {

	public static void showMessage(User user,String message){
		System.out.println(new Date().toString() + "["+user.getName()+"]:"+message);
	}
}
