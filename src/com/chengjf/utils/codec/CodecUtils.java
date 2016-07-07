package com.chengjf.utils.codec;

/**
 * 编码相关工具类
 * 
 * @author chengjianfeng
 *
 * @date 2016-07-07
 * @version 1.0.0
 */
public final class CodecUtils {
	private static char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String byteArrayToHexString(byte[] val) {
		if(val == null){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (byte b : val) {
			sb.append(hex[b >> 4 & 0x0F]);
			sb.append(hex[b & 0x0F]);
		}
		return sb.toString();
	}
}
