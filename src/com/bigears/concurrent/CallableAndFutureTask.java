/*
 * <p>CallableAndFuture.java</p>
 */
package com.bigears.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrent.CallableAndFutureTask
 * @Description: CallableAndFuture
 * @Author : shenyang
 * @Date : 2015年7月20日 下午5:39:36 
 */
public class CallableAndFutureTask {

	public static void main(String[] args) {

		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() {
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		new Thread(futureTask).start();
		try {
			Thread.sleep(5000);
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
