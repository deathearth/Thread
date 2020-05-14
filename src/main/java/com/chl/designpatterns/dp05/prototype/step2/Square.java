package com.chl.designpatterns.dp05.prototype.step2;

import com.chl.designpatterns.dp05.prototype.step1.Shape;

public class Square extends Shape{

	public Square(){
		type = "Square";
	}
	
	public void draw(){
		System.out.println("square::draw()");
	}
	
}
