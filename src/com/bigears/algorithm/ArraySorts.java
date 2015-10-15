/*
 * <p>ArraySorts.java</p>
 */
package com.bigears.algorithm;

import java.util.Arrays;

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
		long time = System.currentTimeMillis();
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
		System.out.println("total cost:" + (System.currentTimeMillis() - time));
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

	public static void main(String[] args) {
		int[] numbers = { 12, 7, 43, 455, 4, 34, 22, 1, 456 };
		insertSort(numbers);
		String s = Arrays.toString(numbers);
		System.out.println(s);

	}

}
