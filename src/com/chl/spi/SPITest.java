package com.chl.spi;

import java.util.ServiceLoader;

public class SPITest {

	public static void main(String[] args) {

		ServiceLoader<Info> infos = ServiceLoader.load(Info.class);
		for(Info inf : infos) {
			System.out.println("--");
			inf.laugh();
		}
	}

}
