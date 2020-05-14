package com.chl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Temp {

	public static void main(String[] args) {

		
		try {
			FileUtils.forceDelete(new File("---"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
