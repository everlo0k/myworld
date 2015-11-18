/*
 * <p>ThreeItemOperation.java</p>
 */
package com.bigears.base.importnew;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.importnew.ThreeItemOperation
 * @Description: 三目运算
 * @Author : shenyang
 * @Date : 2015年11月18日 上午8:37:42
 */
public class ThreeItemOperation {

	public static void testOne() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		Boolean b = map != null ? map.get("test") : false;
		// 编译器编译以后就变成这样了
		// Boolean b = Boolean.valueOf(map != null ? ((Boolean)map.get("test")).booleanValue() : false);
		// 1.如果第二和第三操作数有相同的类型(可能是null type),那么表达式的类型就是该类型
		// 2.如果第二和第三操作数其中一个是原始类型，另一个是包装类型，那么包装类型会拆箱为基本类型。
		// 3.如果第二和第三操作数其中一个是null type，另一个是引用类型，那么表达式的类型是引用类型。

		System.out.println(b);
	}
	
	public static void testTwo() {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		// 这样就不会有错误咧
		Boolean b = map != null ? map.get("test") : Boolean.FALSE;
		System.out.println(b);
	}	
	
	public static void main(String[] args) {

		testTwo();

	}

}
