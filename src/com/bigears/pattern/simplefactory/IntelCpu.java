/*
 * <p>IntelCpu.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.IntelCpu
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午10:42:05
 */
public class IntelCpu implements Cpu {

	private int pins = 0;

	public IntelCpu(int pins) {
		this.pins = pins;
	}

	@Override
	public void calculate() {
		System.out.println("Intel CPU的针脚数：" + this.pins);
	}

}
