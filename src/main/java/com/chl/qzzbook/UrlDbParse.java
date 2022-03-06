package com.chl.qzzbook;

import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.chl.convert.base64.Base64Util;

/**
 * 利用java-urlConnection解析url中的html代码，获取相关信息元素
 *
 *-  封面 | 信息
 *-------------
 *  1|2|3|4|5
 *-------------
 *--作者
 *-------------
 *--简介
 *-------------
 *--目录
 *-------------
 *--引用
 *-------------
 * @author chenhailong
 * @date 2018年10月22日 下午7:13:02
 */
public class UrlDbParse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			read();
			
		} catch (Exception e) {
			
		}
	}

	/**
	 * 读取本地文件
	 */
	public static void read() {
		StringBuilder sb = new StringBuilder();
		try {
//			System.out.println(new File(".").getAbsolutePath());
			FileReader fr = new FileReader("/Users/chenhailong/Desktop/db.txt");
			int ch;
			// 这样写可以防止最后取值到-1的情况
			while ((ch = fr.read()) != -1) {
				sb.append((char) ch); // char就可以把原本是数字的文件翻译回来
			}
			fr.close();
			parse(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 分段解析内容
	 * 
	 * @param content
	 */
	public static void parse(String content) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "一");
		map.put(2, "二");
		map.put(3, "三");
		map.put(4, "四");
		map.put(5, "五");
		map.put(6, "六");
		map.put(7, "七");
		
		Integer dirCount = 1;
		
 		Calendar day = Calendar.getInstance();
		String time = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH)+1) + "-" + day.get(Calendar.DAY_OF_MONTH);
		content = content.replace("<br>", "@@").replace("<br/>", "@@"); // 先替换换行符号
		Document doc = Jsoup.parse(content);
		
		//pic信息
		String bookPic = doc.getElementById("mainpic").getElementsByClass("nbg").get(0).attr("href");
//		System.out.println("图片信息：\n\r " + bookPic);

		// info信息
		Element info = doc.getElementById("info");
		String info_content = info.text();
		List<Element> listInfo = info.getElementsByClass("pl");
		for (Element block : listInfo) {
			String blockText = block.text();
			String suitText = blockText;
			int length = suitText.length();
			if(length ==  2 || suitText.replace(":", "").length() == 2) {
				String firstChar = suitText.substring(0,1);
				suitText = suitText.replace(firstChar, firstChar+"    ");
			}
			info_content = info_content.replace(blockText, "<strong>" + suitText + "</strong>");
			info_content = info_content.replace(":</strong>", "</strong>:");
		}
		info_content = info_content.replace("ISBN", "ISBN  ");
		
		String[] each = info_content.split("@@");
		StringBuffer sb = new StringBuffer();
		sb.append("<!-- wp:paragraph -->");
		sb.append("<p>");
		for(int i = 0 ; i <each.length; i++ ) {
			sb.append(each[i]);
			sb.append("<br>");
		}
		sb.append("</p>");
		sb.append("<!-- /wp:paragraph -->");
		
		System.out.println("<!-- wp:heading {\"level\":2} -->");
		System.out.println("<h2>"+ map.get(dirCount) +"、基本信息</h2>");
		System.out.println("<!-- /wp:heading -->");
		
		System.out.println(); 
		System.out.println("<!-- wp:columns -->"); 
		System.out.println("<div class=\"wp-block-columns\">");
		System.out.println("<!-- wp:column -->"); 
		System.out.println("<div class=\"wp-block-column\">"); 
		System.out.println("<!-- wp:paragraph -->");
		System.out.println("<p class=\"has-text-align-center\">");
		System.out.println("<img class=\"aligncenter\" src=\"https://www.ottffss.net/wp-content/uploads/201911/04/104237wg6gnjzbgi7jnei0.jpg\" width=\"220\" height=\"312\">");
		System.out.println("</p>");
		System.out.println("<!-- /wp:paragraph -->"); 
		System.out.println("</div>"); 
		System.out.println("<!-- /wp:column -->");
		System.out.println(); 
		System.out.println("<!-- wp:column -->"); 
		System.out.println("<div class=\"wp-block-column\">"); 
		System.out.println(sb.toString().replaceFirst("<p><strong>", "<p> <strong>"));
		System.out.println("</div>"); 
		System.out.println("<!-- /wp:column -->"); 
		System.out.println("</div>"); 
		System.out.println("<!-- /wp:columns -->");
		
		System.out.println(); 
		System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
		System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
		System.out.println("<!-- /wp:separator -->");
		System.out.println(); 
		
		// 评分信息
		sb = new StringBuffer();
		Element scoreInfo = doc.getElementById("interest_sectl");
		// 综合信息
		List<Element> scoreTopInfos = scoreInfo.getElementsByClass("clearbox");
		if (scoreTopInfos.size() > 0) {
			
			dirCount++;
			System.out.println("<!-- wp:heading {\"level\":2} -->");
			System.out.println("<h2>"+ map.get(dirCount) +"、评分信息</h2>");
			System.out.println("<!-- /wp:heading -->");
			
			Element scoreTopInfo = scoreTopInfos.get(0);
			// 平均评分
			Element scoreTopAverage = scoreTopInfo.getElementsByClass("rating_num").first();
			// 人数
			Element scoreTopTotal = scoreTopInfo.getElementsByClass("rating_people").first();
			// 评分等级
			List<Element> scoreLevel = scoreTopInfo.getElementsByClass("starstop");
			// 评分百分比
			List<Element> scoreLevelPercent = scoreTopInfo.getElementsByClass("rating_per");
			if(null != scoreTopTotal && null != scoreTopAverage && null != scoreLevel) {
//				System.out.println("平均评分（满分10.0）：" + scoreTopAverage.text());
//				System.out.println("总评人数（截至" + time + "）：" + scoreTopTotal.text());
				String score = "";
				if (scoreLevel.size() == scoreLevelPercent.size()) {
					for (int i = 0; i < scoreLevel.size(); i++) {
						Element innerLevel = scoreLevel.get(i);
						Element innerLevelPercent = scoreLevelPercent.get(i);
						String stars = innerLevel.text();
						if(stars.contains("5")) {
							stars = "★★★★★  " + stars;
						}else if(stars.contains("4")) {
							stars = "★★★★☆  " + stars;
						}else if(stars.contains("3")) {
							stars = "★★★☆☆  " + stars;
						}else if(stars.contains("2")) {
							stars = "★★☆☆☆  " + stars;
						}else if(stars.contains("1")) {
							stars = "★☆☆☆☆  " + stars;
						}
						if(i == 100) {
							score = score +innerLevel.attr("title") + "--" + stars + "---" + innerLevelPercent.text() + "<br>" ;
						}else {
							score = score +"\n\r"+ innerLevel.attr("title") + "--" + stars + "---" + innerLevelPercent.text() + "<br>" ;
						}
					}
					
					if(score.contains("<br>")) {
						score = score.substring(0, score.length() - 4);
					}
					
					sb.append("\n\r");
					sb.append("<!-- wp:paragraph -->");
					sb.append("<p style=\"font-size:19px\"><br>");
					sb.append(score);
					sb.append("</p>");
					sb.append("<!-- /wp:paragraph -->");
					
				}
				//头
				System.out.println(); 
				System.out.println("<!-- wp:columns -->"); 
				System.out.println("<div class=\"wp-block-columns\">");

				//中
				System.out.println("<!-- wp:column {\"verticalAlignment\":\"center\",\"width\":50} -->"); 
				System.out.println("<div class=\"wp-block-column is-vertically-aligned-center\" style=\"flex-basis:50%\">"); 
				System.out.println(sb.toString());
				System.out.println("</div>"); 
				System.out.println("<!-- /wp:column -->");
//				
//				System.out.println(); 
//				System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
//				System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
//				System.out.println("<!-- /wp:separator -->");
//				System.out.println(); 
				
				//右
				System.out.println("<!-- wp:column {\"verticalAlignment\":\"center\",\"width\":25} -->"); 
				System.out.println("<div class=\"wp-block-column is-vertically-aligned-center\" style=\"flex-basis:25%\">"); 
				System.out.println("<!-- wp:paragraph {\"dropCap\":true} -->");
				System.out.print("<p class=\"has-drop-cap has-text-align-center has-luminous-vivid-orange-color\">");
				System.out.println(scoreTopAverage.text().trim()+"分");
				System.out.println("</p>");
				System.out.println("<!-- /wp:paragraph -->"); 
				System.out.println("</div>"); 
				System.out.println("<!-- /wp:column -->");
				System.out.println(); 
				
				
				//左
				System.out.println("<!-- wp:column {\"verticalAlignment\":\"center\",\"width\":25} -->"); 
				System.out.println("<div class=\"wp-block-column is-vertically-aligned-center\" style=\"flex-basis:25%\">"); 
				System.out.println("<!-- wp:paragraph -->"); 
				System.out.println("<p class=\"has-text-align-center\">平均分数（满10.0分）<br>"); 
				System.out.println("总评人数：" + scoreTopTotal.text() + "<br>"); 
				System.out.println("（截至" + time + "）");
				System.out.println("</p>"); 
				System.out.println("<!-- /wp:paragraph -->"); 
				System.out.println("</div>"); 
				System.out.println("<!-- /wp:column -->");
				
				
				//尾
				System.out.println("</div>"); 
				System.out.println("<!-- /wp:columns -->");
				
				System.out.println(); 
				System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
				System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
				System.out.println("<!-- /wp:separator -->");
				System.out.println(); 
			}else {
				System.out.println("<!-- wp:paragraph -->");
				System.out.println("<p><br>");
				System.out.println("截至" + time + "暂无评分信息");
				System.out.println("</p>");
				System.out.println("<!-- /wp:paragraph -->");
				
				System.out.println(); 
				System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
				System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
				System.out.println("<!-- /wp:separator -->");
				System.out.println(); 
			}
		}
		
		//简介
		Element introduce = doc.getElementById("link-report");
		if(null != introduce) {
			
			dirCount++;
			System.out.println("<!-- wp:heading {\"level\":2} -->");
			System.out.println("<h2>"+ map.get(dirCount) +"、内容简介</h2>");
			System.out.println("<!-- /wp:heading -->");
			
			
			// 获取正文内容
			List<Element> listIntro = introduce.getElementsByClass("intro");
			boolean bool = false;
			if(listIntro.size() == 1) {
				bool = false;
			}else {
				bool = true;
			}
			String introInfo = "";
			if(listIntro.size() > 0) {
				Element introFull = bool?listIntro.get(1):listIntro.get(0);
				List<Element> contentP = introFull.getElementsByTag("p");
				for (int i = 0; i < contentP.size(); i++) {
					Element paragraph = contentP.get(i);
					introInfo = introInfo + paragraph.text() + "\n\r";
				}
			}
			introInfo = introInfo.replace(";", "；").replace("。", "。<br><br>");
			
//			System.out.println("内容简介：\n\r  " + introInfo);
			//处理引用
			System.out.println(); 
			System.out.println("<!-- wp:paragraph -->");
			System.out.println(introInfo);
			System.out.println("<!-- /wp:paragraph -->");
			
			System.out.println(); 
			System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
			System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
			System.out.println("<!-- /wp:separator -->");
			System.out.println(); 
		}
		
		// 作者信息,   这个有问题
//		List<Element> authorInfos = doc.getElementsByClass("a_show_full");
		List<Element> authorInfos = doc.getElementsMatchingOwnText("作者简介");
		if (authorInfos.size() > 0) {
			
			dirCount++;
			System.out.println("<!-- wp:heading {\"level\":2} -->");
			System.out.println("<h2>"+ map.get(dirCount) +"、作者简介</h2>");
			System.out.println("<!-- /wp:heading -->");
			
			
			Element innerTag = authorInfos.get(0);
			// 获取到当前元素的父级的相邻下级元素
			Element nextSibling = innerTag.parent().nextElementSibling();
			// 获取正文内容
			List<Element> authorDivs = nextSibling.getElementsByClass("intro");
			boolean bool = false;
			if(authorDivs.size() == 1) {
				bool = false;
			}else {
				bool = true;
			}
			Element authorFull =  bool?authorDivs.get(1):authorDivs.get(0);
			List<Element> contentP = authorFull.getElementsByTag("p");
			String authorInfo = "";
			for (int i = 0; i < contentP.size(); i++) {
				Element paragraph = contentP.get(i);
				authorInfo = authorInfo + paragraph.text() + "\n\r";
			}
//			System.out.println("作者信息：\n\r  " + authorInfo);
			
			authorInfo = authorInfo.replace(";", "；").replace("。", "。<br><br>");
			//处理引用
			System.out.println(); 
			System.out.println("<!-- wp:paragraph -->");
			System.out.println(authorInfo);
			System.out.println("<!-- /wp:paragraph -->");
			
			System.out.println(); 
			System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
			System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
			System.out.println("<!-- /wp:separator -->");
			System.out.println(); 
		}
		
		List<Element> metalist = doc.getElementsByTag("meta");
		String bookid = "";
		for(int j = 0; j < metalist.size() ; j++) {
			Element meta = metalist.get(j);
			if(meta.hasAttr("property") && meta.attr("property").equals("og:url")){
				bookid = meta.attr("content").toString();
				bookid = bookid.split("subject")[1].replace("/", "");
			}
		}

		// 相关信息
		Element relateInfo = doc.getElementsByClass("related_info").get(0);
		// 章节目录信息
		Element chapterInfo = relateInfo.getElementById("dir_"+bookid+"_full");
		if (null != chapterInfo) {
			String chapter = chapterInfo.text();
			chapter = chapter.replace(" · · · · · · (收起)", "");

			
			dirCount++;
			System.out.println("<!-- wp:heading {\"level\":2} -->");
			System.out.println("<h2>"+ map.get(dirCount) +"、目录一览</h2>");
			System.out.println("<!-- /wp:heading -->");
			
			//处理引用
			System.out.println(); 
			System.out.println("<!-- wp:paragraph -->");
			System.out.println(chapter.replace("@@", "<br>\n\r"));
			System.out.println("<!-- /wp:paragraph -->");
			
			System.out.println(); 
			System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
			System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
			System.out.println("<!-- /wp:separator -->");
			System.out.println(); 
		}
		
		
		/**
		 * <blockquote class="wp-block-quote is-style-default">
		 * <p>当说到并不是那么重要的信息时，他们（说谎者）似乎都具备了超强的记忆力，而且通常都会“想起”哪怕是最细枝末节之处。</p>
		 * <cite>引自第48页</cite>
		 * </blockquote>
		 */
		
		// 原文信息
		List<Element> originInfos = doc.getElementsByClass("blockquote-list");
		if (originInfos.size() > 0) {
			
			dirCount++;
			System.out.println("<!-- wp:heading {\"level\":2} -->");
			System.out.println("<h2>"+ map.get(dirCount) +"、原文赏析</h2>");
			System.out.println("<!-- /wp:heading -->");
			
			Element originInfo = originInfos.get(0);
			// 获取第一篇信息
			List<Element> originPosts = originInfo.getElementsByTag("figure");
			int count = originPosts.size() > 1?2:1;
			String seqNum = "";
			for(int i = 0 ; i < count ; i++) {
				
				if( i == 0 ) { seqNum = "(一)";}
				if( i == 1 ) { seqNum = "(二)";}
				
				Element originPost = originPosts.get(i);
				// 先获取html正文，然后截取信息
				String originHtml = originPost.html();
				originHtml = originHtml.substring(0, originHtml.indexOf("查看原文"));
				originHtml = originHtml.replace("<figure>", "").replaceAll("<a.*?\\/\">", "");
				originHtml = originHtml.substring(0, originHtml.lastIndexOf("("));
				originHtml = originHtml.replace(" ", "\n\r");
				
				originHtml = "<blockquote class=\"wp-block-quote is-style-default\">"
						+ "<p class=\"has-small-font-size\">"
						+ originHtml
						+ "</p>\n\r"
						+ "<cite>暂无</cite>"
						+ "</blockquote>";
				
				List<Element> originRefers = originPost.getElementsByTag("figcaption");
				String refer = "";
				if (originRefers.size() > 0) {
					Element originRefer = originRefers.get(0);
					refer = originRefer.text();
//					System.out.println("出处引用："+ refer +"\n\r  ");
				}
				
				//拼接引自
				if(refer.length() > 0) {
					originHtml = originHtml.replace("<cite>暂无</cite>", "<cite>"+refer+"</cite>");
				}
				
//				<!-- wp:paragraph {"align":"center","backgroundColor":"very-light-gray"} -->
//				<p class="has-background has-text-align-center has-very-light-gray-background-color"><strong>（二）</strong></p>
//				<!-- /wp:paragraph -->
				StringBuilder ssb = new StringBuilder();
				ssb.append("<!-- wp:paragraph {\"align\":\"center\",\"backgroundColor\":\"very-light-gray\"} -->");
				ssb.append("\n\r");
				ssb.append("<p class=\"has-background has-text-align-center has-very-light-gray-background-color\"><strong>");
				ssb.append(seqNum);
				ssb.append("</strong></p>");
				ssb.append("\n\r");
				ssb.append("<!-- /wp:paragraph -->");
				
				//处理引用
				System.out.println(); 
				System.out.println(ssb.toString());
				System.out.println(); 
				System.out.println("<!-- wp:paragraph {\"fontSize\":\"small\"} -->");
				System.out.println(originHtml.replace("。", "。<br><br>"));
				System.out.println("<!-- /wp:paragraph -->");
				System.out.println();
			}
			
			System.out.println(); 
			System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
			System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
			System.out.println("<!-- /wp:separator -->");
			System.out.println(); 
		}
		
		
		
		/**
		 * <blockquote class="wp-block-quote is-style-default">
		 * <p>当说到并不是那么重要的信息时，他们（说谎者）似乎都具备了超强的记忆力，而且通常都会“想起”哪怕是最细枝末节之处。</p>
		 * <cite>引自第48页</cite>
		 * </blockquote>
		 */
		// 原文信息
		List<Element> hrs = doc.getElementsByTag("h2");
		if (hrs.size() > 0) {
			for(Element e: hrs) {
				String text = e.text();
				if(text.equals("丛书信息")) {
					
					dirCount++;
					System.out.println("<!-- wp:heading {\"level\":2} -->");
					System.out.println("<h2>"+ map.get(dirCount) +"、丛书信息</h2>");
					System.out.println("<!-- /wp:heading -->");
					String sers = e.nextElementSibling().text();
					sers = sers.replace(";", "；").replace("。", "。<br><br>");
					System.out.println("<!-- wp:paragraph -->");
					System.out.println(sers);
					System.out.println("<!-- /wp:paragraph -->");
				}
			}
			
			System.out.println(); 
			System.out.println("<!-- wp:separator {\"className\":\"is-style-wide\"} -->");
			System.out.println("<hr class=\"wp-block-separator is-style-wide\"/>");
			System.out.println("<!-- /wp:separator -->");
			System.out.println(); 
		}
		
		System.out.println(); 
		System.out.println("<!-- wp:paragraph -->");
		System.out.println("<p>查看更多心理学书籍：<a href=\"https://www.ottffss.net/3254.html\" title=\"340本心理学书籍整理，第一弹\">340本心理学书籍整理，第一弹</a></p>");
		System.out.println("<!-- /wp:paragraph -->");
		
	}
	
	
	

}