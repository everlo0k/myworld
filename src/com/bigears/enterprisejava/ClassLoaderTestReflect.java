/*
 * <p>ClassLoaderTestReflect.java</p>
 */
package com.bigears.enterprisejava;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Project : myworld
 * @ClassName : com.bigears.enterprisejava.ClassLoaderTestReflect
 * @Description: chapter3-13
 * @Author : shenyang
 * @Date : 2015年9月10日 下午4:38:17
 */
public class ClassLoaderTestReflect {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = cl.loadClass("com.bigears.enterprisejava.ClassLoaderTest");
		ClassLoaderTest clt = (ClassLoaderTest) clazz.newInstance();
		// getDeclaredField是可以获取一个类的所有字段
		// getField只能获取类的public字段
		Field flag = clazz.getDeclaredField("flag");
		// 取消访问检查,使可以访问private变量
		flag.setAccessible(true);
		flag.set(clt, "sy");
		Method method = clazz.getDeclaredMethod("say");
		method.invoke(clt, (Object[]) null);
	}

}
