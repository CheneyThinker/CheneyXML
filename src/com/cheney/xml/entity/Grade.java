package com.cheney.xml.entity;

import com.cheney.xml.core.NodeName;

@NodeName(name = "GRADE")
public class Grade {
	
	@NodeName(name = "GradeGId")
	private int gid;
	@NodeName(name = "GradeName")
	private String name;
	@NodeName(name = "GradeScore")
	private float score;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}

}
