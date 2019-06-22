package com.chl.designpatterns.dp20.observer.step2;

import com.chl.designpatterns.dp20.observer.step1.Subject;

public abstract class Observer {

	protected Subject subject;
	public abstract void update();
}
