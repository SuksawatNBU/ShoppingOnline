package com.somapait.shoppingonline.core.shopping.admin.sale.domain;

import com.somapait.shoppingonline.core.shopping.domain.OrderMain;

/**
 * @description Class สำหรับเก็บผลลัพธ์ที่ได้จากการค้นหารายการสั่งซื้อ ในหน้าค้นหารายการสั่งซื้อ
 * @author -
 */
public class AdminSaleSearch extends OrderMain {

	private static final long serialVersionUID = -2262724463451447854L;
	private String fullName;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
