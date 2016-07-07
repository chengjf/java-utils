package com.chengjf.utils.codec;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * ���ܽ����㷨ʾ�� ���糣����DES��3DES
 * 
 * @author CHENGJIANFENG100
 *
 * @date 2016��7��7�� ����4:55:08
 */
public class CryptoTest {

	/**
	 * ���ɸ������ȵ�����ֽ�����
	 * 
	 * @param length
	 * @return
	 */
	public static byte[] generateBytes(int length) {
		byte[] bytes = new byte[length];
		Random random = new Random();
		random.nextBytes(bytes);
		return bytes;
	}

	public static void main(String[] args) {
		DESTest();
	}

	private static void DESTest() {
		String value = "Hello, ���磡";
		byte[] secretKey = generateBytes(8);
		
		// ����
		byte[] rs = encryptDES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));
		
		// ����
		byte[] rs2 = decryptDES(rs,secretKey);
		System.out.println(new String(rs2));
	}

	/**
	 * DES����
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public static byte[] encryptDES(byte[] value, byte[] key) {
		byte[] result = null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "DES");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = cipher.doFinal(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * DES����
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public static byte[] decryptDES(byte[] value, byte[] key) {
		byte[] result = null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "DES");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = cipher.doFinal(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
