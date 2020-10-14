package com.qzz.quiz;

import java.util.HashMap;
import java.util.List;

public class QuizTest {
	
	/**
	 * 前置处理参数
	 */
	
	//所属试卷
	private static Integer quizId = 1;
	
	//试题有几种分类
	private static Integer type = 4;
	
	//二维数组处理,如果每种类型的题分不一致的话需要用这个
	private static Integer scoreIds[][] = 
		{
		{},
		{},
		{},
		{}
		};	
	
	//分类信息
	private static Integer classify[] = {}; //注：这个需要和上面的顺序保持一致
	
	//分数信息
	private static Integer score[] = {}; //注：这个需要和上面的顺序保持一致
	
	private static String allTheWay = "非常符合+%2，比较符合计+%1，拿不准的计%0，比较不符合计%－1，完全不符合计%－2";
	
	//存放类型 + 分数
	private static HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	
	//固定类型 + 分数
	public static HashMap<String,Integer> ac = new HashMap<String,Integer>();
	
	//条件是否满足
	static boolean b = true;
	
	QuizTest(){
		if( classify.length != type || score.length != type) {
			if(type!=1) {
				b = false;
			}
		}else {
			for(int i = 0;i< type ; i++) {
				hm.put(classify[i], score[i]);
			}
		}
		
		String[] ans = allTheWay.split("，");
		for(String a : ans) {
			String[] kv = a.split("%");
			ac.put(kv[0], Integer.parseInt(kv[1]));
		}
		
	}
	

	public static void main(String[] args) {
		if(text.indexOf(TextAnalyse.splitQ) < 0) {
			b = false;
		}
		if(b) {
			List<QuestionVO> list = TextAnalyse.analyseText(text);
		}

	}
	
	private static String text = "1. 做事力求稳妥，不做无把握的事。\r\n" + 
			"2. 遇到可气的事就怒不可遏，想把心里话全说出来才痛快。\r\n" + 
			"3. 宁肯一个人干事，不愿很多人在一起。\r\n" + 
			"4. 到一个新环境很快就能适应。\r\n" + 
			"5. 厌恶那些强烈的刺激，如尖叫、噪声、危险的镜头等。\r\n" + 
			"6. 和人争吵时，总是先发制人，喜欢挑衅。\r\n" + 
			"7. 喜欢安静的环境。\r\n" + 
			"8. 喜欢和人交往。\r\n" + 
			"9. 羡慕那种能克制自己感情的人。\r\n" + 
			"10. 生活有规律，很少违反作息制度。\r\n" + 
			"11. 在多数情况下情绪是乐观的。\r\n" + 
			"12. 碰到陌生人觉得很拘束。\r\n" + 
			"13. 遇到令人气愤的事，能很好地自我克制。\r\n" + 
			"14. 做事总是有旺盛的精力。\r\n" + 
			"15. 遇到问题常常举棋不定，优柔寡断。\r\n" + 
			"16. 在人群中从不觉得过分拘束。\r\n" + 
			"17. 情绪高昂时，觉得干什么都有趣。\r\n" + 
			"18. 当注意力集中于一件事时，别的事很难使我分心。\r\n" + 
			"19. 理解问题总比别人快。\r\n" + 
			"20. 碰到危险情境，常有一种极度恐怖感。\r\n" + 
			"21. 对学习、工作、事业怀有很高的热情。\r\n" + 
			"22. 能够长时间做枯燥、单调的工作。\r\n" + 
			"23. 符合兴趣的事情，干起来劲头十足，否则就不想干。\r\n" + 
			"24. 一点小事就能引起情绪波动。\r\n" + 
			"25. 讨厌做那种需要耐心、细致的工作。\r\n" + 
			"26. 与人交往不卑不亢。\r\n" + 
			"27. 喜欢参加热烈的活动。\r\n" + 
			"28. 爱看感情细腻、描写人物内心活动的文学作品。\r\n" + 
			"29. 工作、学习时间长了，常感到厌倦。\r\n" + 
			"30. 不喜欢长时间谈论一个问题，愿意实际动手干。\r\n" + 
			"31. 宁愿侃侃而谈，不愿窃窃私语。\r\n" + 
			"32. 别人说我总是闷闷不乐。\r\n" + 
			"33. 疲倦时只要短暂的休息就能精神抖擞，重新投入工作。\r\n" + 
			"34. 理解问题常比别人慢些。\r\n" + 
			"35. 心里有话宁愿自己想，不愿说出来。\r\n" + 
			"36. 认准一个目标就希望尽快实现，不达目的，誓不罢休。\r\n" + 
			"37. 学习、工作同样一段时间后，常比别人更疲倦。\r\n" + 
			"38. 做事有些莽撞，常常不考虑后果。\r\n" + 
			"39. 老师或师傅讲授新知识、技术时，总希望他讲慢些，多重复几遍。\r\n" + 
			"40. 能够很快地忘记那些不愉快的事情。\r\n" + 
			"41. 做作业或完成一件工作总比别人花的时间多。\r\n" + 
			"42. 喜欢运动量大的剧烈体育活动，或参加各种文娱活动。\r\n" + 
			"43. 不能很快地把注意力从一件事转移到另一件事上去。\r\n" + 
			"44. 接受一个任务后，希望把它迅速完成。\r\n" + 
			"45. 认为墨守成规比冒风险强些。\r\n" + 
			"46. 能够同时注意几件事物。\r\n" + 
			"47. 当我烦闷的时候，别人很难使我高兴起来。\r\n" + 
			"48. 爱看情节起伏跌宕、激动人心的小说。\r\n" + 
			"49. 对工作抱认真严谨、始终一贯的态度。\r\n" + 
			"50. 和周围人们的关系总是相处不好。\r\n" + 
			"51. 喜欢复习学过的知识，重复做已经掌握的工作。\r\n" + 
			"52. 喜欢做变化大、花样多的工作。\r\n" + 
			"53. 小时候会背的诗歌，我似乎比别人记得清楚。\r\n" + 
			"54. 别人说我\"出语伤人\"，可我并不觉得这样。\r\n" + 
			"55. 在体育活动中，常因反应慢而落后。\r\n" + 
			"56. 反应敏捷，头脑机智。\r\n" + 
			"57. 喜欢有条理而不甚麻烦的工作。\r\n" + 
			"58. 兴奋的事常使我失眠。\r\n" + 
			"59. 老师讲新概念，常常听不懂，但是弄懂以后就很难忘记。\r\n" + 
			"60. 假如工作枯燥无味，马上就会情绪低落。";

}