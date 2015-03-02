/*
 * <p>Bigears.java</p>
 */
package com.bigears.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Project    : myworld
 * @ClassName  : com.bigears.annotation.Coc
 * @Description: 自定义注解
 * @Author     : bigears
 * @Date       : 2015年3月2日 下午3:38:32
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Coc {

	public enum Level{EIGHT,NINE,TEN,OTHER}; 
	
	String townName();
	
	int herosLevel();
	
	Level townLevel() default Level.NINE;
}
