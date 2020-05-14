package com.chl.designpatterns.dp11.facade.step3;

import com.chl.designpatterns.dp11.facade.step1.Shape;
import com.chl.designpatterns.dp11.facade.step2.Circle;
import com.chl.designpatterns.dp11.facade.step2.Rectangle;
import com.chl.designpatterns.dp11.facade.step2.Square;

public class ShapeMaker {

	private Shape circle;
	private Shape rectangle;
	private Shape square;
	
	
	public ShapeMaker(){
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}
	
	public void drawCircle(){
		circle.draw();
	}
	
	public void drawRectangle(){
		rectangle.draw();
	}
	
	public void drawSquare(){
		square.draw();
	}
}
