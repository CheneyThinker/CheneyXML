package com.cheney.xml.entity;

import java.util.List;

import com.cheney.xml.core.NodeName;

@NodeName(name = "USER")
public class User {
	
	@NodeName(name = "UserStuNo")
	private String stuNo;
	@NodeName(name = "UserName")
	private String name;
	@NodeName(name = "UserIdCard")
	private String idCard;
	@NodeName(name = "UserPhone")
	private String phone;
	@NodeName(name = "UserGrades")
	private List<Grade> grades;
	
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
}
