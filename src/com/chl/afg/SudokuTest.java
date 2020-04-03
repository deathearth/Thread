package com.chl.afg;

import java.util.HashSet;
import java.util.Set;

/**
 * 验证数独的数据正确性
 * @author chenhailong
 *
 */
public class SudokuTest {

	public static void main(String[] args) {
//		//这是原始正确的数组
//		int[][] v = new int[][] {
//			{4,5,3,8,1,6,9,2,7},
//			{8,2,1,9,4,7,5,6,3},
//			{7,6,9,3,2,5,4,1,8},
//			
//			{2,4,8,7,6,3,1,5,9},
//			{1,3,7,5,9,4,2,8,6},
//			{6,9,5,1,8,2,3,7,4},
//			
//			{5,8,2,4,7,9,6,3,1},
//			{9,1,6,2,3,8,7,4,5},
//			{3,7,4,6,5,1,8,9,2},
//		};
//		validate(v);
		
		
		
		//这是原始正确的数组
		int[][] v = new int[][] {
			{4,5,3,8,1,6,9,2,7},
			{8,2,1,9,4,7,5,6,3},
			{7,6,9,3,2,5,4,1,8},
			
			{2,4,8,7,6,1,3,5,9},
			{1,3,7,5,9,4,2,8,6},
			{6,9,5,1,8,2,3,7,4},
			
			{5,8,2,4,7,9,6,1,3},
			{9,1,6,2,3,8,7,4,5},
			{3,7,4,6,5,3,8,9,2},
		};
		validate(v);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void validate(int[][] sz) {
		boolean b = true;
		Set h = new HashSet();
		Set v = new HashSet();
		
		for(int i = 0;i < 9;i++) {
			for(int j = 0; j < 9;j++) {
				h.add(sz[i][j]);
				v.add(sz[j][i]);
			}
			if(h.size() < 9) {
				System.out.println("第"+(i+1)+"行有重复数据!");b=false;break;
			}
			if(v.size() < 9) {
				System.out.println("第"+(i+1)+"列有重复数据!");b=false;break;
			}
			h = new HashSet();v = new HashSet();
		}
		
		if(b) {
			for(int s = 0; s < 3 ; s++) { // 针对于列 
				for(int i = 0;i < 3; i++) { //针对于行
					for(int j = i*3; j< (i+1)*3 ; j++ ) { //跟着行走 
						for(int k = s * 3; k < (s+1)*3 ; k++) {  //跟着列走
							h.add(sz[j][k]);
						}
					}
					if(h.size() <9 ) {
						System.out.println("第"+(1+i)+"行，第"+(s+1)+"列的九宫格有问题!");
					}
				}
			}
			System.out.println("这是正确的");
		}
		
	}

}
