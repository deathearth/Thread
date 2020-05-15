package com.chl.trycatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * try-with-resources 系统帮我们关闭资源
 * 
 * @author chenhailong
 *
 */
public class TryWithResources {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("/Users/chenhailong/Desktop/fun.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
