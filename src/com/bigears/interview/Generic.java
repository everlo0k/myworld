/*
 * <p>Generic.java</p>
 */
package com.bigears.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : myworld
 * @ClassName : com.bigears.interview.Generic
 * @Description: 泛型
 * @Author : shenyang
 * @Date : 2015年9月14日 下午5:14:04
 */
public class Generic {

	// <T>这个表示参数的类型，T表示返回的类型
	public static <T> T test(List<? extends T> list) {
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		System.out.println(test(list));

	}

}
