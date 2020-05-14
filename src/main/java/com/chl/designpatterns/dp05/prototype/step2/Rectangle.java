package com.chl.designpatterns.dp05.prototype.step2;

import com.chl.designpatterns.dp05.prototype.step1.Shape;

public class Rectangle extends Shape {
	
	public Rectangle(){
		type = "Rectangle";
	}
	
	public void draw(){
		System.out.println("rectangle::draw()");
	}
}
