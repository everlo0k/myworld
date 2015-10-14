/*
 * <p>JDKObserverDemo.java</p>
 */
package com.bigears.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.observer.JDKObserverDemo
 * @Description: 使用java.util包中的标准类实现观察者模式
 * @Author : shenyang
 * @Date : 2015年10月14日 上午10:38:49
 */
public class JDKObserverDemo {

	public static void main(String[] args) {
		JDKObserverDemo jod = new JDKObserverDemo();
		String value = "ever";
		MyObservable myobservable = jod.new MyObservable(value);
		MyObserver myobserver = jod.new MyObserver();
		myobservable.addObserver(myobserver);
		myobservable.setValue(value);
		myobservable.setValue("look");
	}

	// 被观察者
	class MyObservable extends Observable {

		private String value;

		public MyObservable(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			if (this.value != value) {
				this.value = value;
				setChanged();
			}
			// 只有在setChanged()被掉用以后,调用该方法才会触发观察者的update方法
			notifyObservers(value);
		}

		public String toString() {
			return "MyObservable&" + value;
		}

	}

	// 观察者
	class MyObserver implements Observer {

		public void update(Observable observable, Object object) {
			System.out.println(observable);
			System.out.println(object);
		}

	}

}
