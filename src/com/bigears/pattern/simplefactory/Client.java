/*
 * <p>Client.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.Client
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午11:32:54
 */
public class Client {

	public static void main(String[] args) {
		ComputerEngineer cf = new ComputerEngineer();
		cf.makeComputer(1, 1);
	}

}
