package com.chl.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

    public static void main(String[] args){
    	
    	File f = new File("C:\\Users\\MST-KKL\\Desktop\\allinfo.txt");
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
		
        String regex = "\\&#x(.*?)\\;";
        getQuestionResolution(regex, sb.toString());

//        System.out.println("------------------------");
//
//        String regex2 = "\\[([\\s\\S]*)\\[";
//        getQuestionResolution(regex2, str);

    }
    private static void getQuestionResolution(String regex,String html){

        Matcher matcher = Pattern.compile(regex).matcher(html);
        TreeSet<String> s = new TreeSet<String>();
        while (matcher.find()){
        	
        	s.add(matcher.group().trim());
        	
//        	System.out.println("---");
            //group是针对（）来说的，group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西。//group（）= group（0）
//            System.out.println(matcher.group().trim());
        }
        for(Iterator iter = s.iterator(); iter.hasNext();) {
        	System.out.print(iter.next()+"|");
        }
    }
}