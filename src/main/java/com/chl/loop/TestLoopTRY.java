package com.chl.loop;

public class TestLoopTRY {

	public static void main(String[] args) {

		for(;;) {
			
			try {
				if(1==1) {
					System.out.println("222");
					Thread.sleep( 1 * 1000);
					continue;
				}
			}catch(Exception e) {
				
			}finally {
				System.out.println("123");
			}
			
			
		}
		
		
	}

}
