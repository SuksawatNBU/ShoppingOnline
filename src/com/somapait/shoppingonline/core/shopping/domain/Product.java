package com.somapait.shoppingonline.core.shopping.domain;

import com.somapait.common.CommonDomain;

/**
 * @description Class สำหรับเก็บรายละเอียดสินค้า ใช้ร่วมกันระหว่างลูกค้าและเจ้าหน้าที่
 * @author -
 */
public class Product extends CommonDomain{
	
	private static final long serialVersionUID = 6127263822792589922L;
	private String code;
	private String productDesc;
	private String price;
	private String stockNum;
	private String imageName;
	
	private String typeId;
	private String typeDesc;
	private String seq;
	private String imagePath;
	
	private String image;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStockNum() {
		return stockNum;
	}
	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
