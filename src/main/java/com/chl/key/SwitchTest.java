package com.chl.key;

/**
 * int\byte\String 都可以作用于 switch
 * @author chenhailong
 *
 */
public class SwitchTest {

	public static void main(String[] args) {

		String s = "";
		switch (s) {
		case "":
			
			break;

		default:
			break;
		}
		
		
		long l = 0;
		switch ((int)l) {
		case 1:
			
			break;

		default:
			break;
		}
		
		byte b = 1;
		switch (b) {
		case 1:
			
			break;

		default:
			break;
		}
	}

}
