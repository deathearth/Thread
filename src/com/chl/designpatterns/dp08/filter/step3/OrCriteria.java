package com.chl.designpatterns.dp08.filter.step3;

import java.util.List;

import com.chl.designpatterns.dp08.filter.step1.Person;
import com.chl.designpatterns.dp08.filter.step2.Criteria;

public class OrCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;
	
	public OrCriteria(Criteria criteria,Criteria otherCriteria){
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}
	
	public List<Person> meetCriteria(List<Person> persons) {
		// TODO Auto-generated method stub
		List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
		List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

		for(Person person : otherCriteriaItems){
			if(!firstCriteriaItems.contains(person)){
				firstCriteriaItems.add(person);
			}
		}
		return firstCriteriaItems;
	}

}
