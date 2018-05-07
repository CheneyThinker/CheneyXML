package com.cheney.xml.core;

import com.cheney.xml.property.node.bean.PropertyNode;

public interface CheneyXmlDocument {

	void build(Object entity, String fileOfXml);
	void build(PropertyNode node, String fileOfXml);
	void parser(String fileOfXml);
	
}
