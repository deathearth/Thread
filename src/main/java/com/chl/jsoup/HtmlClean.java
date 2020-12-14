package com.chl.jsoup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class HtmlClean {

	
	
	public static void main(String[] args) {
		
		
		File f = new File("C:\\Users\\MST-KKL\\Desktop\\9rg.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader reader = new InputStreamReader(fis);
			BufferedReader buffReader = new BufferedReader(reader);
	        StringBuilder sb = new StringBuilder();
	        String strTmp = "";
	        while((strTmp = buffReader.readLine())!=null){
	            sb.append(strTmp);
	        }
	        buffReader.close();
			
	        
	        String content = Jsoup.clean(sb.toString(), Whitelist.basic());
	        content = content.replaceAll("<p>|</p>", "");
	        
	        System.out.println(content);
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
