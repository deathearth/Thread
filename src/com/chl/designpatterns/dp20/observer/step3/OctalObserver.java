package com.chl.designpatterns.dp20.observer.step3;

import com.chl.designpatterns.dp20.observer.step1.Subject;
import com.chl.designpatterns.dp20.observer.step2.Observer;

public class OctalObserver extends Observer {

	public OctalObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}
	
	public void update(){
		System.out.println("Octal String : "+ Integer.toOctalString(subject.getState()));
	}
}
