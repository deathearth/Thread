package com.chl.designpatterns.dp10.decorator.step5;

import com.chl.designpatterns.dp10.decorator.step1.Shape;
import com.chl.designpatterns.dp10.decorator.step2.Circle;
import com.chl.designpatterns.dp10.decorator.step2.Rectangle;
import com.chl.designpatterns.dp10.decorator.step4.RedShapeDecorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape circle = new Circle();
		
		Shape redCircle = new RedShapeDecorator(new  Circle());
		
		Shape redRectangle = new RedShapeDecorator(new  Rectangle());
		
		System.out.println("Circle with normal border!");
		circle.draw();
		System.out.println("Circle of red border!");
		redCircle.draw();
		System.out.println("Rectangle of red border!");
		redRectangle.draw();
	}

}
