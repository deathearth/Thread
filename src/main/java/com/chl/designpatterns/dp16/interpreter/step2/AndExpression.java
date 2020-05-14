package com.chl.designpatterns.dp16.interpreter.step2;

import com.chl.designpatterns.dp16.interpreter.step1.Expression;

public class AndExpression implements Expression {

	private Expression expr1 = null;
	
	private Expression expr2 = null;
	
	public AndExpression(Expression expr1,Expression expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		return expr1.interpret(context)|| expr2.interpret(context); 
	}

}
