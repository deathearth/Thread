package com.chl.loop;

public class BreakLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		m:for(int i = 0 ; i < 100;i++) {
			n:for(int j = 10 ; j > 0 ; j--) {
				for(int k = 20; k >5 ; k=k-2) {
					
					if(k == j) {
						System.out.println("000 - i -> " + i + " --j -> " + j + " --k - > " + k);
						break n;
					}
					if(k == i) {
						System.out.println("888 - i -> " + i + " --j -> " + j + " --k - > " + k);
						break m;
					}
				}
			}
		}
	}

}
