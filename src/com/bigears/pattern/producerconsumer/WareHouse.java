/*
 * <p>WareHouse.java</p>
 */
package com.bigears.pattern.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.producerconsumer.WareHouse
 * @Description: 生产者和消费者模式，通过ReentrantLock实现
 * @Author : shenyang
 * @Date : 2015年10月8日 上午11:43:51
 */
public class WareHouse {

	private int num = 0;

	private final int MAX = 15;

	private Lock lock = new ReentrantLock();

	private Condition empty = lock.newCondition();

	private Condition full = lock.newCondition();

	public void enter(int i) {

		lock.lock();
		try {
			while (num + i > MAX) {
				System.out.println("仓库的空间不够啦,需要" + i + "个位置,目前只有" + (MAX - num) + "个位置");
				full.await();
			}
			num = num + i;
			System.out.println("入库" + i + "个,当前库存：" + num);
			empty.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void out(int i) {

		lock.lock();
		try {
			while (num - i < 0) {
				System.out.println("仓库的库存不够啦需要" + i + "个库存,目前只有" + num + "个库存");
				empty.await();
			}
			num = num - i;
			System.out.println("出库" + i + "个,当前库存：" + num);
			full.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WareHouse wareHouse = new WareHouse();
		for (int i = 0; i < 14; i++) {
			Thread t = new Thread(new EnterTask(wareHouse, i+1));
			t.start();
		}
		for (int i = 0; i < 14; i++) {
			Thread t = new Thread(new OutTask(wareHouse, i+1));
			t.start();
		}

	}

}

class EnterTask implements Runnable {

	private WareHouse wareHouse;

	private int num;

	public EnterTask(WareHouse wareHouse, int num) {
		this.wareHouse = wareHouse;
		this.num = num;
	}

	public void run() {
		wareHouse.enter(num);
	}
}

class OutTask implements Runnable {

	private WareHouse wareHouse;

	private int num;

	public OutTask(WareHouse wareHouse, int num) {
		this.wareHouse = wareHouse;
		this.num = num;
	}

	public void run() {
		wareHouse.out(num);
	}
}
