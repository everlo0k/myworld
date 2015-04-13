/*
 * <p>AmdCpu.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.simplefactory.AmdCpu
 * @Description: 简单工厂
 * @Author     : shenyang
 * @Date  	   : 2015年3月30日 上午10:52:33 
 */
public class AmdCpu implements Cpu {

	private int pins = 0;

	public AmdCpu(int pins) {
		pins = this.pins;
	}
	
	@Override
	public void calculate() {
		System.out.println("AMD CPU的针脚数：" + pins);
	}

}
