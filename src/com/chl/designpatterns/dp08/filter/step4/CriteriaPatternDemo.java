package com.chl.designpatterns.dp08.filter.step4;

import java.util.ArrayList;
import java.util.List;

import com.chl.designpatterns.dp08.filter.step1.Person;
import com.chl.designpatterns.dp08.filter.step2.Criteria;
import com.chl.designpatterns.dp08.filter.step3.AndCriteria;
import com.chl.designpatterns.dp08.filter.step3.CriteriaFemale;
import com.chl.designpatterns.dp08.filter.step3.CriteriaMale;
import com.chl.designpatterns.dp08.filter.step3.CriteriaSingle;
import com.chl.designpatterns.dp08.filter.step3.OrCriteria;

public class CriteriaPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Robert","Male","Single"));
		persons.add(new Person("John","Male","Married"));
		persons.add(new Person("Laura","Female","Married"));
		persons.add(new Person("Diana","Female","Single"));
		persons.add(new Person("Mike","Male","Single"));
		persons.add(new Person("Bobby","Male","Single"));
		
		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		Criteria singleMale = new AndCriteria(single,male);
		Criteria singleOrFemale = new OrCriteria(single,female);
		
		
		System.out.println("Males:");
		printPersons(male.meetCriteria(persons));
		System.out.println("\nFemales:");
		printPersons(female.meetCriteria(persons));
		System.out.println("\nSingle Males:");
		printPersons(singleMale.meetCriteria(persons));
		System.out.println("\nSingle or Females:");
		printPersons(singleOrFemale.meetCriteria(persons));
		
	}
	
	public static void printPersons(List<Person> persons){
		for(Person person: persons){
			System.out.println(
					"Person : [ Name :"+person.getName()+","
							+ " Gender:"+person.getGender()+", "
							+ " Mariter Status:"+person.getMaritalStatus()+"]");
		}
	}

}
