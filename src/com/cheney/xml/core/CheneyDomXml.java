package com.cheney.xml.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cheney.xml.property.node.bean.PropertyNode;
import com.cheney.xml.utils.ReflectUtils;

public class CheneyDomXml implements CheneyXmlDocument {

	public void build(Object entity, String fileOfXml) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element element = callback(entity, document);
			document.appendChild(element);
			handler(document, fileOfXml);
		} catch (ParserConfigurationException e) {
		}
	}
	
	public void build(PropertyNode node, String fileOfXml) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element element = callback(node, document);
			document.appendChild(element);
			handler(document, fileOfXml);
		} catch (ParserConfigurationException e) {
		}
	}

	public void parser(String fileOfXml) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(fileOfXml);
			NodeList users = document.getChildNodes();
			for (int i = 0; i < users.getLength(); i++) {
				Node user = users.item(i);
				NodeList userInfo = user.getChildNodes();
				for (int j = 0; j < userInfo.getLength(); j++) {
					Node node = userInfo.item(j);
					NodeList userMeta = node.getChildNodes();
					for (int k = 0; k < userMeta.getLength(); k++) {
						if (userMeta.item(k).getNodeName() != "#text") {
							System.out.println(userMeta.item(k).getNodeName() + ":" + userMeta.item(k).getTextContent());
						}
					}
					System.out.println();
				}
			}
		} catch (FileNotFoundException e) {
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
	}

	private Element callback(Object entity, Document document) {
		Class<?> cls = entity.getClass();
		NodeName name = cls.getAnnotation(NodeName.class);
		Element node = document.createElement(name == null ? cls.getSimpleName() : name.name());
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			name = field.getAnnotation(NodeName.class);
			Element element = document.createElement(name == null ? field.getName() : name.name());
			Object value = ReflectUtils.invokeGet(field.getName(), entity);
			if (value instanceof List<?>) {
				List<?> list = (List<?>) value;
				for (Object obj : list) {
					element.appendChild(callback(obj, document));
				}
			} else {
				element.appendChild(document.createTextNode(value.toString()));
			}
			node.appendChild(element);
		}
		return node;
	}
	
	private Element callback(PropertyNode propertyNode, Document document) {
		Object entity = propertyNode.getValue();
		Class<?> cls = entity.getClass();
		NodeName nodeName = cls.getDeclaredAnnotation(NodeName.class);
		Element element = document.createElement(nodeName.name());
		Map<String, Object> map = propertyNode.getAttributes();
		for (String key : map.keySet()) {
			element.setAttribute(key, map.get(key).toString());
		}
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			nodeName = field.getDeclaredAnnotation(NodeName.class);
			Element elem = document.createElement(nodeName.name());
			PropertyNode property = (PropertyNode) ReflectUtils.invokeGet(field.getName(), entity);
			map = property.getAttributes();
			for (String key : map.keySet()) {
				elem.setAttribute(key, map.get(key).toString());
			}
			if (property.getValue() instanceof List<?>) {
				List<?> list = (List<?>) property.getValue();
				for (Object object : list) {
					elem.appendChild(callback((PropertyNode) object, document));
				}
			} else {
				elem.appendChild(document.createTextNode(property.getValue().toString()));
			}
			element.appendChild(elem);
		}
		return element;
	}
	
	private void handler(Document document, String fileOfXml) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileOfXml));
			Result result = new StreamResult(printWriter);
			transformer.transform(domSource, result);
		} catch (TransformerConfigurationException e) {
		} catch (FileNotFoundException e) {
		} catch (TransformerException e) {
		}
	}
	
}
