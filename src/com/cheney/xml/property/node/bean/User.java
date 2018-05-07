package com.cheney.xml.property.node.bean;

import com.cheney.xml.core.NodeName;

@NodeName(name = "USER")
public class User {
	
	@NodeName(name = "UserId")
	private PropertyNode id;
	@NodeName(name = "UserName")
	private PropertyNode name;
	@NodeName(name = "UserCourses")
	private PropertyNode courses;
	
	public PropertyNode getId() {
		return id;
	}
	
	public void setId(PropertyNode id) {
		this.id = id;
	}
	
	public PropertyNode getName() {
		return name;
	}
	
	public void setName(PropertyNode name) {
		this.name = name;
	}
	
	public PropertyNode getCourses() {
		return courses;
	}
	
	public void setCourses(PropertyNode courses) {
		this.courses = courses;
	}

}
