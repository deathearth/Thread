package com.chl.common;

/**
 * Sitch 可以处理 int String ，但是不能弄float
 * @author chenhailong
 *
 * 在 Java 语言规范里中，有说明 switch 支持的类型有：char、byte、short、int、Character、Byte、Short、Integer、String、enum。
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-3.html#jvms-3.10
 * 
 * switch 支持 String 其实就是语法糖。编译器会根据字符串的 hashCode 来处理。
 */
public class SwitchTest {

	public static void main(String[] args) {

		
		Long s = new Long("10");
		
		int in = 10;
		switch (in) {
		case 1:
			
			break;

		default:
			break;
		}
		
		
		String key = "123";
		switch (key) {
		case "123":
			
			break;

		default:
			break;
		}
		
		
		short f = 10;
		switch (f) {
		case 1:
			
			break;

		default:
			break;
		}
	}

}
