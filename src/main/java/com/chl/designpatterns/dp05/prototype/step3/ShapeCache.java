package com.chl.designpatterns.dp05.prototype.step3;

import java.util.Hashtable;

import com.chl.designpatterns.dp05.prototype.step1.Shape;
import com.chl.designpatterns.dp05.prototype.step2.Circle;
import com.chl.designpatterns.dp05.prototype.step2.Rectangle;
import com.chl.designpatterns.dp05.prototype.step2.Square;

public class ShapeCache {

	private static Hashtable<String,Shape> shapeMap = new Hashtable<String,Shape>();
	
	public static Shape getShape(String shapeId){
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape)cachedShape.clone();
	}
	
	public static void loadCache(){
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);
		
		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);
		
		Rectangle rectangle = new Rectangle();
		square.setId("3");
		shapeMap.put(square.getId(), rectangle);
		
	}
	
}
