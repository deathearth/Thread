package com.chl.date;

import java.util.Calendar;

public class TestCalendar {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		
		c.set(3, Calendar.YEAR);
		c.set(10, Calendar.MONTH);
		c.set(16, Calendar.DAY_OF_YEAR);
		
		System.out.println(c.getTime());
	}

}
