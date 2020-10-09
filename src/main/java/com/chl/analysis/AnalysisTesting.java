package com.chl.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;

/**
*
* 题目自行解析 + 简介自行处理 + 答案自行处理
* @author By chl
* @date 2020年9月14日-上午10:26:44
*/
public class AnalysisTesting {
	
	HashMap<Integer,String> map = new HashMap<Integer,String>(); //键值 - 分值：题属
	
	//初始化评分机制
	public AnalysisTesting() {
		map.put(1, "");
		map.put(2, "");
		map.put(3, "");
		map.put(4, "");
	}

	public static void main(String[] args) {

		String title = "Self-Rating Anxiety Scale SAS";	
		
		String info = "Q1. 我无缘无故地感到害怕\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q2. 我觉得比平常容易紧张和着急\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q3. 我手脚发抖打颤\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q4. 我容易心里烦乱或觉得惊恐\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q5. 我做恶梦\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q6. 我有晕倒发作，或觉得要晕倒似的\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q7. 我因为头痛、头颈痛和背痛而苦恼\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q8. 我脸红发热\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q9. 我常常要小便\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q10. 我的手脚麻木和刺痛\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q11. 我觉得心跳得很快\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q12. 我感觉容易衰弱和疲乏\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q13. 我吸气呼气都感到很容易\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q14. 我因为一阵阵头晕而苦恼\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q15. 我觉得我可能将要发疯\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q16. 我觉得一切都很好，也不会发生什么不幸\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q17. 我因为胃痛和消化不良而苦恼\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q18. 我觉得心平气和，并且容易安静坐着\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q19. 我的手是干燥温暖的\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常\r\n" + 
				"Q20. 我容易入睡，并且一夜睡得很好\r\n" + 
				" A. 很少\r\n" + 
				" B. 较少\r\n" + 
				" C. 较多\r\n" + 
				" D. 经常";
		
		String regular = "填表注意事项：下面有二十道题，每一题后有四个表格，分别表示：  "
				+ "1、没有或很少时间； "
				+ "2、少部分时间；"
				+ "3、相当多时间；"
				+ "4、绝大部分时间或全部时间。 "
				+ "请仔细阅读每一题，把意思弄明白，然后根据您最近一星期的实际情况在适当的方格内划√（请在10分钟内完成）。  "
				+ "总分＞41分，您需要找医生了！  \r\n" + 
				"获取";
		
		
		
		String[] question = info.split("\r\n");
		
		List<QuestionModel> list = new ArrayList<QuestionModel>();
		List<QuestionModel.Choose> chos = new ArrayList<QuestionModel.Choose>();
		QuestionModel qm = null;
		for(int i = 0; i < question.length; i++) {
			String str = question[i];
			if(str.startsWith("Q")) { //以XXX开头，表示为新的一题
				if((qm != null && qm.getQuestion().length() > 0) && (chos !=null && chos.size() > 0)) {//题型组装
					qm.setChoose(chos);
					list.add(qm);
				}
				
				chos = new ArrayList<QuestionModel.Choose>(); //周而复始
				qm = new QuestionModel(); 
				qm.setQuestion(str);
			}else {
				QuestionModel.Choose cho = new QuestionModel().new Choose();
				cho.setName(str);
				
			    //这里可以根据评分逻辑/规则  处理不同试题的不同评分
				cho.setScore(str);
				chos.add(cho);
			}
			
			if(i == question.length-1) { //如果是最后一个
				qm.setChoose(chos);
				list.add(qm);
			}
		}
		
		Object obj = JSONObject.toJSON(list);
		
		System.out.println(obj);
		
	}
	
	
	private Integer calculateScore(String str) {
		for(Integer key: map.keySet()) {
			String value = map.get(key);
			if(value != null) {
				String values[] = value.split(",");
				for(int i = 0; i<values.length; i++) {
					if(str.equals(values[i])) {
						return key;
					}
				}
			}
		}
		return 0;
	}
	
	private Integer calculateScore1(String str) {
		for(Entry entry: map.entrySet()) {
			String values[] = entry.getValue().toString().split(",");
			for(int i = 0; i < values.length ; i++) {
				if(str .equals(values[i])) {
					return Integer.parseInt(entry.getKey().toString());
				}
			}
		}
		return 0;
	}
	
	private Integer calculateScore2(String str) {
		return  map.entrySet().stream().filter(p->{
			String values[] = p.getValue().split(",");
			for(int i = 0; i<values.length; i++) {
				if(str.equals(values[i])) {
					return true;
				}
			}
			return false;
		}).map(p->p.getKey()).findFirst().orElse(0);
	}
}
