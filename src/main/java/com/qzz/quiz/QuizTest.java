package com.qzz.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 *  单题的每个答案不能一样
 *   https://wenku.baidu.com/view/452d59244a73f242336c1eb91a37f111f1850d0d.html
 */
public class QuizTest {
	
	/**
	 * 前置处理参数
	 */
	
	//所属试卷
	public static Integer quizId = 17;
	
	/**
	 * 不能出现特殊符号
	 */
	private static String allTheWay = "是%1,否%0"; 
//	private static String allTheWay = "非常符合%-2,比较符合计%-1,拿不准的计%0,比较不符合计%1,完全不符合计%2";
//	private static String allTheWay = "0分%0,1分%1,2分%2,3分%3,4分%4,5分%5";
	
	/***
	 * ================================================================================
	 * ==============================没有答案的题只要上面==============================
	 * ================================================================================
	 */
	
	
	//试题有几种分类,和下面的一一对应
	public static Integer type = 9;
	
	//二维数组处理,如果每种类型的题分不一致的话需要用这个
	public static Integer scoreIds[][] = 
		{
			{2,14,55,57,60,  63,73,81,87,91, 97,102,104,106},
			{6,8,22,30,69,   71,79,82,85,86, 89,90},
			{20,33,38,59,65, 67,70,72,74,77, 80,93},
			{7,13,17,52,53,  54,56,58,61,64, 100,105},
			{3,19,23,32,42,  43,47,48,51,83, 88,99,101},
			{9,10,26,29,31,  35,37,45,46,68, 75},
			{4,16,18,21,28,  49,78,92,103},
			{5,11,24,27,40,  44,50,66,76,84, 95,96},
			{1,12,15,25,34,  36,39,41,62,94, 98,107,108}
		};
	
	/**
	 * 分类信息,这个指把试题分为了几大类
	 */
	public static Integer classify[] = {29,30,31,32,33,34,35,36,37}; //注：这个需要和上面的顺序保持一致
	
	/**
	 * 分数和上面的classify相对应，表示每个分类的试题应该获得多少分
	 */
	private static Integer score[] = {}; //注：这个需要和上面的顺序保持一致
	
	public static Integer SCORE_POINT_INFO = 1; 
	
	/**
	 * 存放类型 + 分数
	 * type , scoreIds,classify,score 相关联信息
	 */
	public static HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	
	/**
	 * 固定类型 + 分数 两种
	 * 1 - 是%1,否%0
	 * 2 - 非常符合%-2,比较符合计%-1,拿不准的计%0,比较不符合计%1,完全不符合计%2
	 */
	public static HashMap<String,Integer> ac = new HashMap<String,Integer>();
	
	/**
	 * 条件是否满足，否则不触发
	 */
	static boolean b = true;
	
	void init(){
		//判断基本逻辑是否正确
		if( classify.length != type || score.length != type) {
			if(type!=1) {
				b = false;
			}
		}else {
			for(int i = 0;i< type ; i++) {
				hm.put(classify[i], score[i]);
			}
		}
		
		String[] ans = allTheWay.split(",");
		for(String a : ans) {
			String[] kv = a.split("%");
			if(a.indexOf("－")<0) { //这个是减号，不是连接符
				ac.put(kv[0], Integer.parseInt(kv[1]));
			}else {//处理负数
				ac.put(kv[0], 0-Integer.parseInt(kv[1].replace("－", "")));
			}
		}
	}
	

	public static void main(String[] args) {
		new QuizTest().init();
		boolean bool = true;
		
		String txt = "";
		String path = System.getProperty("user.dir") + "/src/main/resources/";
		String name = "九型人格";
		txt = getLocalTxt(path + "九型人格.txt");
		
		if(txt.indexOf(SameAnswerNoCate.splitQ) < 0
				) {
			bool= false;
		}
		
		if(bool) {
			List<QuestionVO> list = new ArrayList<QuestionVO>();
//			list = SameAnswerNoCate.analyseText(txt);
			list = SameAnswerHasCate.analyseText(txt,SCORE_POINT_INFO);
//			list = DifferentAnswerNoCate.analyseText(text);
			
			/**
			 * 拼接插入语句
			 */
			PackageInsert.concatSql(list,name);
		}

	}
	
	
	private static String getLocalTxt(String name) {
		File f = new File(name);
    	StringBuilder sb = new StringBuilder();
    	FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	    	BufferedReader br = new BufferedReader(isr);
	    	String line ;
			while((line = br.readLine()) != null){
				sb.append(line);
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
			

/**
 * example for DifferentAnswerNoCate
 */
//			"###1%%%我不喜欢人家问我广泛,笼统的问题\r\n" + 
//			"a.这是什么&&&b.那是什么" +
//			"###2%%%我习惯推销自己,从不觉得难为情\r\n" +
//			"a.这是什么&&&b.那是什么";

}
