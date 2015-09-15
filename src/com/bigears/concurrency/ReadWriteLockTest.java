package com.bigears.concurrency;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {

		final Data data = new Data();

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 3; j++) {
						data.set(new Random().nextInt(50));
					}
				}

			}).start();
		}

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 3; j++) {
						data.get();
					}
				}

			}).start();
		}
	}

	static class Data {
		private int data;
		private ReadWriteLock rwl = new ReentrantReadWriteLock();

		// public synchronized void set(int data) {
		public void set(int data) {
			rwl.writeLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + "准备写入数据");
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.data = data;
				System.out.println(Thread.currentThread().getName() + "写入" + this.data);
			} finally {
				rwl.writeLock().unlock();
			}
		}

		// public synchronized void get() {
		public void get() {
			rwl.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + "准备读取数据");
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "读取" + this.data);
			} finally {
				rwl.readLock().unlock();
			}
		}
	}

}
