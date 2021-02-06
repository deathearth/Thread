package com.qzz.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PackageInsert {

	/**
	 * 包装生成sql
	 * @param list
	 */
	public static void concatSql(List<QuestionVO> list, String name) {
		
		StringBuffer sb = new StringBuffer();
		for(QuestionVO q: list) {
			sb.append(" INSERT INTO ");
			sb.append(" `wp_wp_pro_quiz_question` (");
//			sb.append(" `id`," );
			sb.append(" `quiz_id`, `online`, `sort`, `title`, ");
			sb.append(" `points`, `question`, `correct_msg`, `incorrect_msg`, `correct_same_text`, ");
			sb.append(" `tip_enabled`, `tip_msg`, `answer_type`, `show_points_in_box`, `answer_points_activated`, ");
			sb.append("  `answer_data`, `category_id`, `answer_points_diff_modus_activated`, `disable_correct`, `matrix_sort_answer_criteria_width`");
			sb.append(") VALUES ( ");
			sb.append(q.getQuiz_id());
			sb.append(",");
			sb.append(q.getOnline());
			sb.append(",");
			sb.append(q.getSort());
			sb.append(",");
			sb.append("' "+("问题："+q.getSort()) +" '");
			sb.append(",");
			sb.append(q.getPoints());
			sb.append(",");
			sb.append(" '"+ q.getQuestion() +"' ");
			sb.append(",");
			sb.append(" '"+ q.getCorrect_msg() +"' ");
			sb.append(",");
			sb.append(" '"+ q.getIncorrect_msg() +"' ");
			sb.append(",");
			sb.append(q.getCorrect_same_text());
			sb.append(",");
			sb.append(q.getTip_enabled());
			sb.append(",");
			sb.append(" '"+ q.getTip_msg() +"' ");
			sb.append(",");
			sb.append(q.getAnswer_type()); //类型
			sb.append(",");
			sb.append(q.getCategory_id());
			sb.append(",");
			sb.append(q.getAnswer_points_activated());
			sb.append(",");
			sb.append(" '"+q.getAnswer_data()+"' ");
			sb.append(",");
			sb.append(q.getCategory_id());
			sb.append(",");
			sb.append(q.getAnswer_points_diff_modus_activated());
			sb.append(",");
			sb.append(q.getDisable_correct()); //去掉正确错误答案
			sb.append(",");
			sb.append(q.getMatrix_sort_answer_criteria_width());
			sb.append(" ); ");
			sb.append("\r\n");
		}
		
		
		write(sb.toString(), name);
	}
	
	public static void write(String s, String name) {
		String path = System.getProperty("user.dir") + "/src/main/resources/";
		path = path + name + ".sql";
		File f = new File(path);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(s.getBytes());
			
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
