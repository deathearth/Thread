package com.chl.designpatterns.dp20.observer.step4;

import com.chl.designpatterns.dp20.observer.step1.Subject;
import com.chl.designpatterns.dp20.observer.step3.BinaryObserver;
import com.chl.designpatterns.dp20.observer.step3.HexaObserver;
import com.chl.designpatterns.dp20.observer.step3.OctalObserver;

public class ObserverPatternDemo {

	public static void main(String[] args){
		
		Subject subject = new Subject();
		
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);
		
		System.out.println("First state change :15");
		subject.setState(15);
		System.out.println("First state change :10");
		subject.setState(10);
		
	}
}
