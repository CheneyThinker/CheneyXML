package com.cheney.xml.entity;

import java.util.List;

import com.cheney.xml.core.NodeName;

@NodeName(name = "COLLEGE")
public class CollegeEntity {
	
	@NodeName(name = "CollegeId")
	private int cid;
	@NodeName(name = "CollegeName")
	private String name;
	@NodeName(name = "CollegeClasses")
	private List<Classes> classes;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Classes> getClasses() {
		return classes;
	}
	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}
	
}
