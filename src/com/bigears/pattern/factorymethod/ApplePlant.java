/*
 * <p>ApplePlant.java</p>
 */
package com.bigears.pattern.factorymethod;


/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.factorymethod.ApplePlant
 * @Description: 工厂方法实现
 * @Author     : shenyang
 * @Date  	   : 2015年3月31日 下午3:39:20 
 */
public class ApplePlant implements AbstractFactoryMethodPlant {

	@Override
	public Fruits getFruits() {
		return new Apple();
	}

}
