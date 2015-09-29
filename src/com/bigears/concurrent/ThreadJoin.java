/*
 * <p>ThreadJoin.java</p>
 */
package com.bigears.concurrent;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.concurrent.ThreadJoin 
 * @Description: join的用法
 * @Author     : shenyang
 * @Date  	   : 2015年9月29日 上午11:30:10 
 */
public class ThreadJoin {

	static class JoinThread implements Runnable{
		public void run(){
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=0 ;i<5;i++){
			Thread thread = new Thread(new JoinThread());
			thread.start();
			thread.join();
		}
		System.out.println("等待所有子线程都执行完咧,这里执行输出~");
	}

}
