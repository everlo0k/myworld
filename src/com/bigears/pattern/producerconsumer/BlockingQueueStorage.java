/*
 * <p>BlockingQueueStorage.java</p>
 */
package com.bigears.pattern.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.producerconsumer.BlockingQueueStorage
 * @Description: TODO
 * @Author     : shenyang
 * @Date  	   : 2015年10月8日 下午5:41:35 
 */
public class BlockingQueueStorage {

	private final int MAX = 15;
	
	BlockingQueue<Object> bq = new LinkedBlockingQueue<Object>(MAX);
	
	public void enter(int i) {

		for (int num = 1; num < i; num++) {
			try {
				bq.put(new Object());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
}
