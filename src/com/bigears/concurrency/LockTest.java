/*
 * <p>LockTest.java</p>
 */
package com.bigears.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrency.LockTest
 * @Description: LockTest
 * @Author : shenyang
 * @Date : 2015年9月11日 下午4:41:24
 */
public class LockTest {

	public static void main(String[] args) {

		final Outputter outputter = new Outputter();
		Thread thread1 = new Thread() {
			public void run() {
				outputter.output("darourou");
				System.out.println("\r");
			}
		};
		thread1.start();
		Thread thread2 = new Thread() {
			public void run() {
				outputter.output("xiaorourou");
				System.out.println("\r");
			}
		};
		thread2.start();

	}

	static class Outputter {
		Lock lock = new ReentrantLock();

		public void output(String name) {
			lock.lock();
			try {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
			} finally {
				lock.unlock();
			}
		}
	}

}
