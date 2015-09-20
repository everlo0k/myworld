package com.bigears.lang.reflect.proxy;

import java.lang.reflect.Proxy;

public class StudyTest {

	/**
	 * 代理模式
	 */
	public static void main(String[] args) {
		StudyFacadeImpl sfi = new StudyFacadeImpl();
		StudyProxy sp = new StudyProxy(sfi);
		StudyFacade sf = (StudyFacade) Proxy.newProxyInstance(sfi.getClass().getClassLoader(), sfi.getClass().getInterfaces(), sp);
		sf.doStudy();
	}

}
