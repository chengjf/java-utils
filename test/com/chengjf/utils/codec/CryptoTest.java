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
		TripleDESTest();
		AESTest();
	}

	/**
	 * DES�ӽ��ܣ���Կ����64bits��8bytes
	 */
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
	 * DES�ӽ��ܣ���Կ����168bits����ʵ��3����Կ��ÿ����Կ64bits�������ṩ24bytes����Կ
	 * ���ܣ�ciphertext = EK3(DK2(EK1(plaintext)))
	 * ���ܣ�plaintext = DK1(EK2(DK3(ciphertext)))
	 */
	private static void TripleDESTest() {
		String value = "Hello, ���磡";
		byte[] secretKey = generateBytes(24);
		
		// ����
		byte[] rs = encrypt3DES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));
		
		// ����
		byte[] rs2 = decrypt3DES(rs,secretKey);
		System.out.println(new String(rs2));
	}
	
	/**
	 * AES�ӽ���
	 * ��Կ���ȿ���Ϊ 128, 192, and 256 bits.
	 * The size of the user key material in bytes. MUST be one of (16, 24, 32).
	 * ����Ĭ��ֻ��16bytes����Կ����ʹ�ã�24��32����Ҫʹ��
	 * <a href="http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html">Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 8 Download</a>
	 */
	private static void AESTest() {
		String value = "Hello, ���磡";
		byte[] secretKey = generateBytes(16); // 16,24,32
		
		// ����
		byte[] rs = encryptAES(value.getBytes(), secretKey);
		System.out.println(CodecUtils.byteArrayToHexString(rs));
		
		// ����
		byte[] rs2 = decryptAES(rs,secretKey);
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
	
	/**
	 * 3DES����
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
	 * 3DES����
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
	
	/**
	 * AES����
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * AES����
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
