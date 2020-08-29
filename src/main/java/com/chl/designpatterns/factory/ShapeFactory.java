package com.chl.designpatterns.factory;

/**
 * 工厂模式
 * @author chenhailong
 * 1.不用关心对象的创建
 * 2.我们明确地计划不同条件下创建不同实例。(解耦，数据库的连接可以有多种)
 *
 */
public class ShapeFactory {

	public Shape getShape(String shape) {
		
		if(shape == null) {
			return null;
		}
		
		if(shape.equals("cycle")) {
			return new CycleShape();
		}else {
			return new Rangeshape();
		}
		
	}
}
