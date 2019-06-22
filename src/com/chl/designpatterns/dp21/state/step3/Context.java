package com.chl.designpatterns.dp21.state.step3;

import com.chl.designpatterns.dp21.state.step1.State;

public class Context {

	private State state ;
	
	public Context(){
		state = null;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public State getState(){
		return state;
	}
}
