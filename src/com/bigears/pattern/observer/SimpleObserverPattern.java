/*
 * <p>SimpleObserverPattern.java</p>
 */
package com.bigears.pattern.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.observer.SimpleObserverPattern
 * @Description: 观察者模式中用到了回调: A. 观察者将自己注册到被观察者的监听者列表，且观察者类自身提供了一个回调函数 B. 被观察者（Observable或Subject）维护观察者列表，并且可以注册和解注册观察者 C.
 *               一旦被观察者状态发生改变，它可以调用notifyObservers()，这个方法将遍历观察者列表并逐个调用观察者提供的回调函数
 * @Author : shenyang
 * @Date : 2015年10月14日 下午1:34:28
 */
public class SimpleObserverPattern {

	public static void main(String[] args) {
		SimpleObserverPattern sop = new SimpleObserverPattern();
		Observable observable = sop.new Observable();
		Observer observer = sop.new Observer("ever");
		observable.registerObserver(observer);
		observable.change();
	}

	interface IObservable {
		void registerObserver(Observer observer);

		void unRregisterObserver(Observer observer);

		void change();

		void close();

		void notifyObserver();

		String getState();
	}

	class Observable implements IObservable {

		private static final String NEW = "new";
		private static final String CHANGED = "changed";
		private static final String CLOSED = "closed";

		private String state;
		private List<Observer> listObserver;

		public Observable() {
			this(null);
		}

		public Observable(List<Observer> list) {
			if (list == null) {
				list = new ArrayList<Observer>();
			}
			listObserver = Collections.synchronizedList(list);
			this.state = NEW;
		}

		@Override
		public void registerObserver(Observer observer) {
			listObserver.add(observer);
		}

		@Override
		public void unRregisterObserver(Observer observer) {
			listObserver.remove(observer);
		}

		@Override
		public void change() {
			state = CHANGED;
			notifyObserver();
		}

		@Override
		public void close() {
			state = CLOSED;
			notifyObserver();
		}

		@Override
		public void notifyObserver() {
			Iterator<Observer> it = listObserver.iterator();
			while (it.hasNext()) {
				it.next().update(this);
			}
		}

		@Override
		public String getState() {
			return state;
		}

	}

	interface IObserver {
		void update(IObservable observalbe);
	}

	class Observer implements IObserver {

		private String name;

		public Observer(String name) {
			this.name = name;
		}

		public void update(IObservable observable) {
			System.out.println("observable name:" + name + ",state:" + observable.getState());
		}

	}

}
