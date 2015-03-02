/*
 * <p>CocBigearsBeijing.java</p>
 */
package com.bigears.annotation;


/**
 * @Project : myworld
 * @ClassName : com.bigears.annotation.CocBigearsBeijing
 * @Description: 注解测试
 * @Author : bigears
 * @Date : 2015年3月2日 下午4:39:27
 */
public class CocBigearsBeijing extends CocBigears {

	private String area;

	public String getArea() {
		return area;
	}

	public static void main(String[] args) {

		// 因为coc这个注解中设置了@Inherited，所以在子类中也可以得到父类的注解
		if (CocBigearsBeijing.class.isAnnotationPresent(Coc.class)) {
			Coc coc = CocBigearsBeijing.class.getAnnotation(Coc.class);
			System.out.println(coc.townName());
			System.out.println(coc.herosLevel());
			System.out.println(coc.townLevel());
		}

	}

}
