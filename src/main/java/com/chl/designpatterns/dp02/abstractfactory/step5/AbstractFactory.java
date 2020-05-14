package com.chl.designpatterns.dp02.abstractfactory.step5;

import com.chl.designpatterns.dp02.abstractfactory.step1.Shape;
import com.chl.designpatterns.dp02.abstractfactory.step3.Color;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);
}
