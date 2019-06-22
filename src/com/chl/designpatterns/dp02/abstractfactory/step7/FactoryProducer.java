package com.chl.designpatterns.dp02.abstractfactory.step7;

import com.chl.designpatterns.dp02.abstractfactory.step5.AbstractFactory;
import com.chl.designpatterns.dp02.abstractfactory.step6.ColorFactory;
import com.chl.designpatterns.dp02.abstractfactory.step6.ShapeFactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		}else if(choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}
		return null;
	}
}
