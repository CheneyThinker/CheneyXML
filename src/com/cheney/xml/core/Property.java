package com.cheney.xml.core;

import java.util.Map;

public class Property<T> {
	
	protected T t;
	protected Map<String, Object> properties;
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

}
