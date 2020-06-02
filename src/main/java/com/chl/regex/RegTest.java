package com.chl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

    public static void main(String[] args){
        String regex = "\\[([\\s\\S]*?)\\[";
        String str = "[begin]111[end] [begin]222[end] [begin]333[end] ";
        getQuestionResolution(regex, str);

        System.out.println("------------------------");

        String regex2 = "\\[([\\s\\S]*)\\[";
        getQuestionResolution(regex2, str);

    }
    private static void getQuestionResolution(String regex,String html){

        Matcher matcher = Pattern.compile(regex).matcher(html);
        while (matcher.find()){
            //group是针对（）来说的，group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西。//group（）= group（0）
            System.out.println(matcher.group().trim());
        }
    }
}