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
		multReg();
		
//		String str = "<br>根据题目中给定的四个命题，判断命题是否正确时，如果找出一个反例不符合题意，那么此命题错误，而特值法是非常简单的，还要注意的是考虑正负号的问题.<br>"
//				+ "（1）错误，当<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test."
//				+ "mistong.com/api/filecenter/fileService/file/803491606881763337\" fileId =  \"803489691325366280\" "
//				+ "data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«/math»\"/>时不成立；<br>正确，因为<img "
//				+ "class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/"
//				+ "api/filecenter/fileService/file/803491615471697925\" fileId =  \"803489691325366291\" data-mathml=\"«math "
//				+ "xmlns=¨http://www.w3.org/1998/Math/MathML¨»«/math»\"/>在<img class=\"Wirisformula\" style=\"max-width: none;\" "
//				+ "role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/803491546752221187\" "
//				+ "data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math»«mfrac "
//				+ "xmlns=¨http://www.w3.org/1998/Math/MathML¨ »«mrow»«mi»a«/mi»«/mrow»«mrow»«msup»«mrow»«mi»c«/mi»«/mrow»«mrow»«mn»"
//				+ "2«/mn»«/mrow»«/msup»«/mrow»«/mfrac»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ »&gt;«/mo»«mfrac "
//				+ "xmlns=¨http://www.w3.org/1998/Math/MathML¨ »«mrow»«mi»b«/mi»«/mrow»«mrow»«msup»«mrow»«mi»c«/mi»«/mrow»"
//				+ "«mrow»«mn»2«/mn»«/mrow»«/msup»«/mrow»«/mfrac»«/math»«/math»\"/>两边同时乘以<img class=\"Wirisformula\" "
//				+ "style=\"max-width: none;\" role=\"math\" "
//				+ "src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/803491615471697949\" "
//				+ "fileId =  \"803489691325366301\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«/math»\"/>，"
//				+ "不等号方向不变，得<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" "
//				+ "src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/803491546752221189\" "
//				+ "data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math»«mi xmlns=¨http://www.w3.org/1998/Math/MathML"
//				+ "¨ »a«/mi»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ »&gt;«/mo»«mi xmlns=¨http://www.w3.org/1998/Math/MathML¨ "
//				+ "»b«/mi»«/math»«/math»\"/>；<br>错误，当<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/803491615471697960\" fileId =  \"803489691325366309\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«/math»\"/>时不成立；<br>错误，当<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/803491615471697976\" fileId =  \"803489691325366317\" data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»〖fix〗803489691325366317〖fix〗«/math»\"/>是不成立.<br>本题主要利用不等式的性质判断命题的真假，题目较简单，注意特值法的应用.";
//				str = str.replaceAll("\\<img.*?\\>", "");
//		System.out.println(str);
		
//		RegexTest rt = new RegexTest();
		
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
//		rt.multReg();
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
	
	
	static void multReg() {
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
