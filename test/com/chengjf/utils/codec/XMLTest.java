package com.chengjf.utils.codec;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
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
		XMLTest test = new XMLTest();
		test.validateWithDTD("D:\\Users\\chengjianfeng100\\Desktop\\sqlmap-mapping-business.xml");
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 校验XML文件是否正确
	 * 
	 * @param fileName
	 */
	private static void validateXMLFormat(String fileName) {

		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			InputStream inputStream = new FileInputStream(new File(fileName));
			parser.parse(inputStream, new DefaultHandler());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用DTD校验
	 * resource目录下有DTD文件
	 * 
	 * @param fileName
	 */
	private void validateWithDTD(String fileName) {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setValidating(true);
		SAXParser saxParser;

		try {
			saxParser = spf.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();

			xmlReader.setEntityResolver(new ClasspathEntityResolver());

			xmlReader.setDTDHandler(new DTDHandler() {

				@Override
				public void unparsedEntityDecl(String name, String publicId,
						String systemId, String notationName)
						throws SAXException {
					System.out.println(name + publicId + systemId
							+ notationName);
				}

				@Override
				public void notationDecl(String name, String publicId,
						String systemId) throws SAXException {
					System.out.println(name + publicId + systemId);
				}
			});

			xmlReader.setEntityResolver(new ClasspathEntityResolver());

			xmlReader.setErrorHandler(new MyHandler());

			xmlReader.parse(new InputSource(fileName));

		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class MyHandler extends DefaultHandler {
		String errorMessage = null;

		public void error(SAXParseException e) throws SAXException {
			errorMessage = e.getMessage();
			System.out.println("一般错误：" + errorMessage);
		}

		public void fatalError(SAXParseException e) throws SAXException {
			errorMessage = e.getMessage();
			System.out.println("致命错误：" + errorMessage);
		}
	}

	public class ClasspathEntityResolver implements EntityResolver {

		public InputSource resolveEntity(String publicId, String systemId)
				throws SAXException, IOException {

			if (systemId != null) {

				int index = systemId.lastIndexOf('/');
				if (index != -1) {
					systemId = systemId.substring(index + 1);
				}
				// systemId = "/" + systemId;
				System.out.println(systemId);
				InputStream istr = Thread.currentThread()
						.getContextClassLoader().getResourceAsStream(systemId);
				if (istr != null) {
					return new InputSource(istr);
				}
			}
			return null;
		}
	}
}
