package com.cheney.xml.core;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.cheney.xml.property.node.bean.PropertyNode;

public class CheneyJDomXml implements CheneyXmlDocument {

	public void build(Object entity, String fileOfXml) {
		
	}
	
	public void build(PropertyNode node, String fileOfXml) {
		
	}
	
	public void parser(String fileOfXml) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(fileOfXml);
			Element users = document.getRootElement();
			List<Element> userList = users.getChildren("user");
			for (int i = 0; i < userList.size(); i++) {
				Element user = (Element) userList.get(i);
				List<Element> userInfo = user.getChildren();
				for (int j = 0; j < userInfo.size(); j++) {
					System.out.println(((Element) userInfo.get(j)).getName() + ":" + ((Element) userInfo.get(j)).getValue());
				}
				System.out.println();
			}
		} catch (JDOMException e) {
		} catch (IOException e) {
        }
	}
	
}
