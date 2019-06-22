package com.chl.designpatterns.dp16.interpreter.step3;

import com.chl.designpatterns.dp16.interpreter.step1.Expression;
import com.chl.designpatterns.dp16.interpreter.step2.AndExpression;
import com.chl.designpatterns.dp16.interpreter.step2.OrExpression;
import com.chl.designpatterns.dp16.interpreter.step2.TerminalExpression;

public class InterpreterPatternDemo {

	/**
	 * ���� robert\johon����
	 * @return
	 */
	public static Expression getMaleExpression(){
		Expression rebert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("john");
		return new OrExpression(rebert, john);
		
	}
	
	public static Expression getMarriedWomanExpression(){
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie,married);
	}
	
	public static void main(String[] args){
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		System.out.println("John is male? "+isMale.interpret("John"));
		System.out.println("Julie is a married women?"+isMarriedWoman.interpret("Married Julie"));
		
	}
	
}
