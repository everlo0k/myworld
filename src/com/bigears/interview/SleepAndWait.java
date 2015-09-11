package com.bigears.interview;

/**
 * 
 * @Project    : myworld
 * @ClassName  : com.bigears.interview.SleepAndWait
 * @Description: sleep方法和wait方法的区别
 * @Author     : shenyang
 * @Date       : 2015年9月11日 上午11:22:52
 */
public class SleepAndWait {

	public static void main(String[] args) {
		System.out.println("lalalala");
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable {

		public void run() {
			synchronized (SleepAndWait.class) {
				System.out.println("Thread1 will be wait");
				try {
					// 调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
					SleepAndWait.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread1 is running again");
				System.out.println("Thread1 is end");
			}
		}

	}

	private static class Thread2 implements Runnable {

		public void run() {
			synchronized (SleepAndWait.class) {
				System.out.println("Thread2 is running");
				// 只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
				SleepAndWait.class.notify();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread2 is end");
			}
		}
	}

}
