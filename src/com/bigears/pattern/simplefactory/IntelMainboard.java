/*
 * <p>IntelMainboard.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.IntelMainboard
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午11:00:28
 */
public class IntelMainboard implements Mainboard {

	private int cpuHoles = 0;

	public IntelMainboard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
	}

}
