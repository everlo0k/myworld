/*
 * <p>Memoizer.java</p>
 */
package com.bigears.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Project : myworld
 * @ClassName : com.bigears.concurrency.Memoizer
 * @Description: FutureTask
 * @Author : shenyang
 * @Date : 2015年7月20日 下午3:14:25
 */
public class Memoizer<A, V> implements Computable<A, V> {
	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
	private final Computable<A, V> c;

	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public V compute(final A key) throws InterruptedException {
		while (true) {
			Future<V> f = cache.get(key);
			if (f == null) {
				Callable<V> computeTask = new Callable<V>() {
					@Override
					public V call() throws Exception {
						return c.compute(key);
					}
				};
				FutureTask<V> ft = new FutureTask<V>(computeTask);
				f = cache.putIfAbsent(key, ft); // 该方法不会对相同key的值进行覆盖，这样避免了相同key的任务被计算
				if (f == null)
					f = ft;
					ft.run(); // 执行计算
			}
			try {
				return f.get(); // 获取计算结果
			} catch (CancellationException e) {
				cache.remove(key); // 计算取消则移除对应的计算任务key
			} catch (ExecutionException e) {
				// do exception handle
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Computable<Integer, String> c = new Computable<Integer, String>(){
			public String compute(Integer integer) throws InterruptedException {
				try{
					Thread.sleep(5000);
				}catch(InterruptedException e){
					e.getStackTrace();
				}
				String result = "由线程：" + Thread.currentThread().getName()+ "计算得到" + integer + "的结果";  
				return result;
			}
		};
		
		final Memoizer<Integer, String> memoizer = new Memoizer<Integer, String>(c); 
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 20; i++) {
			Future<String>  f =  executorService.submit(new Callable<String>(){
				@Override
				public String call() throws Exception {
					return memoizer.compute(new Random().nextInt(3));
				}
			});
			System.out.println(f.get());
		}
		
	}
	
	
	
}
