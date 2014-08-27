/*
 * Copyright (c) 2001-2014 Bidlink(Beijing) E-Biz Tech Co.,Ltd.
 * All rights reserved.
 * 必联（北京）电子商务科技有限公司 版权所有
 * <p>MyInetAddress.java</p>
 */
package com.bigears.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Project : myworld
 * @ClassName : com.bigears.inetaddress.MyInetAddress
 * @Description: InetAddress test
 * @Author : shenyang
 * @Date : 2014年8月27日 下午4:06:50
 */
public class MyInetAddress {

	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("主机名：" + address.getHostName() + ", ip地址：" + address.getHostAddress());
			InetAddress add = InetAddress.getByName("d-PC9");  
			System.out.println(add.getHostAddress());  
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
