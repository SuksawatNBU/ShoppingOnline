package com.somapait.shoppingonline.core.shopping.domain;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class OrderProductCart {
	
	public final static String orderProduct = "orderProduct";
	
	/**
	 * สำหรับเก็บค่าลงใน session ผ่าน Action class เช่น การเรียกใช้ผ่าน Action ต่างๆ ของ struts
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value) {
		ActionContext.getContext().getSession().put(key, value);
	}
	
	/**
	 * สำหรับดึงค่าจาก session ผ่าน Action class เช่น การเรียกใช้ผ่าน Action ต่างๆ ของ struts
	 * @param key
	 * @param value
	 */
	public static String get(String key) {
		return (String) ActionContext.getContext().getSession().get(key);
	}
	
	/**
	 * สำหรับเก็บค่าลงใน session ผ่าน http request เช่น การเรียกใช้ผ่าน servlet class
	 * @param key
	 * @param value
	 */
	public static void setAttribute(String key, Object value) {
		ServletActionContext.getRequest().getSession().setAttribute(key, value);
	}
	
}
