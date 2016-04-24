package com.chen.plane.util.Random;

import java.util.Random;

/*
 * 随机数, 随机字符串工具类
 * @anthur: 马俊	@date: 2011-7-26
 */
public class RandomUtils {
	
	public static final String LETTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBERIC = "0123456789";
	public static final String NUMBERIC_EXCEPT_ZERO = "123456789";
	public static final String ALPHABETIC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHABETIC2 = "0123456789abcdefghijklmnopqrstuvwxyz";

	public static final int RANDOM_POSITION      = 0;
	public static final int LEFT_UPPER_POSITION  = 1;
	public static final int UPPER_POSITION       = 2;
	public static final int RIGHT_UPPER_POSITION = 3;
	public static final int LEFT_POSITION        = 4;
	public static final int CENTER_POSITION      = 5;
	public static final int RIGHT_POSITION       = 6;
	public static final int LEFT_LOWER_POSITION  = 7;
	public static final int LOWER_POSITION       = 8;
	public static final int RIGHT_LOWER_POSITION = 9;
	
	/*
	 * 返回一个定长字符串(包含字母和数字)
	 * @param length 随机字符串长
	 * @return 随机字符串
	 */
	public static String generateMixString(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALPHABETIC2.charAt(random.nextInt(ALPHABETIC2.length()-1)));
		}
		return sb.toString();
	}
	
	/*
	 * 返回纯字母字符串(只包含字母)
	 * @param length 随机字符串长
	 * @return 随机字符串
	 */
	public static String generatePureString(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(LETTER.length()));
		}
		return sb.toString();
	}
	
	/*
	 * 返回纯大写字母字符串
	 * @param length 随机字符串长
	 * @return 随机字符串
	 */
	public static String generateUpperString(int length) {
		return generatePureString(length).toUpperCase();
	}
	
	/*
	 * 返回纯小写字母字符串
	 * @param length 随机字符串长
	 * @return 随机字符串
	 */
	public static String generateLowerString(int length) {
		return generatePureString(length).toLowerCase();
	}
	
	/*
	 * 返回数字字符串
	 * @param length 随机字符串长
	 * @return 随机字符串
	 */
	public static String generateNumString(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(NUMBERIC.length()));
		}
		return sb.toString();
	}
	
	/*
	 * 返回单个数字
	 * @param length 随机字符串长
	 * @return 随机字符串
	 */
	public static int generateNumber() {
		Random random = new Random();
		return random.nextInt(NUMBERIC.length());
	}
	
	/*
	 * 
	 */
	public static int generatePosition() {
		Random random = new Random();
		return random.nextInt(NUMBERIC_EXCEPT_ZERO.length());
	}
	
	public static void main(String[] args) {
			int length = 8;
		    StringBuilder sb = new StringBuilder();
		    Random random = new Random();
		    for (int i = 0; i < length; i++) {
		      sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length() - 1)));
		    }
		    System.out.println(sb.toString());
	}
}
