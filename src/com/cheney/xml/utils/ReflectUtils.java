package com.cheney.xml.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 反射工具类
 * @author CheneyThinker
 * @date 2018/4/12
 */
public class ReflectUtils {

	/**
	 * 调用object对象对应属性fieldName的get方法
	 * @param fieldName
	 * @param object
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object object) {
		try {
			Class<?> c = object.getClass();
			Method m = c.getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName));
			return m.invoke(object);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 调用object对象对应属性fieldName的set方法
	 * @param object
	 * @param columnName
	 * @param columnValue
	 */
	public static void invokeSet(Object object, String columnName, Object columnValue){
		try {
			if(columnValue != null) {
				Method m = object.getClass().getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(columnName), columnValue.getClass());
				m.invoke(object, columnValue);
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
