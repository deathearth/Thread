package com.chl.arthes;

/**
 * 测试arthas的  sc,stack,track,monitor,watch等
 * @author chenhailong
 *
 */
public class TestArthas {

	public static void main(String[] args) {
		TestArthas ta = new TestArthas();
		for(int i = 0; i<1000; i++) {
			ta.first(ta);
			System.out.println("当前第"+i+"次");
		}
	}

	private void first(TestArthas ta) {
		try {
			Thread.sleep(1 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ta.second(ta);
	}
	
	private void second(TestArthas ta) {
		try {
			Thread.sleep(2 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ta.third(ta);
	}
	
	private void third(TestArthas ta) {
		try {
			Thread.sleep(3 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		four(1);
	}
	
	private static void four(int i) {
		try {
			Thread.sleep(4 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
