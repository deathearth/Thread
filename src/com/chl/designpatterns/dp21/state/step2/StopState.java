package com.chl.designpatterns.dp21.state.step2;

import com.chl.designpatterns.dp21.state.step1.State;
import com.chl.designpatterns.dp21.state.step3.Context;

public class StopState implements State{

	public void doAction(Context context) {
		// TODO Auto-generated method stub
		System.out.println("Player is in stop state��");
		context.setState(this);
	}

	public String toString(){
		return "Stop State";
	}
	
}
