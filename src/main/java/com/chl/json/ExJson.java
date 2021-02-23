package com.chl.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExJson {

	public static void main(String[] args) {
		
		JSONArray obj = JSON.parseArray(readJsonFile());
		
		get(obj,"");
		
	}
	
	
	public static void get(JSONArray obj , String pre) {
		String tem = pre;
		for(int i = 0; i < obj.size(); i ++) {
			JSONObject jobj =  (JSONObject)obj.get(i);
			JSONArray cld = jobj.getJSONArray("Children");
			if(cld.size() > 0) {
				pre = pre+ "," + jobj.getString("Name");
				JSONArray innerArray = jobj.getJSONArray("Children");
				get(innerArray,pre);
			}else {
				tem = pre +","+ jobj.getString("Name");
				System.out.println(tem);
			}
		}
		
	}
	
	
	//读取json文件
    public static String readJsonFile() {
    	String fileName = System.getProperty("user.dir") + "//src//main//java//com//chl//json//physics2.json";
        try {
            File jsonFile = new File(fileName);
            FileInputStream fi =new FileInputStream(jsonFile);
            // ClassPathResource resource = new ClassPathResource("json/physics2.json");
             String json = new BufferedReader(new InputStreamReader(fi))
                     .lines().collect(Collectors.joining("\n"));
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
