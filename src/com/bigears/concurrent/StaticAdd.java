/*
 * <p>StaticAdd.java</p>
 */
package com.bigears.concurrent;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrent.StaticAdd
 * @Description: 证明了下静态变量、静态方法哇都和线程安全没啥关系 
 * @Author : shenyang
 * @Date : 2015年9月28日 下午5:56:08
 */
public class StaticAdd implements Runnable {

	private static int i = 0;

	public void run() {
		i++;
		System.out.println(Thread.currentThread().getName() + " i=" + i);

	}

	public static int add() {
		i++;
		return i;
	}

	public static void main(String[] args) {

		StaticAdd sa = new StaticAdd();
		for (int i = 0; i < 100; i++) {
			new Thread(sa).start();
		}

	}

}
