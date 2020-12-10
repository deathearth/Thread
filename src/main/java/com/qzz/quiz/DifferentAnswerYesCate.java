package com.qzz.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析文本 一般从txt中复制进来 ### 对题做分割 $$$ 对答案做分割 //这个由换行处理
 * 
 * 示例 ###1%%%题干 答案&&&答案 (如果答案统一,则外部传入)
 * 
 * 
 * 
 * 答案不同，试题有分类
 */
public class DifferentAnswerYesCate {
	public static String splitQ = "###";
	public static String splitA = "$$$"; // 这个由换行处理
	public static String splitE = "&&&";
	public static String splitN = "%%%";
	public static String splitBR = "\r\n";
	public static String answer = "@answer";
	public static String score = "@score";
	public static String turn = "@turn";
	public static String charLength = "@charLength";

	private static String qData = "i:@turn;O:27:\\\"WpProQuiz_Model_AnswerTypes\\\":7:{s:10:\\\"\\0*\\0_answer\\\";s:@charLength:\\\"@answer\\\";s:8:\\\"\\0*\\0_html\\\";b:0;s:10:\\\"\\0*\\0_points\\\";i:@score;s:11:\\\"\\0*\\0_correct\\\";b:0;s:14:\\\"\\0*\\0_sortString\\\";s:0:\\\"\\\";s:18:\\\"\\0*\\0_sortStringHtml\\\";b:0;s:10:\\\"\\0*\\0_mapper\\\";N;}";

	public static List<QuestionVO> analyseText(String text) {
		List<QuestionVO> list = new ArrayList<QuestionVO>();

		String[] eachQuestion = text.split(splitQ);
		for (String question : eachQuestion) {
			QuestionVO qv = new QuestionVO();
			if (question.length() <= 0) {
				continue;
			}
			System.out.println("当前题：" + question);
			String[] eachLine = question.split(splitBR);
			StringBuffer sb = new StringBuffer();

			// 公共部分
			qv.setQuiz_id(QuizTest.quizId);// 所属试卷
			qv.setOnline(1); // 线上？
			int sort = Integer.parseInt(question.split(splitN)[0]);
			qv.setSort(sort); // 排序值
			qv.setQuestion(question.split(splitN)[1]);
			qv.setCorrect_msg(""); // 正确答案
			qv.setIncorrect_msg("");// 错误答案
			qv.setCorrect_same_text(0); // ?
			qv.setAnswer_type("'single'"); // 单选题+
			qv.setCategory_id(0); // 题属于哪个分类
			qv.setDisable_correct(0); // 去掉正确错误答案
			qv.setMatrix_sort_answer_criteria_width(20); // ?
			qv.setAnswer_points_diff_modus_activated(1); // 不同答案不同分
			qv.setAnswer_points_activated(1);

			// 开启提示,一般不设置
			qv.setTip_enabled(0);
			qv.setTip_msg("");
			qv.setPoints(0);// 总分， 按题计分还是答案处理

			if (eachLine.length > 1) {
				qv.setQuestion(eachLine[0].replace(splitN, ". "));
				String[] answers = eachLine[1].split(splitE);
				sb.append("a:" + answers.length + ":{"); // 这里要指明有几个答案
				int tt = 0;
				for (String answer : answers) {
					int type = 0;
					for (int i = 0; i < QuizTest.type; i++) {
						Integer[] questionIds = QuizTest.scoreIds[i];
						if (Arrays.asList(questionIds).contains(sort)) {
							type = i;
						}
					}
					int count = getCount(answer);
					count = count * 3 + answer.length() - count; // 字符的长度必须匹配，否则无法正常显示
					sb.append(qData.replace(turn, tt + "").replace(charLength, answer + "").replace(answer, answer)
							.replace(score, QuizTest.hm.get(type).toString()));
//							sb.append(qData.replace(answer, Answer).replace(score, QuizTest.hm.get(type).toString()));
					tt++;

				}
			} else {
				break;
			}
			sb.append("}");
			qv.setAnswer_data(sb.toString());
			list.add(qv);
		}
		return list;
	}

	/**
	 * 有几个汉字 * * 3
	 * 
	 * @param str
	 * @return
	 */
	public static int getCount(String str) {
		int count = 0;
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				count = count + 1;
			}
		}
		return count;
	}
}
