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
 *
 */
public class QuizMBTItest {
	
	/**
	 * 前置处理参数
	 */
	
	//所属试卷
	public static Integer quizId = 18;
	
	/**
	 * 不能出现特殊符号
	 */
//	private static String allTheWay = "是%1,否%0"; 
//	private static String allTheWay = "非常符合%-2,比较符合计%-1,拿不准的计%0,比较不符合计%1,完全不符合计%2";
	private static String allTheWay = "完全不符合%0,比较不符合%1,拿不准%2,有一点符合%3,比较符合%4,非常符合%5";
	
	/***
	 * ================================================================================
	 * ==============================没有答案的题只要上面==============================
	 * ================================================================================
	 */
	
	/**
	 * 5
	 */
	public static Integer SCORE_POINT_INFO = 5; 

	
	
	//试题有几种分类,和下面的一一对应
	public static Integer type = 8;
	
	//二维数组处理,如果每种类型的题分不一致的话需要用这个
	public static Integer scoreIds[][] = 
		{
			{1, 9,17,25,33,41,49,57,65,73,81,89},
			{2,10,18,26,34,42,50,58,66,74,82,90},
			{3,11,19,27,35,43,51,59,67,75,83,91},
			{4,12,20,28,36,44,52,60,68,76,84,92},
			{5,13,21,29,37,45,53,61,69,77,85,93},
			{6,14,22,30,38,46,54,62,70,78,86,94},
			{7,15,23,31,39,47,55,63,71,79,87,95},
			{8,16,24,32,40,48,56,64,72,80,88,96},
		};
	
	/**
	 * 分类信息,这个指把试题分为了几大类
	 */
	public static Integer classify[] = {38,39,40,41,42,43,44,45}; //注：这个需要和上面的顺序保持一致
	
	/**
	 * 分数和上面的classify相对应，表示每个分类的试题应该获得多少分
	 */
	private static Integer score[] = {}; //注：这个需要和上面的顺序保持一致
	
	/**
	 * 存放类型 + 分数
	 * type 、 scoreIds、classify、score 相关联信息
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
		new QuizMBTItest().init();
		boolean bool = true;
		
		String path = System.getProperty("user.dir") + "/src/main/resources/";
//		String name = "九型人格";
		String name = "MBTI_FORMAT";
		
		String txt = getLocalTxt(path +name+".txt");
		if(txt.indexOf(SameAnswerNoCate.splitQ) < 0) {
			bool= false;
		}
		
		if(bool) {
			List<QuestionVO> list = new ArrayList<QuestionVO>();
//			list = SameAnswerNoCate.analyseText(txt);
			list = SameAnswerHasCate.analyseText(txt,SCORE_POINT_INFO);
//			list = DifferentAnswerNoCate.analyseText(txt);
			
			/**
			 * 拼接插入语句
			 */
			PackageInsert.concatSql(list, name);
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
