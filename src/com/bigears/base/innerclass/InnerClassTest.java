/*
 * <p>InnerClassTest.java</p>
 */
package com.bigears.base.innerclass;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.innerclass.InnerClassTest
 * @Description: innerClass
 * @Author : shenyang
 * @Date : 2015年12月8日 上午11:09:56
 */
public class InnerClassTest {

	private int num = 0;
	private static int numStatc = 0;

	public void get() {
		System.out.println("InnerClassTest" + num);
	}

	//内部类
	private class InnerClassOne {
		private int i = 0;

		// private static int j = 0;
		// 非静态内部类不能还有静态成员和静态方法
		public void getOutNum() {
			System.out.println(num + i);
			get();
		}

	}

	//静态内部类
	private static class InnerClassTwo {

		private static int j = 0;
		private int k = 0;

		public void getOutNum() {

			// System.out.println(num);
			// get();
			// 静态内部类不能调用外部类的非静态成员和非静态方法
			System.out.println(numStatc + j + k);
		}

	}

	public static void main(String[] args) {

		InnerClassOne one = new InnerClassTest().new InnerClassOne();
		one.getOutNum();
		InnerClassTwo two = new InnerClassTest.InnerClassTwo();
		two.getOutNum();

	}

}
