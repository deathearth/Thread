package com.chl.designpatterns.dp20.observer.step3;

import com.chl.designpatterns.dp20.observer.step1.Subject;
import com.chl.designpatterns.dp20.observer.step2.Observer;

public class BinaryObserver extends Observer{

	public BinaryObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}
	
	public void update(){
		System.out.println("Binary String :"+Integer.toBinaryString(subject.getState()));
	}
}
