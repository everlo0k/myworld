/*
 * <p>BlockingQueueStorage.java</p>
 */
package com.bigears.pattern.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.producerconsumer.BlockingQueueStorage
 * @Description: 生产者消费者模式，通过BlockingQueue实现
 * @Author : shenyang
 * @Date : 2015年10月8日 下午5:41:35
 */
public class BlockingQueueStorage {

	private final int MAX = 5;

	private BlockingQueue<Object> bq = new LinkedBlockingQueue<Object>(MAX);

	public static void main(String[] args) {
		BlockingQueueStorage bqs = new BlockingQueueStorage();
		new Thread(new Producer(bqs.bq, 5)).start();
		new Thread(new Producer(bqs.bq, 10)).start();
		new Thread(new Customer(bqs.bq, 5)).start();
	}

}

class Producer implements Runnable {

	private BlockingQueue<Object> bq = new LinkedBlockingQueue<Object>();

	private int time;

	public Producer(BlockingQueue<Object> bq, int time) {
		this.bq = bq;
		this.time = time;
	}

	public void run() {

		while (!Thread.interrupted()) {
			try {
				bq.put(new Object());
				System.out.println(Thread.currentThread().getName() + " " + bq.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Customer implements Runnable {

	private BlockingQueue<Object> bq = new LinkedBlockingQueue<Object>();

	private int time;

	public Customer(BlockingQueue<Object> bq, int time) {
		this.bq = bq;
		this.time = time;
	}

	public void run() {

		while (!Thread.interrupted()) {
			try {
				bq.take();
				System.out.println(Thread.currentThread().getName() + " " + bq.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
