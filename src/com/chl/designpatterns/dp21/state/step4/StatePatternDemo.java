package com.chl.designpatterns.dp21.state.step4;

import com.chl.designpatterns.dp21.state.step2.StartState;
import com.chl.designpatterns.dp21.state.step2.StopState;
import com.chl.designpatterns.dp21.state.step3.Context;

public class StatePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Context context = new Context();
		
		StartState startState = new StartState();
		startState.doAction(context);
		
		System.out.println(context.getState().toString());
		
		StopState stopState = new StopState();
		stopState.doAction(context);
		
		System.out.println(context.getState().toString());
		
	}

}
