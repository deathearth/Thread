package com.chl.listener;

public class TotalTest {

	public static void main(String[] args) {

		obj ob = new obj();
		ob.addListener(new listenerImpl());
		ob.dosth();
	}

}


class event{
	
	private event e;
	
	public event() {
		this.e = e;
	}

	public event getE() {
		return e;
	}

	public void setE(event e) {
		this.e = e;
	}
}

interface listener{
	public void dst(event e);
}

class listenerImpl implements listener{

	@Override
	public void dst(event e) {
		System.out.println("before");
	}
	
}

class obj {
	
	private listener ls;
	
	public void addListener(listener ls) {
		this.ls = ls;
	}
	
	public void dosth() {
		
		if(ls != null) {
			event e = new event();
			ls.dst(e);
			System.out.println("action ");
		}
	}
	
}