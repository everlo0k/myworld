/*
 * <p>EnumSetTest.java</p>
 */
package com.bigears.base.collection;

import java.util.EnumSet;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.collection.EnumSetTest
 * @Description: EnumSet的简单测试
 * @Author : shenyang
 * @Date : 2016年6月17日 下午3:40:17
 */
public class EnumSetTest {

	/**
	 * 
	 * @Description: 测试下EnumSet的基本用法，在其内部的如果枚举小于64个，是通过一个long型值的64位来存储枚举 ordianl位为0的，对应放在末位
	 * @MethodName : test
	 * @Author : shenyang
	 * @Date : 2016年6月17日 下午5:47:57
	 */
	public static void test() {
		EnumSet<Color> enumsetAll = EnumSet.allOf(Color.class);
		EnumSet<Color> enumsetNone = EnumSet.noneOf(Color.class);
		EnumSet<Color> enumsetOf = EnumSet.of(Color.GREEN, Color.BLUE);
		enumsetOf.add(Color.RED);
		for (Color c : enumsetAll) {
			System.out.println("name:" + c.name() + " ordianl:" + c.ordinal());
		}
		for (Color c : enumsetNone) {
			System.out.println("name:" + c.name() + " ordianl:" + c.ordinal());
		}
		for (Color c : enumsetOf) {
			System.out.println("name:" + c.name() + " ordianl:" + c.ordinal());
		}
	}

	public static void main(String[] args) {
		EnumSetTest.test();
	}

	public enum Color {
		RED, GREEN, BLUE, YELLOW;
	}

}
