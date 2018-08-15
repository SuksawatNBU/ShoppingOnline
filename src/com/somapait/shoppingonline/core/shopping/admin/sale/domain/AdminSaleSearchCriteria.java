package com.somapait.shoppingonline.core.shopping.admin.sale.domain;

import com.somapait.domain.SearchCriteria;

/**
 * @description Class สำหรับเก็บเงื่อนไขการค้นหาจากหน้า ค้นหารายการสั่งซื้อ
 * @author -
 */
public class AdminSaleSearchCriteria extends SearchCriteria{

	private static final long serialVersionUID = 7517991211013069896L;
	private String no;
	private String ship;
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getShip() {
		return ship;
	}
	public void setShip(String ship) {
		this.ship = ship;
	}
	
	

}
