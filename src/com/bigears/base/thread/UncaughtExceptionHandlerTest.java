/*
 * <p>UncaughtExceptionHandlerTest.java</p>
 */
package com.bigears.base.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.thread.UncaughtExceptionHandlerTest
 * @Description: UncaughtExceptionHandler测试
 * @Author : shenyang
 * @Date : 2016年5月26日 上午11:45:27
 */
public class UncaughtExceptionHandlerTest {

	/**
	 * 
	 * @Description: 在主线程中直接捕获子线程的异常是捕获不到的
	 * @MethodName : testOne
	 * @Author     : shenyang
	 * @Date       : 2016年5月26日 下午1:42:49
	 */
	private static void testOne() {
		Thread thread = null;
		try {
			thread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 5; i++) {
						if (i == 0) {
							throw new RuntimeException();
						}
						System.out.println(i);
					}
				}
			});
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: 通过设置setUncaughtExceptionHandler，来捕获异常
	 * @MethodName : testTwo
	 * @Author     : shenyang
	 * @Date       : 2016年5月26日 下午1:41:21
	 */
	private static void testTwo() {
		Thread thread = null;
		try {
			thread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 5; i++) {
						if (i == 0) {
							throw new RuntimeException("error");
						}
						System.out.println(i);
					}
				}
			});
			thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					System.out.println("Thread:" + t.getName() + "," + e.getMessage());
				}

			});
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UncaughtExceptionHandlerTest.testOne();
		UncaughtExceptionHandlerTest.testTwo();
	}

}
