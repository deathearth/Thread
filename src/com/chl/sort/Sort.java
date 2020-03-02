package com.chl.sort;

import java.util.Arrays;

/**
 * 各种排序的java实现
 * 
 * 
 * 选择排序、快速排序、希尔排序、堆排序不是稳定的排序算法，
 * 冒泡排序、插入排序、归并排序和基数排序是稳定的排序算法。
 * 
 * 排序算法不稳定的含义是:在排序之前,有两个数相等. 但是在排序结束之后,它们两个有可能改变顺序.
 * @author chenhailong
 *
 */
public class Sort {

	public static void main(String[] args) {

		// Bubble();

		 int[] ghost = new int[]{1,4,11,2,33,199,23,421,3,35};
		 Quick_Sort(ghost,0,ghost.length-1);

		// Select_Sort();

		// Insert_Sort_base();
		// Insert_Sort();
		// Insert_Sort_Split();
		// Insert_Shell_Sort();

		// Merge_Sort();

		// Radix_Sort();

		// Heap_Sort();
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 冒泡排序
	//////////////////////////////////////////////////////////////////////////////////////

	// 循环比较
	public static void Bubble() {
		int[] ghost = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };
		for (int i = 0; i < ghost.length; i++) {
			for (int j = ghost.length - 1; j > i; j--) {
				if (ghost[j] < ghost[i]) {
					int temp = ghost[i];
					ghost[i] = ghost[j];
					ghost[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(ghost));
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 快速排序
	//////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 经典快速排序 二分法处理（分两段处理，减少比较次数）
	 */
	public static void Quick_Sort(int s[], int l, int r) {
		int low = l, high = r;
		if (l < r) {
			int temp = s[l];
			while (l < r) {
				while (l < r && temp <= s[r]) { // 从后向前依次判断是否大于temp，如果小于则放到首位
					r--;
				}
				s[l] = s[r];
				while (l < r && temp >= s[l]) { // 从前向后依次判断是否小于temp,如果大于则与之交换
					l++;
				}
				s[r] = s[l];
				s[l] = temp;
				System.out.println(Arrays.toString(s));
				Quick_Sort(s, low, l - 1);
				Quick_Sort(s, l + 1, high);
			}
		}
	}

	/**
	 * jdk1.7开始，Dual-pivot(先判断是否满足条件，插入排序，快速排序，归并排序等，最后双基准快排)
	 * http://www.west999.com/info/html/chengxusheji/Javajishu/20180802/4417089.html
	 * 
	 */
	// public static void Dual_Pivot_Sort(A,left,right) {
	//
	// }

	//////////////////////////////////////////////////////////////////////////////////////
	// 选择排序
	//////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 选择排序法 第一次选择最小的放在第一位，第二次选择第二小的...
	 */
	public static void Select_Sort() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };
		for (int i = 0; i < g.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < g.length; j++) {
				if (g[min] > g[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = g[min];
				g[min] = g[i];
				g[i] = temp;
			}
		}
		System.out.println(Arrays.toString(g));
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 插入排序 直接插入，二分插入、Shell排序(希尔排序)
	//////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 一、基本插入排序，认为数组已经有序，通过比较将数组插入对应位置
	 */
	public static void Insert_Sort_base() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };

		for (int i = 1; i < g.length; i++) {
			for (int j = i; j > 0 && g[j] < g[j - 1]; j--) {
				int temp = g[j - 1];
				g[j - 1] = g[j];
				g[j] = temp;
			}
		}

		System.out.println(Arrays.toString(g));
	}

	/**
	 * 二、改进版插入排序
	 */
	public static void Insert_Sort() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };

		for (int i = 1; i < g.length; i++) {
			int temp = g[i];
			int j;

			for (j = i; (j > 0) && (temp < g[j - 1]); j--) {
				g[j] = g[j - 1];
			}
			g[j] = temp;
		}

		System.out.println(Arrays.toString(g));
	}

	/**
	 * 三、二分插入排序
	 */
	public static void Insert_Sort_Split() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };
		for (int i = 1; i < g.length; i++) {

			int temp = g[i];
			int low = 0, high = i - 1;
			int mid = 0;
			System.out.println("low == " + low + " high ==" + high + "【before】");
			while (low <= high) {

				mid = low + (high - low) / 2; // 找到之前的数组的中间位置
				if (g[mid] > temp) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
				System.out.println("low == " + low + " high ==" + high);
			}

			for (int j = i - 1; j > low; j--) {
				g[j + 1] = g[j];
			}
			g[low] = temp;
			System.out.println(Arrays.toString(g));
		}
	}

	/**
	 * 希尔排序
	 */
	public static void Insert_Shell_Sort() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };

		int gap = g.length;
		while (true) {
			gap /= 2; // 等同于 a = (int)(a / b);
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < g.length; j += gap) {// 这个循环里其实就是一个插入排序
					int temp = g[j];
					int k = j - gap;
					while (k >= 0 && g[k] > temp) {
						g[k + gap] = g[k];
						k -= gap;
					}
					g[k + gap] = temp;
				}
			}
			if (gap == 1) {
				break;
			}
		}
		System.out.println(Arrays.toString(g));
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 归并排序
	//////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 归并排序，分而治之
	 */
	public static void Merge_Sort() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };
		int[] temp = new int[g.length];// 创建一个零时数组，避免递归频繁开辟空间
		Merge_first(g, 0, g.length - 1, temp);
		System.out.println(Arrays.toString(g));
	}

	/**
	 * 归并第一块,分的过程
	 * 
	 * @param g
	 *            元素组
	 * @param left
	 *            分段左索引
	 * @param right
	 *            分段右索引
	 * @param temp
	 *            新素组
	 */
	private static void Merge_first(int[] g, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			Merge_first(g, left, mid, temp);
			Merge_first(g, mid + 1, right, temp);
			Merge_second(g, left, mid, right, temp);
		}
	}

	/**
	 * 归并第二块，迁移过程
	 */
	private static void Merge_second(int[] g, int left, int mid, int right, int[] temp) {
		int i = left; // 左序列指针
		int j = mid + 1; // 有序列指针
		int t = 0; // 临时数组指针
		while (i <= mid && j <= right) { // 索引位于两端之间
			if (g[i] <= g[j]) {
				temp[t++] = g[i++];
			} else {
				temp[t++] = g[j++];
			}
		}
		while (i <= mid) { // 左边剩余元素填入temp中
			temp[t++] = g[i++];
		}
		while (j <= right) { // 右边剩余元素填入temp中
			temp[t++] = g[j++];
		}
		t = 0;
		while (left <= right) { // 填入原数组
			g[left++] = temp[t++];
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 基数排序
	//////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 基数排序
	 */
	public static void Radix_Sort() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };
		int d = 3; // d表示最大的数有多少位
		int k = 0;
		int n = 1;
		int m = 1; // 控制键值排序依据在哪一位
		int[][] temp = new int[10][g.length]; // 数组的第一维表示可能的余数0-9
		int[] order = new int[10]; // 数组orderp[i]用来表示该位是i的数的个数
		while (m <= d) {
			for (int i = 0; i < g.length; i++) {
				int lsd = ((g[i] / n) % 10);
				temp[lsd][order[lsd]] = g[i];
				order[lsd]++;
			}
			for (int i = 0; i < 10; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						g[k] = temp[i][j];
						k++;
					}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}

		System.out.println(Arrays.toString(g));
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// 堆排序
	//////////////////////////////////////////////////////////////////////////////////////

	public static void Heap_Sort() {
		int[] g = new int[] { 1, 4, 11, 2, 33, 199, 23, 421, 3, 35 };
		for (int i = g.length / 2 - 1; i >= 0; i--) {
			adjustHeap(g, i, g.length); // 调整堆
		}

		// 上述逻辑，建堆结束
		// 下面，开始排序逻辑
		for (int j = g.length - 1; j > 0; j--) {
			// 元素交换,作用是去掉大顶堆
			// 把大顶堆的根元素，放到数组的最后；换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
			swap(g, 0, j);
			// 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
			// 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
			// 而这里，实质上是自上而下，自左向右进行调整的
			adjustHeap(g, 0, j);
		}
		System.out.println(Arrays.toString(g));
	}

	/**
	 * 整个堆排序最关键的地方
	 * 
	 * @param array
	 *            待组堆
	 * @param i
	 *            起始结点
	 * @param length
	 *            堆的长度
	 */
	public static void adjustHeap(int[] array, int i, int length) {
		// 先把当前元素取出来，因为当前元素可能要一直移动
		int temp = array[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) { // 2*i+1为左子树i的左子树(因为i是从0开始的),2*k+1为k的左子树
			// 让k先指向子节点中最大的节点
			if (k + 1 < length && array[k] < array[k + 1]) { // 如果有右子树,并且右子树大于左子树
				k++;
			}
			// 如果发现结点(左右子结点)大于根结点，则进行值的交换
			if (array[k] > temp) {
				swap(array, i, k);
				// 如果子节点更换了，那么，以子节点为根的子树会受到影响,所以，循环对子节点所在的树继续进行判断
				i = k;
			} else { // 不用交换，直接终止循环
				break;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
