package com.chengjf.utils.codec;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
	 */
	private static void validateXMLFormat() {
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><insert>a.the_date <= sysdate - 90</insert>";

		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(
					xmlStr.getBytes());
			parser.parse(inputStream, new DefaultHandler());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
