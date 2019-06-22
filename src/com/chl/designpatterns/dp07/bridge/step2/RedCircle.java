package com.chl.designpatterns.dp07.bridge.step2;

import com.chl.designpatterns.dp07.bridge.step1.DrawAPI;

public class RedCircle implements DrawAPI {

	public void drawCircle(int radius, int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle {color:red,radius:"+radius+""
				+ ",x:"+x+","+y+"}");
	}

}
