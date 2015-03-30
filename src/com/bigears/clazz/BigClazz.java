/*
 * <p>BigClazz.java</p>
 */
package com.bigears.clazz;

/**
 * @Project : myworld
 * @ClassName : com.bigears.clazz.BigClazz
 * @Description: class测试
 * @Author : bigears
 * @Date : 2015年3月10日 下午3:56:19
 */
public class BigClazz {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		String s = "aaa";
		Class cls1 = s.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		if (cls1 == cls2) {
			System.out.println("cls1 == cls2");
		}
		if (cls2 == cls3) {
			System.out.println("cls2 == cls3");
		}
	}

}
