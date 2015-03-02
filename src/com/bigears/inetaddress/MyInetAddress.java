/*
 * <p>MyInetAddress.java</p>
 */
package com.bigears.inetaddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * @Project : myworld
 * @ClassName : com.bigears.inetaddress.MyInetAddress
 * @Description: InetAddress InetSocketAddress test
 * @Author : bigears
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

		final Socket socket = new Socket();
		SocketAddress address = new InetSocketAddress("www.fortify.net", 443);
		try {
			socket.connect(address);
		} catch (IOException e) {
			e.printStackTrace();
		}// 连接远程主机
		Thread reader = new Thread() {
			@Override
			public void run() {
				try {
					byte[] buffer = new byte[512];
					socket.getInputStream().read(buffer);
				} catch (Exception ex) {

				}
			}
		};
		reader.start();

	}

}

