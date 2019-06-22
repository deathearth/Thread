package com.chl.designpatterns.dp02.abstractfactory.step6;

import com.chl.designpatterns.dp02.abstractfactory.step1.Shape;
import com.chl.designpatterns.dp02.abstractfactory.step2.Circle;
import com.chl.designpatterns.dp02.abstractfactory.step2.Rectangle;
import com.chl.designpatterns.dp02.abstractfactory.step2.Square;
import com.chl.designpatterns.dp02.abstractfactory.step3.Color;
import com.chl.designpatterns.dp02.abstractfactory.step5.AbstractFactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		
		if(shape == null){
			return null;
		}
		if(shape.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if(shape.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}else if(shape.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	
}
