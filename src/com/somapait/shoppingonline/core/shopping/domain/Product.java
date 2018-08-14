package com.somapait.shoppingonline.core.shopping.domain;

import com.somapait.common.CommonDomain;

/**
 * @description Class สำหรับเก็บรายละเอียดสินค้า ใช้ร่วมกันระหว่างลูกค้าและเจ้าหน้าที่
 * @author -
 */
public class Product extends CommonDomain{
	private String code;
	private String productDesc;
	private String price;
	private String stockNum;
	private String imageName;
	
	private String typeId;
	private String typeDesc;
	private String seq;
	private String imagePath;
}
