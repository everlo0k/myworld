/*
 * Copyright (c) 2001-2014 Bidlink(Beijing) E-Biz Tech Co.,Ltd.
 * All rights reserved.
 * 必联（北京）电子商务科技有限公司 版权所有
 * <p>SleepMessages.java</p>
 */
package com.bigears.concurrent;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.concurrent.SleepMessages
 * @Description: TODO
 * @Author     : shenyang
 * @Date  	   : 2014年11月28日 上午10:44:43 
 */
public class SleepMessages {

	public static void main(String args[]) throws InterruptedException {
		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			// Pause for 4 seconds
			Thread.sleep(4000);
			// Print a message
			System.out.println(importantInfo[i]);
		}
	}

}
