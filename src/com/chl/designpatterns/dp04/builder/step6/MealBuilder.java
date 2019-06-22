package com.chl.designpatterns.dp04.builder.step6;

import com.chl.designpatterns.dp04.builder.step4.ChickenBurger;
import com.chl.designpatterns.dp04.builder.step4.Coke;
import com.chl.designpatterns.dp04.builder.step4.Pepsi;
import com.chl.designpatterns.dp04.builder.step4.VegBurger;
import com.chl.designpatterns.dp04.builder.step5.Meal;

public class MealBuilder {
	public Meal prepareVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	
	public Meal prepareNonVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}

}
