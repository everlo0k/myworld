/*
 * <p>AbstractFactory.java</p>
 */
package com.bigears.pattern.abstractfactory;

import com.bigears.pattern.simplefactory.Cpu;
import com.bigears.pattern.simplefactory.Mainboard;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.abstractfactory.AbstractFactory
 * @Description: 抽象工厂
 * @Author     : shenyang
 * @Date  	   : 2015年3月30日 下午2:35:04 
 */
public interface AbstractFactory {

	public Cpu createCpu();
	
	public Mainboard createMainboard();
	
}
