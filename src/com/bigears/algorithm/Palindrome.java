/*
 * <p>Palindrome.java</p>
 */
package com.bigears.algorithm;


/**
 * @Project : myworld
 * @ClassName : com.bigears.algorithm.Palindrome
 * @Description: 回文的检查
 * @Author : shenyang
 * @Date : 2015年10月27日 上午11:35:40
 */
public class Palindrome {

	/**
	 * 
	 * @Description: 通过StringBuffer判断是否是回文
	 * @MethodName : isPalindrome
	 * @Author     : shenyang
	 * @Date       : 2015年10月27日 下午3:11:29
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		String reverse = new StringBuffer(s).reverse().toString();
		return s.equalsIgnoreCase(reverse);
	}

	/**
	 * 
	 * @Description: 判断回文
	 * @MethodName : isPalindromeB
	 * @Author     : shenyang
	 * @Date       : 2015年10月27日 下午3:12:03
	 * @param s
	 * @return
	 */
	public static boolean isPalindromeB(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * 
	 * @Description: 用穷举的方法找出最长的回文，效率低些
	 * @MethodName : getMaxPalindrome
	 * @Author     : shenyang
	 * @Date       : 2015年10月27日 下午3:12:33
	 * @param s
	 * @return
	 */
	public static String getMaxPalindrome(String s) {
		String maxPalindrome = "";
		int maxLength = 0;
		int size = s.length();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				String temp = s.substring(i, j + 1);
				if (isPalindrome(temp) && maxLength < temp.length()) {
					maxPalindrome = temp;
					maxLength = temp.length();
				}

			}
		}
		return maxPalindrome;
	}

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);
		// String s = scanner.next();
		String s = "abcdcba";
		System.out.println(isPalindromeB(s));
		System.out.println(getMaxPalindrome(s));

	}

}
