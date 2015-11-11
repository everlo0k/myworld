/*
 * <p>Vote.java</p>
 */
package com.bigears.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrent.Vote
 * @Description: vote测试
 * @Author : shenyang
 * @Date : 2015年11月11日 上午8:45:25
 */
public class Vote {

	public static int i = 0;
	
	public static int j = 0;

	public static int threadNum = 100;

	public static CountDownLatch cdl = new CountDownLatch(1);
	
	public static CountDownLatch end = new CountDownLatch(threadNum*2);

	public static int add(String name) throws InterruptedException {
		synchronized (name) {
			if ("sy".equals(name)) {
				i++;
				System.out.println("sy " + i);
				return i;
			} else {
				j++;
				System.out.println("zz " + j);
				return j;
			}
		}
	}

	public synchronized static int add1(String name) {
			if ("sy".equals(name)) {
				i++;
				System.out.println("sy " + i);
				return i;
			} else {
				j++;
				System.out.println("zz " + j);
				return j;
			}
	}	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < threadNum; i++) {
			Thread t1 = new Thread() {
				public void run() {
					try {
						cdl.await();
						try {
							add("sy");
						} finally {
							end.countDown();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			Thread t2 = new Thread() {
				public void run() {
					try {
						cdl.await();
						try {
							add("zz");
						} finally {
							end.countDown();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			// t1.start();
			// t2.start();
			executorService.submit(t1);
			executorService.submit(t2);
		}

		System.out.println("start add");
		cdl.countDown();
		long start = System.currentTimeMillis();
		end.await();
		System.out.println("use time :" + (System.currentTimeMillis() - start));
	}

}
