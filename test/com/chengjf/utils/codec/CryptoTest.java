package com.chengjf.utils.codec;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密解密算法示例 比如常见的DES，3DES
 * 
 * @author chengjianfeng
 * @date 2016-07-07
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
		AESTest();
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
		byte[] rs2 = decryptDES(rs, secretKey);
		System.out.println(new String(rs2));
	}

	/**
	 * DES加解密，密钥长度168bits，其实是3个密钥，每个密钥64bits，所以提供24bytes的密钥<br/>
	 * 加密：ciphertext = EK3(DK2(EK1(plaintext)))<br/>
	 * 解密：plaintext = DK1(EK2(DK3(ciphertext)))
	 */
	private static void TripleDESTest() {
		String value = "Hello, 世界！";
		byte[] secretKey = generateBytes(24);

		// 加密
		byte[] rs = encrypt3DES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));

		// 解密
		byte[] rs2 = decrypt3DES(rs, secretKey);
		System.out.println(new String(rs2));
	}

	/**
	 * AES加解密 密钥长度可以为 128, 192, and 256 bits. The size of the user key material
	 * in bytes. MUST be one of (16, 24, 32). <br/>
	 * 但是默认只有16bytes的密钥可以使用，24和32的需要使用
	 * <a href=
	 * "http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html"
	 * >Java
	 * Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files
	 * 8 Download</a>
	 */
	private static void AESTest() {
		String value = "Hello, 世界！";
		byte[] secretKey = generateBytes(16); // 16,24,32

		// 加密
		byte[] rs = encryptAES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));

		// 解密
		byte[] rs2 = decryptAES(rs, secretKey);
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
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * AES加密
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public static byte[] encryptAES(byte[] value, byte[] key) {
		byte[] result = null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = cipher.doFinal(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * AES解密
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public static byte[] decryptAES(byte[] value, byte[] key) {
		byte[] result = null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = cipher.doFinal(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
