package com.chl.designpatterns.dp11.facade.step3;

public class FacadePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeMaker shapeMaker = new ShapeMaker();
		
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}

}
