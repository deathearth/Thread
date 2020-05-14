package com.chl.designpatterns.dp17.iterator.step3;

import com.chl.designpatterns.dp17.iterator.step1.Iterator;
import com.chl.designpatterns.dp17.iterator.step2.NameRepository;

public class IteratorPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NameRepository nameRepository = new NameRepository();
		
		for(Iterator iter = nameRepository.getIterator();iter.hasNext();){
			String name = (String)iter.next();
			System.out.println("Name:"+name);
		}
	}

}
