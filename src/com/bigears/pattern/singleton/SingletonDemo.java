/*
 * <p>SingletonDemo.java</p>
 */
package com.bigears.pattern.singleton;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.singleton.SingletonDemo
 * @Description: 单例模式
 * @Author : shenyang
 * @Date : 2015年10月21日 上午11:38:56
 */
public class SingletonDemo {

	private SingletonDemo() {
	};

	// 通过静态内部类的方式，来实现单例模式
	private static class SingletonInstance {
		private static final SingletonDemo singleton = new SingletonDemo();
	}

	public static SingletonDemo getSingleton() {
		return SingletonInstance.singleton;
	}
	
}

// 饿汉模式,线程安全
class SingletonOne {
	
	private SingletonOne() {
	};

	private static final SingletonOne singleton = new SingletonOne();

	public static SingletonOne getSingleton() {

		return singleton;
	}

}

// 懒汉模式,非线程安全
class SingletonTwo {

	private SingletonTwo() {
	};

	private static SingletonTwo singleton = null;

	public static SingletonTwo getSingleton() {
		if (singleton == null) {
			singleton = new SingletonTwo();
		}
		return singleton;
	}

}

// 懒汉模式,线程安全
class SingletonThree {

	private SingletonThree() {
	};

	private static SingletonThree singleton = null;

	public static synchronized SingletonThree getSingleton() {
		if (singleton == null) {
			singleton = new SingletonThree();
		}
		return singleton;
	}

}

// 双重校验锁,线程安全
// 这里SingletonFour需要定义成volatile类型，才能保证SingletonFour被安全的发布
class SingletonFour {

	private SingletonFour() {
	};

	private static volatile SingletonFour singleton = null;

	public static SingletonFour getSingleton() {

		if (singleton == null) {
			synchronized (SingletonFour.class) {
				if (singleton == null) {
					singleton = new SingletonFour();
				}
			}
		}
		return singleton;
	}

}
