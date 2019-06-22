package com.chl.designpatterns.dp16.interpreter.step2;

import com.chl.designpatterns.dp16.interpreter.step1.Expression;

public class TerminalExpression implements Expression {

	private String data;
	
	public TerminalExpression(String data){
		this.data = data;
	}
	
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		if(context.contains(data)){
			return true;
		}
		return false;
	}

}
