package com.chl.designpatterns.dp01.factory.step4;

import com.chl.designpatterns.dp01.factory.step1.Shape;
import com.chl.designpatterns.dp01.factory.step3.ShapeFactory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShapeFactory shapeFactory =  new ShapeFactory();
		//���ݲ��� ����ȡ��Ӧ�࣬�����÷���
		Shape shape = shapeFactory.getShape("CIRCLE");
		shape.draw();
		
		shape = shapeFactory.getShape("RECTANGLE");
		shape.draw();
		
		shape = shapeFactory.getShape("SQUARE");
		shape.draw();
		
	}

}
