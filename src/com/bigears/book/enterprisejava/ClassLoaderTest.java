/*
 * <p>ClassLoaderTest.java</p>
 */
package com.bigears.book.enterprisejava;

/**
 * @Project : myworld
 * @ClassName : com.bigears.enterprisejava.ClassLoaderTest
 * @Description: chapter3-11,ClassLoader
 * @Author : shenyang
 * @Date : 2015年9月10日 下午3:27:05
 */
public class ClassLoaderTest {

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void say() {
		System.out.println("say hello," + flag);
	}

	public static void main(String[] args) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		System.out.println("currnet classLoader:" + cl.toString());
		System.out.println("parent classLoader:" + cl.getParent().toString());
		System.out.println("grandparent classLoader:" + cl.getParent().getParent());
	}

}
