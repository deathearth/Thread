package com.chl.designpatterns.dp12.flyweight.step3;
/*����һ�����̣����ɻ��ڸ�����Ϣ��ʵ����Ķ���*/
import java.util.HashMap;

import com.chl.designpatterns.dp12.flyweight.step1.Shape;
import com.chl.designpatterns.dp12.flyweight.step2.Circle;

public class ShapeFactory {

	private static final HashMap<String,Shape> circleMap = new HashMap<String,Shape>();
	
	public static Shape getCircle(String color){
		Circle circle = (Circle)circleMap.get(color);
		if(circle == null){
			circle = new Circle(color);
			circleMap.put(color, circle);
			
			System.out.println("Creatign circle of color:"+color);
		}
		return circle;
	}
}
