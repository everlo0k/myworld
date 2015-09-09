/*
 * <p>Computable.java</p>
 */
package com.bigears.concurrency;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.concurrency.Computable
 * @Description: Computable
 * @Author     : shenyang
 * @Date  	   : 2015年7月20日 下午3:16:33 
 */
public interface Computable<A, V> {

	V compute(A arg) throws InterruptedException;
}
