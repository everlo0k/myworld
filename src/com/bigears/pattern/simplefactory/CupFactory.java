/*
 * <p>CupFactory.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.CupFactory
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午11:03:27
 */
public class CupFactory {

	public static Cpu createCpu(int type) {
		Cpu cpu = null;
		if (type == 1) {
			cpu = new IntelCpu(755);
		} else if (type == 2) {
			cpu = new AmdCpu(938);
		}
		return cpu;
	}

}
