package com.qzz.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

/**
 * 解析文本 
 * 一般从txt中复制进来
 * ### 对题做分割
 * $$$ 对答案做分割
 * 
 * 示例
 * ###1%%%题干
 * $$$答案&&&答案 (如果答案统一,则外部传入)
 * 
 */
public class TextAnalyse{
	public static String splitQ = "###";
	public static String splitA = "$$$";
	public static String splitE = "&&&";
	public static String splitN = "%%%";
	public static String splitBR = "\r\n";
	public static String answer = "@answer";
	public static String score = "@score";
	
	private static String qData = "i:0;O:27:\\\"WpProQuiz_Model_AnswerTypes\\\":7:\r\n{s:10:\\\"\\0*\\0_answer\\\";s:12:\\\"@answer\\\";s:8:\\\"\\0*\\0_html\\\";b:0;s:10:\\\"\\0*\\0_points\\\";i:@score;s:11:\\\"\\0*\\0_correct\\\";b:0;s:14:\\\"\\0*\\0_sortString\\\";s:0:\\\"\\\";s:18:\\\"\\0*\\0_sortStringHtml\\\";b:0;s:10:\\\"\\0*\\0_mapper\\\";N;}";

	public static List<QuestionVO> analyseText(String text){
		List<QuestionVO> list = new ArrayList<QuestionVO>();
		
		String[] eachQuestion = text.split(splitQ);
		for(String question: eachQuestion) {
			QuestionVO qv = new QuestionVO();
			String[] eachLine = question.split(splitBR);
			StringBuffer sb = new StringBuffer();
			sb.append("a:3:{");
			if(eachLine[1]!=null || eachLine[1].length() > 0) {
				for(String line: eachLine) {
					String id = line.split(splitN)[0];
					if(line.indexOf(splitA) >= 0) {
						String[] eachAnswer = line.split(splitE);
						for(String Answer : eachAnswer) {
							
							int type = 0;
							for(int i = 0 ; i < QuizTest.type ; i++) {
								Integer[] questionIds = QuizTest.scoreIds[i];
								if(Arrays.asList(questionIds).contains(Integer.parseInt(id))) {
									type = i;
								}
							}
							
							sb.append(qData.replace(answer, Answer).replace(score, QuizTest.hm.get(type).toString()));
						}
						
					}else {
						
						qv.setQuestion(line);
					}
					
				}
			}else {
				qv.setQuestion(eachLine[0]);
				
				for(Entry<String,Integer> e:QuizTest.ac.entrySet()) {
					sb.append(qData.replace(answer, e.getKey()).replace(score, String.valueOf(e.getValue())));
				}
				
			}
			sb.append("}");
		}
		return list;
	}
}
