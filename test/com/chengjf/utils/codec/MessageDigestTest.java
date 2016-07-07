package com.chengjf.utils.codec;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 使用Java自带工具进行摘要算法
 * 比如常见的MD5，SHA-256,和SHA-512。
 * 
 * @author CHENGJIANFENG100
 *
 * @date 2016年7月7日 下午4:39:55
 */
public class MessageDigestTest {
	private static char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static String byteArrayToHexString(byte[] val) {
		StringBuffer sb = new StringBuffer();
		for (byte b : val) {
			sb.append(hex[b >> 4 & 0x0F]);
			sb.append(hex[b & 0x0F]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MD5Test();
		SHA256Test();
		SHA512Test();
	}

	private static void MD5Test() {
		try {
			String value = "Hello, 世界！";
			// 目前支持的摘要算法有MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] rs = digest.digest(value.getBytes("UTF-8"));
			System.out.println(Arrays.toString(rs));
			System.out.println(byteArrayToHexString(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void SHA256Test() {
		try {
			String value = "Hello, 世界！";
			// 目前支持的摘要算法有MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] rs = digest.digest(value.getBytes("UTF-8"));
			System.out.println(Arrays.toString(rs));
			System.out.println(byteArrayToHexString(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void SHA512Test() {
		try {
			String value = "Hello, 世界！";
			// 目前支持的摘要算法有MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			byte[] rs = digest.digest(value.getBytes("UTF-8"));
			System.out.println(Arrays.toString(rs));
			System.out.println(byteArrayToHexString(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
