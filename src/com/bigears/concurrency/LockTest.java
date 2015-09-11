/*
 * <p>LockTest.java</p>
 */
package com.bigears.concurrency;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.concurrency.LockTest
 * @Description: TODO
 * @Author     : shenyang
 * @Date  	   : 2015年9月11日 下午4:41:24 
 */
public class LockTest {

	public static void main(String[] args) {
		//Outputter outputter = new Outputter();

	}

	
	private class Outputter{
		
		public void output(String name){
			
            for(int i = 0; i < name.length(); i++) {  
                System.out.print(name.charAt(i));  
            }  			
			
		}
		
		
	}
	
}
