package com.chl.designpatterns.dp07.bridge.step4;

import com.chl.designpatterns.dp07.bridge.step1.DrawAPI;
import com.chl.designpatterns.dp07.bridge.step3.Shape;

public class Circle extends Shape {
	
	/**
	 *  ��Ϊ��ĸ����Ѿ�������һ���вεĹ��캯�����Ҹ�����û��Ĭ�ϵ��޲ι��췽������ʱ����������Ϊ�����Ĭ�ϵĹ��캯����
		������̳�ʱ���������Լ��Ĺ��캯����ʽ���ø���Ĺ��캯�����Լ�����ȷ�������ڳ�ʼ��ǰ����ᱻʵ������
		����㸸�������޲εĹ��캯��������Ͳ���ǿ��Ҫ����ã�����д���Ǹ��Ϳ���ͨ����
		��������Ĭ�ϰ�����ø���Ĺ��캯���� 
	 */
	private int x,y,radius;
	
	public Circle(int x,int y,int radius, DrawAPI drawAPI){
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		drawAPI.drawCircle(radius, x, y);
	}
	
}
