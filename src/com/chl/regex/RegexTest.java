package com.chl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	static String text = "as long as there is injustice, whenever a\n"+
			  "targathian baby cries out, wherever a distress\n" + 
			  "signal sounds among the stars ... We'll be there. \n" + 
			  "this fine ship , and this fine crew ...\n"+
			  "never give up ! never surrender !";
	
	public static void main(String[] args) {
		RegexTest rt = new RegexTest();
		
		// method 1
//		rt.validateNumber("21");
//		rt.validateNumber("abc");
		
		// method 2
//		rt.splitByReg();
		
		// method 3
//		rt.outInfo();
		
		// method 4
//		for(String in : text.split("\n")) {
//			System.out.println("input : " + in);
//			for(String regex : new String[] {
//					"\\w*ere\\w*","\\w*ever","T\\w+","never.*?!"
//			}) {
//				rt.testCompile(in,regex);
//			}
//		}
		
		
		// method 5
//		rt.normalTest();
		
		// method 6
		rt.multReg();
	}

	/**
	 * 验证是否有一个数字
	 * @param val
	 */
	void validateNumber(String val) {
		boolean bool = val.matches("\\d+");  //+ 表示后面有一个或者多个数字
		if(bool) {
			System.out.println("这是一个数字！");
		}else {
			System.out.println("这不是一个数字！");
		}
	}
	
	/**
	 * 根据正则分裂字符串
	 */
	void splitByReg() {
		String str = "这是一1个什么样12的设计啊，用正则-42区分字123符串";
		String sz[] = str.split("(-|//+)?\\d+");
		for(int i = 0; i<sz.length ; i++) {
			System.out.println(sz[i]);
		}
	}
	
	/**
	 * 匹配一个字符的多种写法
	 */
	void outInfo() {
		String str[] = new String[] {"Rudolph","[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"};
		for(String pattern: str) {
			System.out.println("Rudolph".matches(pattern));
		}
	}
	
	
	/**
	 * regex类使用
	 */
	void testCompile(String s,String regex) {
		Display d = new Display(regex);
		Pattern pa = Pattern.compile(regex) ;
		Matcher m = pa.matcher(s);
		if(m.find()) {
			d.display("find()===group:"+ m.group() +"===position:" + m.start() + "-" + m.end());
		}
		if(m.lookingAt()) {
			d.display("lookingAt()===group:"+ m.group() +"===position:" + m.start() + "-" + m.end());
		}
		if(m.matches()) {
			d.display("matches()===group:"+ m.group() +"===position:" + m.start() + "-" + m.end());
		}
	}
	
	private static class Display{
		private boolean print = false;
		private String regex;
		Display(String regex){ this.regex = regex;}
		void display(String msg) {
			if(!print) {
				System.out.println(regex);
				print = true;
			}
			System.out.println(msg);
		}
	}
	
	
	
	/**
	 * 判断匹配
	 */
	void normalTest() {
		String s = "Java now has regular expressions";
		System.out.println(s.matches("^java"));          //false
		System.out.println(s.matches("\\Breg.*"));       //false
		System.out.println(s.matches("n.w\\s+h(a|i)s")); //false
		System.out.println(s.matches("s?"));             //false
		System.out.println(s.matches("s*"));             //false
		System.out.println(s.matches("\\w+\\s\\w+\\s\\w+\\s\\w+\\s\\w+")); //true  //带有空格的要特殊处理
		System.out.println(s.matches("s{4}"));          //false
		System.out.println(s.matches("s{1}."));         //false
		System.out.println(s.matches("s{0,3}"));        //false
		System.out.println(s.matches("^[^\\s]*$"));     //false
		
	}
	
	
	void multReg() {
		Pattern p = Pattern.compile("[has]", Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
		Matcher m = p.matcher(""
				+ "java has regex\nJava has regex\n"
				+ "JAVA has pretty good regular expressions\n"
				+ "Regular expressions are in Java");
		while(m.find()) {
			System.out.println(m.group());
		}
	}
	
}
