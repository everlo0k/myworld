/*
 * <p>ComputerEngineer.java</p>
 */
package com.bigears.pattern.abstractfactory;

import com.bigears.pattern.simplefactory.Cpu;
import com.bigears.pattern.simplefactory.Mainboard;

/**
 * @Project : myworld
 * @ClassName : com.bigears.pattern.abstractfactory.ComputerEngineer
 * @Description: TODO
 * @Author : shenyang
 * @Date : 2015年3月30日 下午2:42:22
 */
public class ComputerEngineer {

	private Cpu cpu = null;
	/**
	 * 定义组装机需要的主板
	 */
	private Mainboard mainboard = null;

	public void makeComputer(AbstractFactory af) {

		prepareHardwares(af);
	}

	private void prepareHardwares(AbstractFactory af) {

		// 这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
		// 可是，装机工程师并不知道如何去创建，怎么办呢？

		// 直接找相应的工厂获取
		this.cpu = af.createCpu();
		this.mainboard = af.createMainboard();

		// 测试配件是否好用
		this.cpu.calculate();
		this.mainboard.installCPU();
	}

}
