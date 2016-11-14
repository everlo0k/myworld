/*
 * <p>RegexMatches.java</p>
 */
package com.bigears.base.runoob.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.base.runoob.regular.RegexMatches
 * @Description: 捕获组
 * @Author     : shenyang
 * @Date  	   : 2016-11-14 下午2:31:05 
 */
public class RegexMatches {

	public static void main(String[] args) {

		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}

		// 结果
		// Found value: This order was placed for QT3000! OK?
		// Found value: This order was placed for QT
		// Found value: 3000
		// Found value: ! OK?
	}

}
