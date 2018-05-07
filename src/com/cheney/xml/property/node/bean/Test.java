package com.cheney.xml.property.node.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cheney.xml.core.CheneyDomXml;

public class Test {
	
	public static void main(String[] args) throws Exception {
		User user = new User();
		
		PropertyNode id = new PropertyNode();
		Map<String, Object> attributesId = new HashMap<>();
		attributesId.put("id", "1");
		attributesId.put("href", "www.baidu.com");
		id.setValue(1);
		id.setAttributes(attributesId);
		user.setId(id);
		
		PropertyNode name = new PropertyNode();
		Map<String, Object> attributesName = new HashMap<>();
		attributesName.put("id", "2");
		attributesName.put("href", "www.clxuanye.cn");
		name.setValue("CheneyThinker");
		name.setAttributes(attributesName);
		user.setName(name);
		
		PropertyNode courses = new PropertyNode();
		Map<String, Object> attributesCourses = new HashMap<>();
		attributesCourses.put("id", "3");
		attributesCourses.put("href", "www.tea.cn");
		List<PropertyNode> list = new ArrayList<>();
		for (int i = 1; i <= 2; i++) {
			Course course = new Course();
			
			PropertyNode courseId = new PropertyNode();
			Map<String, Object> attributesCourseId = new HashMap<>();
			attributesCourseId.put("id", String.valueOf(i << 2));
			attributesCourseId.put("href", "www.cheney.com");
			courseId.setValue(i);
			courseId.setAttributes(attributesCourseId);
			course.setId(courseId);
			
			PropertyNode courseName = new PropertyNode();
			Map<String, Object> attributesCourseName = new HashMap<>();
			attributesCourseName.put("id", String.valueOf(i << 4));
			attributesCourseName.put("href", "www.thinker.cn");
			courseName.setValue("CheneyThinkerLove");
			courseName.setAttributes(attributesCourseName);
			course.setName(courseName);
			
			PropertyNode courseNode = new PropertyNode();
			Map<String, Object> attributesCourse = new HashMap<>();
			attributesCourse.put("id", "10000");
			attributesCourse.put("value", "attributesCourse");
			courseNode.setValue(course);
			courseNode.setAttributes(attributesCourse);
			
			list.add(courseNode);
		}
		courses.setValue(list);
		courses.setAttributes(attributesCourses);
		user.setCourses(courses);
		
		PropertyNode userNode = new PropertyNode();
		Map<String, Object> attributesUser = new HashMap<>();
		attributesUser.put("id", "0");
		attributesUser.put("value", "attributesUser");
		userNode.setValue(user);
		userNode.setAttributes(attributesUser);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(System.getProperty("user.dir"));
		buffer.append("/src/");
		buffer.append("cheneyPropertyNode.xml");
		
		CheneyDomXml cheneyDomXml = new CheneyDomXml();
		cheneyDomXml.build(userNode, buffer.toString());
	}
	
}
