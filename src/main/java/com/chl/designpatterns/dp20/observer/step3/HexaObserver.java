package com.chl.designpatterns.dp20.observer.step3;

import com.chl.designpatterns.dp20.observer.step1.Subject;
import com.chl.designpatterns.dp20.observer.step2.Observer;

public class HexaObserver extends Observer {

	public HexaObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}
	
	public void update(){
		System.out.println("Hex String "+Integer.toHexString(subject.getState()));
	}

}
