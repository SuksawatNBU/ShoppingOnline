package com.somapait.shoppingonline.core.shopping.customers.sale.domain;

import com.somapait.shoppingonline.core.shopping.domain.Product;

/**
 * @description Class สำหรับเก็บผลลัพธ์จากการค้นหารายการสินค้าแต่ละประเภทที่เลือกจากเมนู
 * @author -
 */
public class CustomerSaleSearch  extends Product {

	private static final long serialVersionUID = 5283727317610555413L;
	
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
