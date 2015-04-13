/*
 * <p>BananaPlant.java</p>
 */
package com.bigears.pattern.factorymethod;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.factorymethod.BananaPlant
 * @Description: 工厂方法实现
 * @Author     : shenyang
 * @Date  	   : 2015年3月31日 下午3:47:45 
 */
public class BananaPlant implements AbstractFactoryMethodPlant {

	@Override
	public Fruits getFruits() {
		return new Banana();
	}

}
