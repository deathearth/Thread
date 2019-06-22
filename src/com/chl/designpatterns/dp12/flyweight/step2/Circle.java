package com.chl.designpatterns.dp12.flyweight.step2;

import com.chl.designpatterns.dp12.flyweight.step1.Shape;

public class Circle implements Shape {

	private String color;
	private int x;
	private int y;
	private int radius;
	
	public Circle(String color){
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle: Draw() [color=" + color + ", x=" + x + ", y=" + y + ", radius="
				+ radius + "]");
	}

}
