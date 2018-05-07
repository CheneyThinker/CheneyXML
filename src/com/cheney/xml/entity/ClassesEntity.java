package com.cheney.xml.entity;

import java.util.List;

import com.cheney.xml.core.NodeName;

@NodeName(name = "CLASSES")
public class ClassesEntity {
	
	@NodeName(name = "ClassesId")
	private int cid;
	@NodeName(name = "ClassesNumber")
	private int number;
	@NodeName(name = "ClassesName")
	private String name;
	@NodeName(name = "ClassesUsers")
	private List<User> users;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
