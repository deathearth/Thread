package com.chl.designpatterns.dp05.prototype.step4;

import com.chl.designpatterns.dp05.prototype.step1.Shape;
import com.chl.designpatterns.dp05.prototype.step3.ShapeCache;

public class PrototypePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShapeCache.loadCache();
		
		Shape cloneShape1 = (Shape)ShapeCache.getShape("1");
		System.out.println("shape:"+cloneShape1.getType());
		
		Shape cloneShape2 = (Shape)ShapeCache.getShape("2");
		System.out.println("shape:"+cloneShape2.getType());
		
		Shape cloneShape3 = (Shape)ShapeCache.getShape("3");
		System.out.println("shape:"+cloneShape3.getType());
		
	}

}
