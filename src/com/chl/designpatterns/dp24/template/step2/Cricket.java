package com.chl.designpatterns.dp24.template.step2;

import com.chl.designpatterns.dp24.template.step1.Game;

public class Cricket extends Game {

	
	public void initialize(){
		System.out.println("Cricket Game Initialize ! Start playing.");
	}
	
	public void startPlay(){
		System.out.println("Cricket Game Starte. Enjoy the Game!");
	}
	
	public void endPlay(){
		System.out.println("Cricket Game Finished!");
	}

	
}
