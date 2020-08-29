package com.chl.enums;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println(test.Fri.getS(1));
		System.out.println(test.valueOf("Thr"));
		
		System.out.println(test.Fri);
		System.out.println(Enumkeyvalue.Juary.getKey());
	}
	
	
	enum test{
		Mon(1),
		Tus(2),
		Thr(3),
		Thu(4),
		Fri(5),
		Sta(6),
		Sun(7);
		
		private int i;
		test(int i) {
			this.i = i;
		}
		
		public int getS(int i){
			return i;
		}
	}

}
