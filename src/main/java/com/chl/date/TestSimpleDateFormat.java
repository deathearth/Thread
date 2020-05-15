package com.chl.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间
 * @author chenhailong
 * 注意：是线程不安全的类
 */
public class TestSimpleDateFormat {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		System.out.println(time);
		
		
		//线程安全的时间类
		String s = simpleDateFormatThreadLocal.get().format(new Date());
		System.out.println(s);
	}
	
	
	/**
	 * 线程安全
	 */
	private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
	    protected SimpleDateFormat initialValue() {
	    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    }; 
	};

}
