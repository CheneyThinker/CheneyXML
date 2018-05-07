package com.cheney.xml.property.node.bean;

import java.util.Map;

public class PropertyNode {
	
	private Object value;
	private Map<String, Object> attributes;
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
}
