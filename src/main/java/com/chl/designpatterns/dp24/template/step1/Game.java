package com.chl.designpatterns.dp24.template.step1;

public abstract class Game {

	public abstract void initialize();
	
	public abstract void startPlay();
	
	public abstract void endPlay();
	
	public final void play(){
		
		initialize();
		startPlay();
		endPlay();
	}
}
