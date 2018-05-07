package com.cheney.xml.entity;

import com.cheney.xml.core.NodeName;
import com.cheney.xml.core.Property;

@NodeName(name = "GRADE")
public class GradeEntity {
	
	@NodeName(name = "GradeGId")
	private Property<Integer> gid;
	@NodeName(name = "GradeName")
	private Property<String> name;
	
	public Property<Integer> getGid() {
		return gid;
	}
	public void setGid(Property<Integer> gid) {
		this.gid = gid;
	}
	public Property<String> getName() {
		return name;
	}
	public void setName(Property<String> name) {
		this.name = name;
	}

}
