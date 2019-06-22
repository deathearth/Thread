package com.chl.designpatterns.dp18.mediator.step3;

import com.chl.designpatterns.dp18.mediator.step2.User;

public class MediatorPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User rebert = new User("Robert");
		User john = new User("John");
		
		rebert.sendMessage("hi,john !!!");
		john.sendMessage("hello!!!  rebert!!!");
	}

}
