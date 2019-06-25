package com.chl.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * 
 * @author chenhailong
 * @date 2019年5月21日 下午1:32:38
 */
public class LamadaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 集合元素的遍历
		 */
		List<String> list = Arrays.asList("Lucy", "Lily", "Tom", "Jack", "Jimy", "Anny", "Anco");
		// 旧
		for (String s : list) {
			System.out.println("循环输出集合数据(旧方式)：" + s);
		}
		// 新
		System.out.println("新一");
		list.forEach(v -> System.out.println(v));
		System.out.println("新二");
		list.forEach(System.out::println); // ::方法引用
		System.out.println("转换后输出");
		list.forEach(v -> Upper(v)); // -> 左侧是参数， 右侧是表达式

		/**
		 * 内部类的使用(线程)
		 */
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread");
			}
		});
		thread.start();
		// 新
		new Thread(() -> System.out.println("lamada -> thread")).start();

		/**
		 * 多个参数的使用
		 */
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int res = 0;
				if (o1 - o2 > 0) {
					res = 1;
				}
				if (o1 - o2 < 0) {
					res = -1;
				}
				return res;
			}
		};
		Comparator<Integer> Lamadacom = (x, y) -> {
			return Integer.compare(x, y);
		};
		System.out.println("实现比较器接口的比较结果：" + com.compare(21, 45));
		System.out.println("lamada表达式实现的结果：" + Lamadacom.compare(33, 67));

		/**
		 * 函数式接口的声明与调用
		 */
		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;
		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;
		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;
		System.out.println("10 + 5 = " + new LamadaTest().operate(10, 5, addition));
		System.out.println("10 - 5 = " + new LamadaTest().operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + new LamadaTest().operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + new LamadaTest().operate(10, 5, division));
		// 不用括号
		GreetingService greetService1 = message -> System.out.println("Hello " + message);
		// 用括号
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
		greetService1.sayMessage("Runoob");
		greetService2.sayMessage("Google");

		/**
		 * map、统计、循环输出、新对象创建 map用来归类，结果一般是一组数据，比如可以将list中的学生分数映射到一个新的stream中。
		 * reduce用来计算值，结果是一个值，比如计算最高分。
		 */
		List<animals> pets = new ArrayList<animals>();
		pets.add(new animals("dog", 11, "pet"));
		pets.add(new animals("cat", 9, ""));
		pets.add(new animals("duck", 9, "meat"));
		System.out.println("过滤出age > 9的数据： " + pets.stream().filter(pet -> pet.age > 9).collect(Collectors.toList()));
		System.out.println("所有age的平均值为： " + pets.stream().mapToInt(pet -> pet.age).summaryStatistics().getAverage());
		System.out.println("过滤出belong不为null的数据：" + pets.stream().filter(pet -> (pet.belong != "")).count());
		System.out.println("所有属性为age的值+2后为:" + pets.stream().map(pet -> pet.age + 2).collect(Collectors.toList()));
		System.out.println("循环输出所有animal对象：");
		pets.stream().forEach(System.out::println);
		pets.stream().forEach(pet -> pet.setBelong("no_no"));
		pets.stream().forEach(pet -> System.out.println("修改belong数据后循环输出：" + pet));
		List<Integer> ages = pets.stream().map(pet -> pet.age).collect(Collectors.toList());
		System.out.println("将age属性转化为集合输出：" + ages);
		Optional<Integer> max = pets.stream().map(pet -> pet.getAge()).reduce(Integer::max);
		System.out.println("获取所有数据中age最大的值：" + max.get());
		// 创建新对象
		List<animals> new_pets = pets.stream().map(pet -> new animals(pet.getName(), pet.getAge(), pet.getBelong()))
				.collect(Collectors.toList());
		System.out.println("创建一个新的animals对象： " + new_pets);
		// 创建map对象
		Map<Object, Object> result1 = pets.stream().collect(Collectors.toMap(animals::getName, animals::getAge));
		System.out.println("将对象中属性封装为map对象： " + result1);

		/**
		 * reduce处理
		 */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// 未简化写法
		int total = numbers.stream().reduce((a, b) -> {
			return a + b;
		}).get();
		System.out.println("Integer集合的总和：" + total);
		// 简化写法,当表达式一行时，可以省去花括号+return
		System.out.println("Integer集合的总和：" + numbers.stream().reduce((a, b) -> a + b).get());
		System.out.println("Integer集合的乘机：" + numbers.stream().reduce((a, b) -> a * b).get());
	}

	/**
	 * 内部静态转化方法
	 */
	public static void Upper(String str) {
		System.out.println("convert:" + str.toUpperCase());
	}

	/**
	 * 函数式接口的示例代码
	 */
	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService { // 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	/**
	 * 创建动物对象，进行流的聚合等操作
	 */
	static class animals {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getBelong() {
			return belong;
		}

		public void setBelong(String belong) {
			this.belong = belong;
		}

		Integer age;
		String belong;

		animals(String name, Integer age, String belong) {
			this.name = name;
			this.age = age;
			this.belong = belong;
		}

		@Override
		public String toString() {
			return "animals [name=" + name + ", age=" + age + ", belong=" + belong + "]";
		}

	}
}
