package com.chl.base;

/**
 * 封装类型的测试
 * @author chenhailong
 *
 * 参考：http://hollischuang.gitee.io/tobetopjavaer/#/basics/java-basic/boxing-unboxing
 * 
 * 重点：java中的整型类型有缓存机制， 长度为 127。   小于等于127的值比较相等，大于127的值比较不相等。
 * 
 * byte,long,short,int, CharacterCache 都有缓存
 * 
 * java.lang.Integer.IntegerCache.high 可以通过这个调整上限值
 * 
 * 
 * 出现的问题除了下面的  == ， 还有三目运算符出现 NPE异常
 * 
 */
public class testInteger {

	public static void main(String... strings) {
		

		Integer integer1 = 3;
		Integer integer2 = 3;

		if (integer1 == integer2)
			System.out.println("integer1 == integer2");
		else
			System.out.println("integer1 != integer2");

		Integer integer3 = 300;
		Integer integer4 = 300;

		if (integer3 == integer4)
			System.out.println("integer3 == integer4");
		else
			System.out.println("integer3 != integer4");
		
		
		
		Integer integer5 = 127;
		Integer integer6 = 127;

		if (integer5 == integer6)
			System.out.println("integer5 == integer6");
		else
			System.out.println("integer5 != integer6");
		
		Integer integer7 = 128;
		Integer integer8 = 128;

		if (integer7 == integer8)
			System.out.println("integer7 == integer8");
		else
			System.out.println("integer7 != integer8");
	}

}
