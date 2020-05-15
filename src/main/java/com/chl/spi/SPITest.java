package com.chl.spi;

import java.util.ServiceLoader;

/**
 * 这样处理好像没法直接成功。
 * @author chenhailong
 *
 */
public class SPITest {

	public static void main(String[] args) {

		ServiceLoader<Info> infos = ServiceLoader.load(Info.class);

		for(Info inf : infos) {
			inf.laugh();
		}
	}

}
