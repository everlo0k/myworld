/*
 * <p>CocBigears.java</p>
 */
package com.bigears.annotation;

import com.bigears.annotation.Coc.Level;

/**
 * @Project : myworld
 * @ClassName : com.bigears.annotation.CocBigears
 * @Description: 注解测试
 * @Author : bigears
 * @Date : 2015年3月2日 下午4:00:41
 */

@Coc(townName = "bigears", herosLevel = 58, townLevel = Level.TEN)
public class CocBigears {

	public static void main(String[] args) {

		if (CocBigears.class.isAnnotationPresent(Coc.class)) {
			Coc coc = CocBigears.class.getAnnotation(Coc.class);
			System.out.println(coc.townName());
			System.out.println(coc.herosLevel());
			System.out.println(coc.townLevel());
		}

	}

}
