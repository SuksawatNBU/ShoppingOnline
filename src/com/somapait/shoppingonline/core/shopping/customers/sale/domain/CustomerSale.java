package com.somapait.shoppingonline.core.shopping.customers.sale.domain;

import java.util.List;

import com.somapait.shoppingonline.core.shopping.domain.OrderDetail;
import com.somapait.shoppingonline.core.shopping.domain.OrderMain;
import com.somapait.shoppingonline.core.shopping.domain.Product;

/**
 * @description Class สำหรับเก็บรายการสินค้าที่ต้องการสั่งซื้อ
 * @author -
 */
public class CustomerSale extends Product{

	private static final long serialVersionUID = -889683554233993176L;
	
	private OrderMain orderMain;
	private List<OrderDetail> listOrderDetail;

	public OrderMain getOrderMain() {
		return orderMain;
	}
	public void setOrderMain(OrderMain orderMain) {
		this.orderMain = orderMain;
	}
	
	public List<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}
	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
	
	
}
