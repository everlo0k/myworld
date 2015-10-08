/*
 * <p>Storage.java</p>
 */
package com.bigears.pattern.producerconsumer;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.producerconsumer.Storage
 * @Description:  生产者和消费者模式，通过synchronized实现
 * @Author : shenyang
 * @Date : 2015年10月8日 下午4:52:49
 */
public class Storage {

	private int num = 0;

	private final int MAX = 15;

	public void enter(int i) {

		synchronized (this) {
			try {
				while (num + i > MAX) {
					System.out.println("仓库的空间不够啦,需要" + i + "个位置,目前只有" + (MAX - num) + "个位置");
					this.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num = num + i;
			System.out.println("入库" + i + "个,当前库存：" + num);
			this.notify();
		}
	}

	public void out(int i) {

		synchronized (this) {
			try {
				while (num - i < 0) {
					System.out.println("仓库的库存不够啦需要" + i + "个库存,目前只有" + num + "个库存");
					this.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num = num - i;
			System.out.println("出库" + i + "个,当前库存：" + num);
			this.notify();
		}
	}

	public static void main(String[] args) {

		Storage s = new Storage();
		for (int i = 0; i < 14; i++) {
			new Thread(new StorageEnterTask(s, i + 1)).start();
		}
		for (int i = 0; i < 14; i++) {
			new Thread(new StorageOutTask(s, i + 1)).start();
		}

	}

}

class StorageEnterTask implements Runnable {

	private Storage storage;

	private int num;

	public StorageEnterTask(Storage storage, int num) {
		this.storage = storage;
		this.num = num;
	}

	public void run() {
		storage.enter(num);
	}

}

class StorageOutTask implements Runnable {

	private Storage storage;

	private int num;

	public StorageOutTask(Storage storage, int num) {
		this.storage = storage;
		this.num = num;
	}

	public void run() {
		storage.out(num);
	}

}
