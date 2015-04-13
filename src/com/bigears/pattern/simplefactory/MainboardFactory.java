/*
 * <p>MainboardFactory.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.MainboardFactory
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午11:06:07
 */
public class MainboardFactory {
	
	public static Mainboard createMainboard(int type) {
		Mainboard mainboard = null;
		if (type == 1) {
			mainboard = new IntelMainboard(755);
		} else if (type == 2) {
			mainboard = new AmdMainboard(938);
		}
		return mainboard;
	}
}
