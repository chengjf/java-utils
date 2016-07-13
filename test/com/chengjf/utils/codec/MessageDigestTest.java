package com.chengjf.utils.codec;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 使用Java自带工具进行摘要算法</br>
 * 比如常见的MD5，SHA-256,和SHA-512。
 * 
 * @author chengjianfeng
 * @date 2016-07-07
 */
public class MessageDigestTest {

	public static void main(String[] args) {
		MD5Test();
		SHA256Test();
		SHA512Test();
		MD5File();
	}

	private static void MD5Test() {
		try {
			String value = "Hello, 世界！";
			// 目前支持的摘要算法有MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] rs = digest.digest(value.getBytes("UTF-8"));
			System.out.println(Arrays.toString(rs));
			System.out.println(CodecUtils.byteArrayToHexString(rs));
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
			System.out.println(CodecUtils.byteArrayToHexString(rs));
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
			System.out.println(CodecUtils.byteArrayToHexString(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取文件的MD5值
	 */
	private static void MD5File() {

		FileInputStream fileInputStream = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			File file = new File("C:\\Windows\\smsts.ini");

			byte[] buffer = new byte[8192];
			int length;
			fileInputStream = new FileInputStream(file);
			while ((length = fileInputStream.read(buffer)) != -1) {
				digest.update(buffer, 0, length);
			}
			byte[] rs = digest.digest();
			System.out.println(CodecUtils.byteArrayToHexString(rs));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
