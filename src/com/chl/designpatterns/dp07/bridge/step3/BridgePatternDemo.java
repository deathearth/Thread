package com.chl.designpatterns.dp07.bridge.step3;

import com.chl.designpatterns.dp07.bridge.step2.GreenCircle;
import com.chl.designpatterns.dp07.bridge.step2.RedCircle;
import com.chl.designpatterns.dp07.bridge.step4.Circle;

public class BridgePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape redCircle = new Circle(100,100,10,new RedCircle());
		
		Shape greenCircle = new Circle(100,100,10,new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
	}

}
