/*
 * <p>IOTest.java</p>
 */
package com.bigears.base.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.io.IOTest
 * @Description: IO测试
 * @Author : shenyang
 * @Date : 2016年2月15日 下午2:21:13
 */
public class IOTest {

	/**
	 * 
	 * @Description: 用传统的方法读取文件 
	 * @MethodName : fileRead
	 * @Author     : shenyang
	 * @Date       : 2016年2月16日 上午9:44:26
	 * @param name
	 */
	public static void fileRead(String name) {
		File file = new File(name);
		FileReader fileReader;
		BufferedReader reader = null;
		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			String str = "";
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 
	 * @Description: nio的方式写文件 
	 * @MethodName : fileChannelWrite
	 * @Author     : shenyang
	 * @Date       : 2016年2月16日 上午9:45:19
	 * @param name
	 */
	public static void fileChannelWrite(String name) {
		File file = new File(name);
		FileOutputStream outputStream = null;
		String string = "java nio";
		try {
			outputStream = new FileOutputStream(file);
			FileChannel channel = outputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(string.getBytes());
			buffer.flip();
			channel.write(buffer);
			channel.close();
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @Description: nio的方式读文件  
	 * @MethodName : fileChannelRead
	 * @Author     : shenyang
	 * @Date       : 2016年2月16日 上午9:45:43
	 * @param name
	 */
	public static void fileChannelRead(String name) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(name);
			FileChannel fc = fis.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			fc.read(buffer);
			buffer.rewind();
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @Description: nio拷贝文件 
	 * @MethodName : copyFile
	 * @Author     : shenyang
	 * @Date       : 2016年2月16日 上午9:46:08
	 */
	public static void copyFile() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("d:\\IO.txt");
			fos = new FileOutputStream("d:\\IO_back.txt");
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			FileChannel fisChannel = fis.getChannel();
			FileChannel fosChannel = fos.getChannel();
			while (true) {
				buffer.clear();
				int b = fisChannel.read(buffer);
				if (b == -1) {
					break;
				}
				buffer.flip();
			}
			fosChannel.write(buffer);
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void main(String[] args) {
		fileChannelWrite("d:\\IO.txt");
		fileChannelRead("d:\\IO.txt");
		copyFile();
	}
}
