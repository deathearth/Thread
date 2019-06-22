package com.chl.designpatterns.dp08.filter.step2;

import java.util.List;

import com.chl.designpatterns.dp08.filter.step1.Person;

public interface Criteria {

	public List<Person> meetCriteria(List<Person> persons);
}
