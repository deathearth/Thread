package com.chl.analysis;

import java.util.List;

/**
*
*
* @author By chl
* @date 2020年9月14日-上午11:17:51
*/
public class QuestionModel {
	/**
	 * 问题
	 */
	private String question;
	
	/**
	 * 答案
	 */
	private List<Choose> choose;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Choose> getChoose() {
		return choose;
	}

	public void setChoose(List<Choose> choose) {
		this.choose = choose;
	}
	
	@Override
	public String toString() {
		return "QuestionModel [question=" + question + ", choose=" + choose + "]";
	}
	
	public class Choose{
		private String name;
		
		private String score;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "Choose [name=" + name + ", score=" + score + "]";
		}
		
	}
}
