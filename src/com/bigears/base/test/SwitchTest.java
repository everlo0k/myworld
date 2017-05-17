/*
 * <p>SwitchTest.java</p>
 */
package com.bigears.base.test;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.base.test.SwitchTest
 * @Description: SwitchTest
 * @Author     : shenyang
 * @Date  	   : 2017-5-17 下午3:38:13 
 */
public class SwitchTest {

    /**
     * 
     * @Description: switch分支里面一定要有break 
     * @MethodName : doSwitchTest
     * @Author     : shenyang
     * @Date       : 2017-5-17 下午3:44:17
     * @param number
     */
    public static void doSwitchTest(int number) {
        switch (number) {
        case 1:
            System.out.println("1");
        case 2:
            System.out.println("2");
        case 3:
            System.out.println("3");
            break;
        case 4:
            System.out.println("4");
            break;
        default:
        }
    }

    public static void main(String[] args) {
        doSwitchTest(1);
    }

}
