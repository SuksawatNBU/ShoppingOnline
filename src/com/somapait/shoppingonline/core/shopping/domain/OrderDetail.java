package com.somapait.shoppingonline.core.shopping.domain;

import java.io.Serializable;

public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8459774430997472069L;
	
	private String id;
	private String productId;
	private String totalNum;
	private String totalPrice;
	private String orderId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	

}
