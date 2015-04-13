/*
 * <p>ComputerEngineer.java</p>
 */
package com.bigears.pattern.simplefactory;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.simplefactory.ComputerEngineer
 * @Description: 简单工厂
 * @Author : shenyang
 * @Date : 2015年3月30日 上午11:29:42
 */
public class ComputerEngineer {

	private Cpu cpu = null;

	private Mainboard mainboard = null;

	public void makeComputer(int cpuType, int mainboard) {
		prepareHardwares(cpuType, mainboard);
	}

	private void prepareHardwares(int cpuType, int mainboard) {

		// 这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
		// 可是，装机工程师并不知道如何去创建，怎么办呢？
		// 直接找相应的工厂获取
		this.cpu = CupFactory.createCpu(cpuType);
		this.mainboard = MainboardFactory.createMainboard(mainboard);

		// 测试配件是否好用
		this.cpu.calculate();
		this.mainboard.installCPU();
	}

}
