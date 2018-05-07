package com.cheney.xml.utils;

/**
 * @Description 字符串工具类
 * @auth CheneyThinker
 * @date 2018/4/12
 */
public class StringUtils {

	/**
	 * 将目标字符串首字母变为大写
	 * @param str 目标字符串
	 * @return 首字母变为大写的字符串
	 */
	public static String firstChar2UpperCase(String str) {
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

}
