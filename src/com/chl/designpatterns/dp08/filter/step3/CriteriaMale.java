package com.chl.designpatterns.dp08.filter.step3;

import java.util.ArrayList;
import java.util.List;

import com.chl.designpatterns.dp08.filter.step1.Person;
import com.chl.designpatterns.dp08.filter.step2.Criteria;

public class CriteriaMale implements Criteria {

	public List<Person> meetCriteria(List<Person> persons) {
		// TODO Auto-generated method stub
		
		List<Person> malePersons = new ArrayList<Person>();
		for(Person person : persons){
			if(person.getGender().equalsIgnoreCase("MALE")){
				malePersons.add(person);
			}
		}
		return malePersons;
	}

}
