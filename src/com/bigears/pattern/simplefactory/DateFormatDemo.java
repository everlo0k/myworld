/*
 * <p>DateFormatDemo.java</p>
 */
package com.bigears.pattern.simplefactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.DateFormatDemo
 * @Description: 简单工厂java代码运用实例
 * @Author : shenyang
 * @Date : 2015年3月31日 上午10:39:28
 */
public class DateFormatDemo {

	public static void main(String[] args) {

		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.format(new Date()));

		DateFormat df2 = DateFormat.getDateTimeInstance(3, 3, Locale.FRENCH);
		System.out.println(df2.format(new Date()));

		DateFormat df3 = null;
		for (int i = 0; i < 4; i++) {
			df3 = DateFormat.getDateInstance(i, Locale.CHINA);
			System.out.println(df3.format(new Date()));
		}

		DateFormat df4 = null;
		for (int i = 0; i < 4; i++) {
			df4 = DateFormat.getDateTimeInstance(i, i, Locale.CHINA);
			System.out.println(df4.format(new Date()));
		}

	}

}
