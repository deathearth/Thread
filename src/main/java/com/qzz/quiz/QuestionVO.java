package com.qzz.quiz;

/**
 * 单题信息
 * @author question
 *
 */
public class QuestionVO {

@Override
	public String toString() {
		return "QuestionVO [id=" + id + ", quiz_id=" + quiz_id + ", online=" + online + ", sort=" + sort + ", title="
				+ title + ", points=" + points + ", question=" + question + ", correct_msg=" + correct_msg
				+ ", incorrect_msg=" + incorrect_msg + ", correct_same_text=" + correct_same_text + ", tip_enabled="
				+ tip_enabled + ", tip_msg=" + tip_msg + ", answer_type=" + answer_type + ", show_points_in_box="
				+ show_points_in_box + ", answer_points_activated=" + answer_points_activated + ", answer_data="
				+ answer_data + ", category_id=" + category_id + ", answer_points_diff_modus_activated="
				+ answer_points_diff_modus_activated + ", disable_correct=" + disable_correct
				+ ", matrix_sort_answer_criteria_width=" + matrix_sort_answer_criteria_width + "]";
	}
	/**
 * INSERT INTO `wordpress`.`wp_wp_pro_quiz_question`
 * (`id`, `quiz_id`, `online`, `sort`, `title`, `points`, `question`, `correct_msg`, `incorrect_msg`, 
 * `correct_same_text`, `tip_enabled`, `tip_msg`, `answer_type`, `show_points_in_box`, `answer_points_activated`,
 *  `answer_data`, `category_id`, `answer_points_diff_modus_activated`, `disable_correct`, `matrix_sort_answer_criteria_width`) VALUES 
 *  (1, 1, 1, 1, '这是一个好问题', 3, '这是题干', '这是正确答案', '这是错误答案', 0, 1, '这是提示信息', 
 *  'single', 1, 1, 
 *  'a:3:{
 *  i:0;O:27:\"WpProQuiz_Model_AnswerTypes\":7:
 *  {s:10:\"\0*\0_answer\";s:12:\"两分答案\";s:8:\"\0*\0_html\";b:0;s:10:\"\0*\0_points\";i:2;s:11:\"\0*\0_correct\";b:1;s:14:\"\0*\0_sortString\";s:0:\"\";s:18:\"\0*\0_sortStringHtml\";b:0;s:10:\"\0*\0_mapper\";N;}
 *  i:1;O:27:\"WpProQuiz_Model_AnswerTypes\":7:
 *  {s:10:\"\0*\0_answer\";s:12:\"一分答案\";s:8:\"\0*\0_html\";b:0;s:10:\"\0*\0_points\";i:1;s:11:\"\0*\0_correct\";b:0;s:14:\"\0*\0_sortString\";s:0:\"\";s:18:\"\0*\0_sortStringHtml\";b:0;s:10:\"\0*\0_mapper\";N;}
 *  i:2;O:27:\"WpProQuiz_Model_AnswerTypes\":7:
 *  {s:10:\"\0*\0_answer\";s:12:\"三分答案\";s:8:\"\0*\0_html\";b:0;s:10:\"\0*\0_points\";i:3;s:11:\"\0*\0_correct\";b:0;s:14:\"\0*\0_sortString\";s:0:\"\";s:18:\"\0*\0_sortStringHtml\";b:0;s:10:\"\0*\0_mapper\";N;}
 *  }', 2, 1, 0, 20);
 */
	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 绑定试题
	 */
	private int quiz_id;
	/**
	 * 
	 */
	private int online;
	/**
	 * 排序
	 */
	private int sort;
	/**
	 * 问题
	 */
	private String title;
	/**
	 * 积分
	 */
	private int points;
	private String question;
	private String correct_msg;
	private String incorrect_msg;
	private int correct_same_text;
	/**
	 * 是否开启提示
	 */
	private int tip_enabled;
	private String tip_msg;
	private String answer_type;
	private int show_points_in_box;
	private int answer_points_activated;
	private String answer_data;
	private int category_id;
	private int answer_points_diff_modus_activated;
	private int disable_correct;
	private int matrix_sort_answer_criteria_width;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCorrect_msg() {
		return correct_msg;
	}
	public void setCorrect_msg(String correct_msg) {
		this.correct_msg = correct_msg;
	}
	public String getIncorrect_msg() {
		return incorrect_msg;
	}
	public void setIncorrect_msg(String incorrect_msg) {
		this.incorrect_msg = incorrect_msg;
	}
	public int getCorrect_same_text() {
		return correct_same_text;
	}
	public void setCorrect_same_text(int correct_same_text) {
		this.correct_same_text = correct_same_text;
	}
	public int getTip_enabled() {
		return tip_enabled;
	}
	public void setTip_enabled(int tip_enabled) {
		this.tip_enabled = tip_enabled;
	}
	public String getTip_msg() {
		return tip_msg;
	}
	public void setTip_msg(String tip_msg) {
		this.tip_msg = tip_msg;
	}
	public String getAnswer_type() {
		return answer_type;
	}
	public void setAnswer_type(String answer_type) {
		this.answer_type = answer_type;
	}
	public int getShow_points_in_box() {
		return show_points_in_box;
	}
	public void setShow_points_in_box(int show_points_in_box) {
		this.show_points_in_box = show_points_in_box;
	}
	public int getAnswer_points_activated() {
		return answer_points_activated;
	}
	public void setAnswer_points_activated(int answer_points_activated) {
		this.answer_points_activated = answer_points_activated;
	}
	public String getAnswer_data() {
		return answer_data;
	}
	public void setAnswer_data(String answer_data) {
		this.answer_data = answer_data;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getAnswer_points_diff_modus_activated() {
		return answer_points_diff_modus_activated;
	}
	public void setAnswer_points_diff_modus_activated(int answer_points_diff_modus_activated) {
		this.answer_points_diff_modus_activated = answer_points_diff_modus_activated;
	}
	public int getDisable_correct() {
		return disable_correct;
	}
	public void setDisable_correct(int disable_correct) {
		this.disable_correct = disable_correct;
	}
	public int getMatrix_sort_answer_criteria_width() {
		return matrix_sort_answer_criteria_width;
	}
	public void setMatrix_sort_answer_criteria_width(int matrix_sort_answer_criteria_width) {
		this.matrix_sort_answer_criteria_width = matrix_sort_answer_criteria_width;
	}

}
