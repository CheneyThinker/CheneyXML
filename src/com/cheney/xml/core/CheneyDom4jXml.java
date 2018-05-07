package com.cheney.xml.core;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cheney.xml.property.node.bean.PropertyNode;

@SuppressWarnings("unchecked")
public class CheneyDom4jXml implements CheneyXmlDocument {
	
	public void build(Object entity, String fileOfXml) {
		
	}
	
	public void build(PropertyNode node, String fileOfXml) {
		
	}

	public void parser(String fileOfXml) {
		File file = new File(fileOfXml);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(file);
			Element users = document.getRootElement();
			for (Iterator<Element> i = users.elementIterator(); i.hasNext();) {
				Element user = i.next();
				for (Iterator<Element> j = user.elementIterator(); j.hasNext();) {
					Element node = j.next();
					System.out.println(node.getName() + ":" + node.getText());
				}
				System.out.println();
			}
		} catch (DocumentException e) {
		}
	}

}
