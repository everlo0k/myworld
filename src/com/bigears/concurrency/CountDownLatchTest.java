/*
 * <p>CountDownLatchTest.java</p>
 */
package com.bigears.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrency.CountDownLatchTest
 * @Description: 闭锁
 * @Author : shenyang
 * @Date : 2015年7月20日 下午2:05:10
 */
public class CountDownLatchTest {
	public void timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						// 阻塞等待
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) {

					}

				}
			};
			t.start();
		}

		long start = System.nanoTime();
		System.out.println("打开闭锁");
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		System.out.println("闭锁退出，共耗时" + (end - start));
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatchTest test = new CountDownLatchTest();
		test.timeTasks(5, test.new RunnableTask());
	}

	class RunnableTask implements Runnable {

		@Override
		public void run() {
			System.out.println("当前线程为：" + Thread.currentThread().getName());

		}
	}
}