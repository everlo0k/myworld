/*
 * <p>Piped.java</p>
 */
package com.bigears.book.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Project : myworld
 * @ClassName : com.bigears.book.concurrency.Piped
 * @Description: 4.3.4
 * @Author : shenyang
 * @Date : 2015年12月4日 上午8:36:25
 */
public class Piped {

	public static void main(String[] args) throws Exception {
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();
		out.connect(in);
		Thread printThread = new Thread(new Print(in), "PrintThread");
		printThread.start();
		int receive = 0;
		try {
			while ((receive = System.in.read()) != -1) {
				out.write(receive);
			}
		} finally {
			out.close();
		}
	}

	static class Print implements Runnable {
		private PipedReader in;

		public Print(PipedReader in) {
			this.in = in;
		}

		public void run() {
			int receive = 0;
			try {
				while ((receive = in.read()) != -1) {
					System.out.print((char) receive);
				}
			} catch (IOException ex) {

			}
		}
	}

}
