package com.chl.designpatterns.dp08.filter.step3;

import java.util.List;

import com.chl.designpatterns.dp08.filter.step1.Person;
import com.chl.designpatterns.dp08.filter.step2.Criteria;

public class AndCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;
	
	public AndCriteria(Criteria criteria,Criteria otherCriteria){
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}
	
	public List<Person> meetCriteria(List<Person> persons) {
		// TODO Auto-generated method stub
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}

}
