/*
 * <p>SemaphoreTest.java</p>
 */
package com.bigears.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrency.SemaphoreTest
 * @Description: 信号量
 * @Author : shenyang
 * @Date : 2015年7月20日 下午3:07:23
 */
public class SemaphoreTest<T> {
	private final Set<T> set;

	private final Semaphore sema;

	public SemaphoreTest(int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		this.sema = new Semaphore(bound);
	}

	public boolean add(T o) throws InterruptedException {
		sema.acquire();
		boolean wasAdded = false;
		try {
			wasAdded = set.add(o);
			return wasAdded;
		} finally {
			if (!wasAdded) {
				sema.release();
			}
		}
	}

	public boolean remove(T o) {
		boolean wasRemoved = set.remove(o);
		if (wasRemoved) {
			sema.release();
		}
		return wasRemoved;
	}

	public static void main(String[] args) throws InterruptedException {
		int permits = 5;
		int elements = permits + 1;
		SemaphoreTest<Integer> test = new SemaphoreTest<Integer>(permits);
		for (int i = 0; i < elements; i++) {
			test.add(i);
		}
	}
}
