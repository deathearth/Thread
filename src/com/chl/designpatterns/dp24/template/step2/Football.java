package com.chl.designpatterns.dp24.template.step2;

import com.chl.designpatterns.dp24.template.step1.Game;

public class Football extends Game {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Gootball Game Initiallized! Start playing.");
	}

	@Override
	public void startPlay() {
		// TODO Auto-generated method stub
		System.out.println("Football Game Started. Enjoy the game!");
	}

	@Override
	public void endPlay() {
		// TODO Auto-generated method stub
		System.out.println("Football Game Finished!");
	}

}
