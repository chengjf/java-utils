package com.chengjf.utils.codec;

import java.io.UnsupportedEncodingException;

/**
 * Base64����ʾ��
 * 
 * @author CHENGJIANFENG100
 *
 * @date 2016��7��7�� ����4:35:23
 */
public class Base64Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "Hello, ���磡";
		// ����
		// Stringתbyte�����ʱ�򣬿����Լ�ָ�������ʽ���Ƽ�ʹ��UTF-8
		String encodeResult = Base64.encode(str.getBytes("UTF-8"));
		System.out.println(encodeResult);
		// ����
		byte[] rs = Base64.decode(encodeResult);
		// byte����תString��ʱ��ʹ��ͬ������ͬ�ı����ʽ
		String decodeResult = new String(rs, "UTF-8");
		System.out.println(decodeResult);
	}
}
