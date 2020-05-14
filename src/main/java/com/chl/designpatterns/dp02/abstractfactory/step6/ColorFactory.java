package com.chl.designpatterns.dp02.abstractfactory.step6;

import com.chl.designpatterns.dp02.abstractfactory.step1.Shape;
import com.chl.designpatterns.dp02.abstractfactory.step3.Color;
import com.chl.designpatterns.dp02.abstractfactory.step4.Blue;
import com.chl.designpatterns.dp02.abstractfactory.step4.Green;
import com.chl.designpatterns.dp02.abstractfactory.step4.Red;
import com.chl.designpatterns.dp02.abstractfactory.step5.AbstractFactory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		
		if(color == null){
	         return null;
	    }		
	    if(color.equalsIgnoreCase("RED")){
	       return new Red();
	    } else if(color.equalsIgnoreCase("GREEN")){
	       return new Green();
	    } else if(color.equalsIgnoreCase("BLUE")){
	       return new Blue();
	    }
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
