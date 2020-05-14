package com.chl.dataStruct;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream的测试
 * @author chenhailong
 *
 */
public class testStreams {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "e");
		Stream<String> stream = strings.stream();
		
		Iterator<String> iter = stream.distinct().iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
