package com.chl.designpatterns.dp10.decorator.step3;

import com.chl.designpatterns.dp10.decorator.step1.Shape;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;
	
	public ShapeDecorator(Shape decoratedShape){
		this.decoratedShape = decoratedShape;
	}
	
	public void draw() {
		// TODO Auto-generated method stub
		decoratedShape.draw();
	}

}
