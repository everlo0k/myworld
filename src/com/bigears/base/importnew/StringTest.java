/*
 * <p>StringTest.java</p>
 */
package com.bigears.base.importnew;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.importnew.StringTest
 * @Description: String的一些测试
 * @Author : shenyang
 * @Date : 2015年11月20日 上午9:55:08
 */
public class StringTest {

	public static void test() {
		final String mm = "hello,world";
		String nn = mm + ".";
		String uu = "hello,world.";
		System.out.println(nn == uu);// true
		String vv = mm.concat(".");
		System.out.println(vv == uu);// false
	}

	public static void main(String[] args) {
		test();
	}

}
