package com.chl.designpatterns.dp10.decorator.step4;

import com.chl.designpatterns.dp10.decorator.step1.Shape;
import com.chl.designpatterns.dp10.decorator.step3.ShapeDecorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape){
		super(decoratedShape);
	}
	
	public void draw(){
		decoratedShape.draw();
		setRedBorde(decoratedShape);
	}
	
	private void setRedBorde(Shape decoratedShape){
		System.out.println("Border Color: Red");
	}
}
