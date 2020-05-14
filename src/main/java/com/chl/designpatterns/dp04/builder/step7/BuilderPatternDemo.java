package com.chl.designpatterns.dp04.builder.step7;

import com.chl.designpatterns.dp04.builder.step5.Meal;
import com.chl.designpatterns.dp04.builder.step6.MealBuilder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MealBuilder mealBuilder = new MealBuilder();
		
		
		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("��ʳ��");
		vegMeal.showItems();
		System.out.println("Total Cost:"+vegMeal.getCost());
		
		Meal noVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("����ʳ��");
		noVegMeal.showItems();
		System.out.println("Total Cost:"+noVegMeal.getCost());
	}

}
