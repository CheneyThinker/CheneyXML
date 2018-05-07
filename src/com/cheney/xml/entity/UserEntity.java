package com.cheney.xml.entity;

import java.util.List;

import com.cheney.xml.core.NodeName;
import com.cheney.xml.core.Property;

@NodeName(name = "USER")
public class UserEntity {
	
	@NodeName(name = "UserStuNo")
	private Property<String> stuNo;
	@NodeName(name = "UserGrades")
	private Property<List<GradeEntity>> grades;
	
	public Property<String> getStuNo() {
		return stuNo;
	}
	public void setStuNo(Property<String> stuNo) {
		this.stuNo = stuNo;
	}
	public Property<List<GradeEntity>> getGrades() {
		return grades;
	}
	public void setGrades(Property<List<GradeEntity>> grades) {
		this.grades = grades;
	}
	
}
