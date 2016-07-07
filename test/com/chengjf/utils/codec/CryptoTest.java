package com.chengjf.utils.codec;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密解密算法示例 比如常见的DES，3DES
 * 
 * @author CHENGJIANFENG100
 *
 * @date 2016年7月7日 下午4:55:08
 */
public class CryptoTest {

	/**
	 * 生成给定长度的随机字节数组
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
		TripleDESTest();
	}

	/**
	 * DES加解密，密钥长度64bits，8bytes
	 */
	private static void DESTest() {
		String value = "Hello, 世界！";
		byte[] secretKey = generateBytes(8);
		
		// 加密
		byte[] rs = encryptDES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));
		
		// 解密
		byte[] rs2 = decryptDES(rs,secretKey);
		System.out.println(new String(rs2));
	}
	
	/**
	 * DES加解密，密钥长度168bits，其实是3个密钥，每个密钥64bits，所以提供24bytes的密钥
	 */
	private static void TripleDESTest() {
		String value = "Hello, 世界！";
		byte[] secretKey = generateBytes(24);
		
		// 加密
		byte[] rs = encrypt3DES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));
		
		// 解密
		byte[] rs2 = decrypt3DES(rs,secretKey);
		System.out.println(new String(rs2));
	}

	/**
	 * DES加密
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
	 * DES解密
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
	
	/**
	 * 3DES加密
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public static byte[] encrypt3DES(byte[] value, byte[] key) {
		byte[] result = null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = cipher.doFinal(value);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 3DES解密
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public static byte[] decrypt3DES(byte[] value, byte[] key) {
		byte[] result = null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = cipher.doFinal(value);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
