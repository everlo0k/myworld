/*
 * <p>Fibonacci.java</p>
 */
package com.bigears.algorithm;

/**
 * @Project : myworld
 * @ClassName : com.bigears.algorithm.Fibonacci
 * @Description: java实现斐波拉契数列，返回第n个数
 * @Author : shenyang
 * @Date : 2015年10月27日 下午3:20:07
 */
public class Fibonacci {

	public static int getFibonacci(int num) {
		if (num <= 1) {
			return 0;
		}
		if (num == 2) {
			return 1;
		}
		return getFibonacci(num - 2) + getFibonacci(num - 1);

	}

	public static void main(String[] args) {
		System.out.println(getFibonacci(8));

	}

}
