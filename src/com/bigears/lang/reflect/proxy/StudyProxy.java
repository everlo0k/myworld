package com.bigears.lang.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudyProxy implements InvocationHandler {
	
	private Object proxy;
	
	public StudyProxy(Object obj) {
		this.proxy = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before study");
		Object result = method.invoke(this.proxy, args);
		System.out.println("after study");
		return result;
	}

}
