/*
 * <p>IntelFactory.java</p>
 */
package com.bigears.pattern.abstractfactory;

import com.bigears.pattern.simplefactory.Cpu;
import com.bigears.pattern.simplefactory.IntelCpu;
import com.bigears.pattern.simplefactory.IntelMainboard;
import com.bigears.pattern.simplefactory.Mainboard;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.abstractfactory.IntelFactory
 * @Description: 抽象工厂实现
 * @Author     : shenyang
 * @Date  	   : 2015年3月30日 下午2:36:41 
 */
public class IntelFactory implements AbstractFactory{

	@Override
	public Cpu createCpu() {
		return new IntelCpu(755);
	}

	@Override
	public Mainboard createMainboard() {
		return new IntelMainboard(755);
	}

	
}
