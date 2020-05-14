package com.chl.designpatterns.dp17.iterator.step2;


import com.chl.designpatterns.dp17.iterator.step1.Container;
import com.chl.designpatterns.dp17.iterator.step1.Iterator;

public class NameRepository implements Container {

	public String names[] = {"Rebert","John","Julie","Lora"};
	
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator{
		int index;

		public boolean hasNext() {
			if(index < names.length){
				return true;
			}
			return false;
		}

		public Object next() {
			if(this.hasNext()){
				return names[index++];
			}
			return null;
		}
		
	}

}
