/*
 * <p>SimpleFactory.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.pattern.simplefactory.SimpleFactory
 * @Description: 简单工厂
 * @Author     : shenyang
 * @Date  	   : 2015年3月31日 上午9:46:38 
 */
public class SimpleFactory {

	public SimpleFactory() {
		super();
	}

	public static SimpleFactory factory(){
		
		return new SimpleFactory(); 
	}
	
	
}
