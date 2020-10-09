package com.chl.dataStruct;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class CollectionsTest {

	public static void main(String[] args) {
		
		List<String> ls = new ArrayList<String>();
		ls.add("123");
		System.out.println(CollectionUtils.isNotEmpty(ls));
	}
}
