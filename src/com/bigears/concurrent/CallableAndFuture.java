/*
 * <p>CallableAndFuture.java</p>
 */
package com.bigears.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.concurrent.CallableAndFuture
 * @Description: CallableAndFuture
 * @Author     : shenyang
 * @Date  	   : 2015年7月21日 上午11:28:57 
 */
public class CallableAndFuture {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<Integer> future = executorService.submit(new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		});
		try {
			Thread.sleep(5000);
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
