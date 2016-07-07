package com.chengjf.utils.codec;

import java.io.UnsupportedEncodingException;

/**
 * Base64测试示例
 * 
 * @author CHENGJIANFENG100
 *
 * @date 2016年7月7日 下午4:35:23
 */
public class Base64Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "Hello, 世界！";
		// 编码
		// String转byte数组的时候，可以自己指定编码格式，推荐使用UTF-8
		String encodeResult = Base64.encode(str.getBytes("UTF-8"));
		System.out.println(encodeResult);
		// 解码
		byte[] rs = Base64.decode(encodeResult);
		// byte数组转String的时候，使用同上面相同的编码格式
		String decodeResult = new String(rs, "UTF-8");
		System.out.println(decodeResult);
	}
}
