package com.chengjf.utils.codec;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;

/**
 * XML相关操作
 * 
 * @author chengjianfeng
 * @date 2016-07-19
 */
public class XMLTest {

	public static void main(String[] args) {
		validateXMLFormat();
	}

	/**
	 * 校验XML字符串格式是否正确
	 * 
	 */
	private static void validateXMLFormat() {
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><insert>a.the_date <= sysdate - 90</insert>";
		
		SAXParser parser = new SAXParser();
		try {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes());
			parser.parse(new InputSource(inputStream));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
