/*
 * <p>ArraySorts.java</p>
 */
package com.bigears.algorithm;

import java.util.Random;

/**
 * @Project : myworld
 * @ClassName : com.bigears.algorithm.ArraySorts
 * @Description: 排序算法
 * @Author : shenyang
 * @Date : 2015年10月15日 下午1:22:10
 */
public class ArraySorts {

	/**
	 * 
	 * @Description: 冒泡排序
	 * @MethodName : bubbleSort
	 * @Author : shenyang
	 * @Date : 2015年10月15日 下午2:24:45
	 * @param numbers
	 */
	public static void bubbleSort(int[] numbers) {
		int size = numbers.length;
		int temp = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] > numbers[j]) {
					temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
	}

	/**
	 * 
	 * @Description: 选择排序
	 * @MethodName : selectSort
	 * @Author : shenyang
	 * @Date : 2015年10月15日 下午4:14:28
	 * @param numbers
	 */
	public static void selectSort(int[] numbers) {
		// 在未排序序列中找到最小元素，存放到排序序列的起始位置;
		// 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾;
		// 以此类推，直到所有元素均排序完毕;
		int size = numbers.length;
		int temp = 0;
		for (int i = 0; i < size; i++) {
			int k = i;
			for (int j = size - 1; j > i; j--) {
				if (numbers[j] < numbers[k]) {
					k = j;
				}
			}
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
		}
	}

	/**
	 * 
	 * @Description: 插入排序
	 * @MethodName : insertSort
	 * @Author : shenyang
	 * @Date : 2015年10月15日 下午5:50:50
	 * @param numbers
	 */
	public static void insertSort(int[] numbers) {
		// 从第一个元素开始，该元素可以认为已经被排序
		// 取出下一个元素，在已经排序的元素序列中从后向前扫描
		// 如果该元素（已排序）大于新元素，将该元素移到下一位置
		// 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
		// 将新元素插入到该位置中
		// 重复步骤2
		int size = numbers.length;
		int temp, j = 0;
		for (int i = 1; i < size; i++) {
			temp = numbers[i];
			for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = temp;
		}
	}

	/**
	 * 
	 * @Description: 快速排序,这个方法比较好，不会报栈溢出的错误
	 * @MethodName : quickSortOne
	 * @Author : shenyang
	 * @Date : 2015年10月16日 下午3:15:01
	 * @param numbers
	 * @param start
	 * @param end
	 */
	public static void quickSortOne(int[] numbers, int start, int end) {
		if (start < end) {
			int base = numbers[start];
			int i = start, j = end, temp;
			boolean flag = true;
			do {
				while (numbers[j] > base && (j > start)) {
					j--;
				}
				while (numbers[i] < base && (i < end)) {
					i++;
				}
				if (i <= j) {
					temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
					flag = !flag;
					if (flag) {
						j--;
					} else {
						i++;
					}
				}
			} while (i <= j);
			if (start < j) {
				quickSortOne(numbers, start, j);
			}
			if (end > i) {
				quickSortOne(numbers, i, end);
			}
		}
	}

	/**
	 * 
	 * @Description: 快速排序
	 * @MethodName : quickSortTwo
	 * @Author : shenyang
	 * @Date : 2015年10月16日 下午3:15:15
	 * @param numbers
	 * @param start
	 * @param end
	 */
	public static void quickSortTwo(int[] numbers, int start, int end) {
		// 1设置两个变量i、j,排序开始的时候i=start，j=end
		// 2以第一个数组元素作为关键数据,赋值给X
		// 3从j开始向前搜索,即由后开始向前搜索(j=j-1),找到第一个小于X的值，两者交换
		// 4从i开始向后搜索,即由前开始向后搜索(i=i+1),找到第一个大于X的值，两者交换
		// 5重复第3、4步，直到i=j

		if (start < end) {
			int i = start, j = end, temp;
			boolean flag = true;
			while (i < j) {
				if (numbers[i] > numbers[j]) {
					temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
					flag = !flag;
				}
				if (flag) {
					j--;
				} else {
					i++;
				}
			}
			i--;
			j++;
			quickSortTwo(numbers, start, i);
			quickSortTwo(numbers, j, end);
		}
	}

	public static void main(String[] args) {
		// int[] numbers = {5,7,1,4,6 };
		// insertSort(numbers);
		// quickSortTwo(numbers,0,4);
		// String s = Arrays.toString(numbers);
		// System.out.println(s);

		int size = 100000;
		int[] test1 = new int[size];
		int[] test2 = new int[size];
		int[] test3 = new int[size];
		int[] test4 = new int[size];
		int[] test5 = new int[size];

		Random r = new Random();
		for (int i = 0; i < size; i++) {
			test1[i] = r.nextInt(size);
		}
		System.arraycopy(test1, 0, test2, 0, 10000);
		System.arraycopy(test1, 0, test3, 0, 10000);
		System.arraycopy(test1, 0, test4, 0, 10000);
		System.arraycopy(test1, 0, test5, 0, 10000);

		long time1 = System.currentTimeMillis();
		bubbleSort(test1);
		System.out.println("bubbleSort total cost:" + (System.currentTimeMillis() - time1));

		long time2 = System.currentTimeMillis();
		selectSort(test2);
		System.out.println("selectSort total cost:" + (System.currentTimeMillis() - time2));

		long time3 = System.currentTimeMillis();
		insertSort(test3);
		System.out.println("insertSort total cost:" + (System.currentTimeMillis() - time3));

		long time4 = System.currentTimeMillis();
		quickSortOne(test4, 0, size - 1);
		System.out.println("quickSortOne total cost:" + (System.currentTimeMillis() - time4));

		// long time5 = System.currentTimeMillis();
		// quickSort(test5,0,size-1);
		// System.out.println("quickSortTwo total cost:" + (System.currentTimeMillis() - time5));

	}

}
