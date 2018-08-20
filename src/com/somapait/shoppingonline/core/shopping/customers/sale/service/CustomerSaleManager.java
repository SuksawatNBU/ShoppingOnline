package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.somapait.abstracts.AbstractManager;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSale;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearchCriteria;
import com.somapait.shoppingonline.core.shopping.domain.OrderDetail;
import com.somapait.shoppingonline.core.shopping.domain.OrderMain;
import com.somapait.shoppingonline.core.shopping.domain.OrderProductCart;
import com.somapait.shoppingonline.core.shopping.domain.Product;

import util.log.LogUtil;

/**
 * @description Class สำหรับจัดการการทำงานต่างๆ แยกตาม module
 * @author -
 *
 */
public class CustomerSaleManager extends AbstractManager<CustomerSaleSearchCriteria, CustomerSaleSearch, CustomerSale, CommonUser, Locale>{

	private CustomerSaleService service;
	
	public CustomerSaleManager(Connection conn, CommonUser user, Locale locale) {
		super(conn, user, locale);
		service = new CustomerSaleService(conn, user, locale);
	}

	@Override
	public List<CustomerSaleSearch> search(CustomerSaleSearchCriteria criteria) throws Exception {
		return null;
	}
	
	//TODO method searchProductList(CustomerSearchCriteria criteria) สำหรับค้นหาและแสดงรายการสินค้าแต่ละประเภทที่เลือกจากเมนู
	public List<CustomerSaleSearch> searchProductList(CustomerSaleSearchCriteria criteria) throws Exception {
		List<CustomerSaleSearch> listResult = new ArrayList<CustomerSaleSearch>();
		try{
			criteria.setTotalResult(service.countData(conn, criteria, user, locale));
			LogUtil.SELECTOR.debug("COUNT DATA [" + criteria.getTotalResult() + "] record.");
			
			if (criteria.getTotalResult() == 0) {
				// Nothing
			} else {
	        	// ค้นหาข้อมูล
	        	listResult = service.searchProductList(conn, criteria, user, locale);
	        }
		}catch (Exception e) {
			LogUtil.SELECTOR.debug("Eror : ",e);
			throw e;
		}
		return listResult;
	}

	@Override
	public CustomerSale searchById(String id) throws Exception {
		CustomerSale result = new CustomerSale();
		try{
			result = service.searchById(conn, id, user, locale);
	    
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public Product searchProductById(String id) throws Exception {
		Product result = new Product();
		try{
			result = service.searchProductById(conn, id, user, locale);
	    
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public CustomerSale searchProductByIds(String id) throws Exception {
		CustomerSale result = new CustomerSale();
		try{
			result = service.searchProductByIds(conn, id, user, locale);
	    
		}catch (Exception e) {
			throw e;
		}
		return result;
	}

	//TODO method add(CustomerSale customerSale) สำหรับทำรายการสั่งซื้อ
	@Override
	public int add(CustomerSale obj) throws Exception {
		int orderNumber = 0;
		try {
	        //1.Begin transaction
	        conn.setAutoCommit(false);
	        
	        //2.เพิ่มข้อมูล OrderMain
	        int id = service.addOrderMain(conn, obj.getOrderMain(), user, locale);
	        
	        //3. วนลุปเพื่อเพิ่ม OrderDetail
	        for(OrderDetail orderDetail : obj.getListOrderDetail()){
	        	orderDetail.setOrderId(String.valueOf(id));
	        	service.addOrderDetail(conn, orderDetail, user, locale);
	        }
	        
	        //4. Commit transaction
	        conn.commit();
	        
	        //5. Search Order Number
	        orderNumber = service.searchOrderNumberById(conn, String.valueOf(id));
	        
	    } catch (Exception e) {
	        //5. Rollback transaction เมื่อเกิด Error
	        conn.rollback();
	        throw e;
	    } finally {
	        //6. Set AutoCommit กลับคืนเป็น True
	        conn.setAutoCommit(true);
	    }
		return orderNumber;
	}

	@Override
	public int edit(CustomerSale obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String ids) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateActive(String ids, String activeFlag) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void addOrderProductInSession(String id){
		final String orderProduct = OrderProductCart.orderProduct;
		String order = OrderProductCart.get(orderProduct);
		if(order != null) {
			order += "," + id;
		}else{
			order = id;
		}
		
		System.out.println("=======================================");
		System.out.println("order : " + order);
		
		OrderProductCart.put(orderProduct, order);
	}


	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PG_EXAM_SHOPPING","root","86202");
		} catch (SQLException e1) {}
		
		CustomerSaleManager csm = new CustomerSaleManager(conn, null, null);
		
		// Test Add -------------------------------------------
		CustomerSale obj = new CustomerSale();
		OrderMain om;
		OrderDetail od;
		List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
		
		om = new OrderMain();
		om.setTotalPrice("8000");
		om.setUserId("6");
		om.setOrderDate("20181608");
		obj.setOrderMain(om);
		
		od = new OrderDetail();
		od.setProductId("1");
		od.setTotalNum("4");
		od.setTotalPrice("6000");
		listOrderDetail.add(od);
		
		od = new OrderDetail();
		od.setProductId("5");
		od.setTotalNum("2");
		od.setTotalPrice("2000");
		listOrderDetail.add(od);
		obj.setListOrderDetail(listOrderDetail);
		
		try {
			csm.add(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Test Add Off -------------------------------------------
	}

}
