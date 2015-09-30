/*
 * <p>FieldResolution.java</p>
 */
package com.bigears.book.vmjava;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.test.FieldResolution
 * @Description: 7.3.4如果同一个字段自身类中木有定义，但同时出现在父类和接口中，或者多个接口中，将报编译错误
 * 			            如我们注释a=4,编译器就会报错
 * @Author     : shenyang
 * @Date  	   : 2015年9月30日 上午11:49:44 
 */
public class FieldResolution {

	interface InterfaceOne{
		int a = 0;
	}
	
	interface InterfaceTwo extends InterfaceOne{
		int a = 1;
	}
	
	interface InterfaceThree{
		int a = 2;
	}
	
	static class ClassOne implements InterfaceTwo{
		public static int a = 3;
	}
	
	static class ClassTwo extends ClassOne implements InterfaceThree{
		public static int a = 4;		
	}
	
	public static void main(String[] agrs){
		
		System.out.println(ClassTwo.a);
	}
}
