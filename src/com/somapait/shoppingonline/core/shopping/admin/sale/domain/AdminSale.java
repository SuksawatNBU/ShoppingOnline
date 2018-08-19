package com.somapait.shoppingonline.core.shopping.admin.sale.domain;

import java.util.ArrayList;
import java.util.List;

import com.somapait.common.CommonDomain;
import com.somapait.shoppingonline.core.shopping.domain.OrderDetail;
import com.somapait.shoppingonline.core.shopping.domain.OrderMain;

/**
 * @description Class สำหรับแสดงรายละเอียดของการสั่งซื้อจากรายการที่เลือกในหน้าค้นหา และนำข้อมูลดังกล่าวไปใช้บันทึกตอนจัดส่งด้วย
 * @author -
 */
public class AdminSale extends CommonDomain {
	
	private static final long serialVersionUID = -5225988093974579670L;
	private OrderMain orderMain = new OrderMain();
	private List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
	
	
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
