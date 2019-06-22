package com.chl.designpatterns.dp05.prototype.step2;

import com.chl.designpatterns.dp05.prototype.step1.Shape;

public class Circle extends Shape {

	public Circle(){
		type = "Circle";
	}
	
	public void draw(){
		System.out.println("Circle:draw()");
	}
}
