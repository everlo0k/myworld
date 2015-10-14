/*
 * <p>EventListenerDemo.java</p>
 */
package com.bigears.pattern.observer;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.observer.EventListenerDemo
 * @Description: java事件监听器
 * @Author : shenyang
 * @Date : 2015年10月14日 下午3:34:02
 */
public class EventListenerDemo {
	public static void main(String[] args) {
		new EventPublisher().publishEvent(new MyEvent("ok", "main"));
	}
}

// 事件,在事件源和事件监听器之间传递信息的对象实体
class MyEvent extends EventObject {

	private static final long serialVersionUID = 2996401859764441463L;
	private String name;

	public MyEvent(Object source) {
		super(source);
	}

	public MyEvent(Object source, String name) {
		super(source);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

interface IMyEventListener extends EventListener {

	void execute(EventObject event);

}

// 监听器,监听事件,并进行事件处理或转发的对象
class MyEventListener implements IMyEventListener {

	@Override
	public void execute(EventObject event) {
		if (event instanceof MyEvent) {
			System.out.println("do my event,name:" + ((MyEvent) event).getName());
		}

	}

}

// 发布者,在事件发生后,负责把事件发布到监听者的对象
class EventPublisher {

	private MyEventListener myEventListener = new MyEventListener();

	public void publishEvent(EventObject event) {
		myEventListener.execute(event);
	}

}
