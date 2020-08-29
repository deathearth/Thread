package com.chl.enums;

/**
 * 通过键获取值
 * @author chenhailong
 *
 */
public enum Enumkeyvalue{
		
		Juary(1,"一月");
		
		private int key;
		private String value;
		
		Enumkeyvalue(int key,String value){
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
		
		public static String getValueBy(int key) {
			
			for(Enumkeyvalue enums: values()) {
				if(enums.getKey() == key) {
					return enums.getValue();
				}
			}
			return null;
		}

}
