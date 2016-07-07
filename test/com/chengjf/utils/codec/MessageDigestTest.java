package com.chengjf.utils.codec;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * ʹ��Java�Դ����߽���ժҪ�㷨 ���糣����MD5��SHA-256,��SHA-512��
 * 
 * @author chengjianfeng
 *
 * @date 2016-07-07
 */
public class MessageDigestTest {

	public static void main(String[] args) {
		MD5Test();
		SHA256Test();
		SHA512Test();
	}

	private static void MD5Test() {
		try {
			String value = "Hello, ���磡";
			// Ŀǰ֧�ֵ�ժҪ�㷨��MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
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
			String value = "Hello, ���磡";
			// Ŀǰ֧�ֵ�ժҪ�㷨��MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
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
			String value = "Hello, ���磡";
			// Ŀǰ֧�ֵ�ժҪ�㷨��MD2/MD5/SHA-1/SHA-256/SHA-384/SHA-512
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			byte[] rs = digest.digest(value.getBytes("UTF-8"));
			System.out.println(Arrays.toString(rs));
			System.out.println(CodecUtils.byteArrayToHexString(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
