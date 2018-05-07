package com.cheney.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.cheney.xml.core.*;
import com.cheney.xml.entity.Classes;
import com.cheney.xml.entity.College;
import com.cheney.xml.entity.Grade;
import com.cheney.xml.entity.GradeEntity;
import com.cheney.xml.entity.User;
import com.cheney.xml.entity.UserEntity;
import com.cheney.xml.utils.ReflectUtils;

public class Test {
	
	public static void build(Object entity, String fileOfXml) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element element = callback(entity, document);
			document.appendChild(element);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileOfXml));
			StreamResult streamResult = new StreamResult(printWriter);
			transformer.transform(domSource, streamResult);
		} catch (ParserConfigurationException e) {
		} catch (TransformerConfigurationException e) {
		} catch (FileNotFoundException e) {
		} catch (TransformerException e) {
		}
	}
	
	private static Element callback(Object entity, Document document) {
		Class<?> cls = entity.getClass();
		NodeName name = cls.getAnnotation(NodeName.class);
		Element node = document.createElement(name == null ? cls.getSimpleName() : name.name());
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			name = field.getAnnotation(NodeName.class);
			Element element = document.createElement(name == null ? field.getName() : name.name());
			Object value = ReflectUtils.invokeGet(field.getName(), entity);
			if (value instanceof List<?>) {
				List<?> list = (List<?>) value;
				for (Object obj : list) {
					element.appendChild(callback(obj, document));
				}
			} else {
				element.appendChild(document.createTextNode(value.toString()));
			}
			node.appendChild(element);
		}
		return node;
	}
	
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(System.getProperty("user.dir"));
		buffer.append("/src/");
		buffer.append("cheney.xml");
		
		UserEntity userEntity = new UserEntity();
		Property<String> stuNo = new Property<String>();
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("id", "1");
		properties.put("href", "www.baidu.com");
		stuNo.setT("511527199112040330");
		stuNo.setProperties(properties);
		userEntity.setStuNo(stuNo);
		int size = 10;
		Property<List<GradeEntity>> grades = new Property<List<GradeEntity>>();
		List<GradeEntity> gradeEntities = new ArrayList<GradeEntity>();
		for (int i = 1; i <= size; i++) {
			GradeEntity gradeEntity = new GradeEntity();
			Property<Integer> gid = new Property<Integer>();
			gid.setT(i);
			gid.setProperties(properties);
			gradeEntity.setGid(gid);
			Property<String> name = new Property<String>();
			name.setT(String.valueOf(i * 10));
			name.setProperties(properties);
			gradeEntity.setName(name);
			gradeEntities.add(gradeEntity);
		}
		grades.setT(gradeEntities);
		userEntity.setGrades(grades);
		build(userEntity, buffer.toString());
	}
	
	public static College getCollege() {
		int size = 10;
		List<Classes> classes = new ArrayList<Classes>(size);
		for (int i = 1; i <= size; i++) {
			Classes clses = new Classes();
			clses.setCid(i);
			clses.setName("第" + i + "班");
			clses.setNumber(new Random().nextInt());
			List<User> users = new ArrayList<>(size);
			for (int j = 1; j <= size; j++) {
				User user = new User();
				user.setStuNo(String.valueOf(new Random().nextInt(100000)));
				user.setName("第" + (i + j) + "人");
				user.setIdCard(String.valueOf(new Random().nextInt(100000)));
				user.setPhone(String.valueOf(new Random().nextInt(100000)));
				List<Grade> grades = new ArrayList<>(size);
				for (int k = 1; k <= size; k++) {
					Grade grade = new Grade();
					grade.setGid(k);
					grade.setName("第" + (i + j + k) + "科");
					grade.setScore(new Random().nextFloat());
					grades.add(grade);
				}
				user.setGrades(grades);
				users.add(user);
			}
			clses.setUsers(users);
			classes.add(clses);
		}
		College college = new College();
		college.setCid(1);
		college.setName("学院");
		college.setClasses(classes);
		return college;
	}
	
}
