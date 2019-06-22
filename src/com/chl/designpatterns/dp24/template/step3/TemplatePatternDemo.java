package com.chl.designpatterns.dp24.template.step3;

import com.chl.designpatterns.dp24.template.step1.Game;
import com.chl.designpatterns.dp24.template.step2.Cricket;
import com.chl.designpatterns.dp24.template.step2.Football;

public class TemplatePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game = new Cricket();
		game.play();
		
		System.out.println();
		
		game = new Football();
		
		game.play();
	}

}
