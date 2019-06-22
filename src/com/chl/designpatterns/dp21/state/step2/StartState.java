package com.chl.designpatterns.dp21.state.step2;


import com.chl.designpatterns.dp21.state.step1.State;
import com.chl.designpatterns.dp21.state.step3.Context;

public class StartState implements State {

	public void doAction(Context context) {
		// TODO Auto-generated method stub

		System.out.println("Player is in start state!!!");
		context.setState(this);
	}
	
	public String toString(){
		return "Start State";
	}

}
