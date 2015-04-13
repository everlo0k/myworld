/*
 * <p>FruitsClient.java</p>
 */
package com.bigears.pattern.factorymethod;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.factorymethod.FruitsClient
 * @Description: 客户端
 * @Author     : shenyang
 * @Date  	   : 2015年3月31日 下午3:48:27 
 */
public class FruitsClient {

	public static void main(String[] args) {

		AbstractFactoryMethodPlant afmp = new ApplePlant();
		
		Fruits fruits = afmp.getFruits();
		
		System.out.println(fruits.getDesc());
		
	}

}
