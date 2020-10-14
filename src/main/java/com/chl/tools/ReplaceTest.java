package com.chl.tools;

public class ReplaceTest {
	
	public static void main(String[] args) {
		String str = "<img class=\"Wirisformula\" style=\"max-width: none;\" role=\"math\" "
				+ "src=\"http://filegateway.test.mistong.com/api/filecenter/fileService/file/751664073311404050\" "
				+ "data-mathml=\"«math xmlns=¨http://www.w3.org/1998/Math/MathML¨»«math»«mo "
				+ "xmlns=¨http://www.w3.org/1998/Math/MathML¨ »(«/mo»«mover xmlns=¨http://www.w3.org/1998/Math/MathML¨  "
				+ "accent=¨true¨»«mrow»«mi»A«/mi»«mi»B«/mi»«/mrow»«mo»→«/mo»«/mover»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ "
				+ "»+«/mo»«mover xmlns=¨http://www.w3.org/1998/Math/MathML¨  "
				+ "accent=¨true¨»«mrow»«mi»M«/mi»«mi»B«/mi»«/mrow»«mo»→«/mo»«/mover»«mo "
				+ "xmlns=¨http://www.w3.org/1998/Math/MathML¨ »)«/mo»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ "
				+ "»+«/mo»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ »(«/mo»«mover xmlns=¨http://www.w3.org/1998/Math/MathML¨  "
				+ "accent=¨true¨»«mrow»«mi»B«/mi»«mi»O«/mi»«/mrow»«mo»→«/mo»«/mover»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ "
				+ "»+«/mo»«mover xmlns=¨http://www.w3.org/1998/Math/MathML¨  "
				+ "accent=¨true¨»«mrow»«mi»B«/mi»«mi»C«/mi»«/mrow»«mo»→«/mo»«/mover»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ "
				+ "»)«/mo»«mo xmlns=¨http://www.w3.org/1998/Math/MathML¨ »+«/mo»«mover xmlns=¨http://www.w3.org/1998/Math/MathML¨  "
				+ "accent=¨true¨»«mrow»«mi»O«/mi»«mi»M«/mi»«/mrow»«mo»→«/mo»«/mover»«/math»«/math»\">";
		
		System.out.println(str.replaceAll("\\<img.*?\\>", " "));
		
		
	}

}
