package com.chl.designpatterns.dp19.memento.step2;

import com.chl.designpatterns.dp19.memento.step1.Memento;

public class Originator {

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Memento saveStateToMemento(){
		return new Memento(state);
	}
	
	public void getStateFromMemento(Memento Memento){
		state = Memento.getState();
	}
	
}
