package com.cheney.xml.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cheney.xml.property.node.bean.PropertyNode;

public class CheneySaxXml implements CheneyXmlDocument {
	
	public void build(Object entity, String fileOfXml) {
		
	}
	
	public void build(PropertyNode node, String fileOfXml) {
		
	}
	
	public void parser(String fileOfXml) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			InputStream inputStream = new FileInputStream(fileOfXml);
			saxParser.parse(inputStream, new CheneySaxHandler());
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
	}
	
}

class CheneySaxHandler extends DefaultHandler {
	
	boolean hasAttribute = false;
	Attributes attributes = null;
	
	public void startDocument() throws SAXException {
		// System.out.println("文档开始打印了");
	}
	
	public void endDocument() throws SAXException {
		// System.out.println("文档打印结束了");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("users")) {
			return;
		}
		if (qName.equals("user")) {
			return;
		}
		if (attributes.getLength() > 0) {
			this.attributes = attributes;
			this.hasAttribute = true;
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (hasAttribute && (attributes != null)) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.print(attributes.getQName(0) + ":" + attributes.getValue(0));
			}
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}
	
}
