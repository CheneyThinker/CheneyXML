package com.cheney.xml.property.node.bean;

import com.cheney.xml.core.NodeName;

@NodeName(name = "COURSE")
public class Course {
	
	@NodeName(name = "CourseId")
	private PropertyNode id;
	@NodeName(name = "CourseName")
	private PropertyNode name;
	
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

}
