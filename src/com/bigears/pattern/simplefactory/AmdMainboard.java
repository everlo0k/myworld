/*
 * <p>AmdMainboard.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.AmdMainboard
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午11:02:08
 */
public class AmdMainboard implements Mainboard {

	private int cpuHoles = 0;

	public AmdMainboard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
	}

}
