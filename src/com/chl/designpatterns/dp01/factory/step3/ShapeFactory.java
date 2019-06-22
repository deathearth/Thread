package com.chl.designpatterns.dp01.factory.step3;

import com.chl.designpatterns.dp01.factory.step1.Shape;
import com.chl.designpatterns.dp01.factory.step2.Circle;
import com.chl.designpatterns.dp01.factory.step2.Rectangle;
import com.chl.designpatterns.dp01.factory.step2.Square;

public class ShapeFactory {
	//���ݽӿڻ�ȡ �����͵ı������
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if(shapeType.equals("RECTANGLE")){
			return new Rectangle();
		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		return null;
	}
}
