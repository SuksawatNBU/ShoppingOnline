package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.somapait.abstracts.AbstractService;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.config.parameter.domain.SQLPath;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSale;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearchCriteria;
import com.somapait.shoppingonline.core.shopping.domain.OrderDetail;
import com.somapait.shoppingonline.core.shopping.domain.OrderMain;
import com.somapait.shoppingonline.core.shopping.domain.Product;

/**
 * @description Class สำหรับจัดการ logic or algorithm (ถ้ามี)
 * @author -
 *
 */
public class CustomerSaleService extends AbstractService {

	private CustomerSaleDAO dao;
	
	public CustomerSaleService(Connection conn, CommonUser user, Locale locale) {
		super(conn, user, locale);
		this.dao = new CustomerSaleDAO();
		this.dao.setSqlPath(SQLPath.SHOPPING_CUSROMER);
	}
	
	protected int countData(Connection conn, CustomerSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		int totalResult = 0;
	    try {
	        totalResult = dao.countData(conn, criteria, user, locale);
	    } catch (Exception e) {
	        throw e;
	    }
		return totalResult;
	}
	
	protected List<CustomerSaleSearch> searchProductList(Connection conn, CustomerSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		List<CustomerSaleSearch> listResult = new ArrayList<CustomerSaleSearch>();
		try{
			listResult = dao.searchProductList(conn, criteria, user, locale);
		}catch (Exception e) {
			throw e;
		}
		return listResult;
	}
	
	protected CustomerSale searchById(Connection conn, String id, CommonUser user, Locale locale) throws Exception {
		CustomerSale result = new CustomerSale();
		try{
			result = dao.searchById(conn, id, user, locale);
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	protected Product searchProductById(Connection conn, String id, CommonUser user, Locale locale) throws Exception {
		Product result = new Product();
		try{
			result = dao.searchProductById(conn, id, user, locale);
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	protected int addOrderMain(Connection conn, OrderMain obj, CommonUser user, Locale locale) throws Exception {
		int id = 0;
		try {
			//1. สร้างรหัสรายการสั่งซื้อ
			boolean checkDup = false;
			String code = "";
			do{
				code = genOrderNumber(); // gen code
				checkDup = dao.checkDupOrderNumber(conn, code); // check dup
				if(checkDup == false){
					
				}
			}while(checkDup != false);
			obj.setNo(code);
			
			//2. insert ข้อมูล พร้อมกับ return id
			id = dao.addOrderMain(conn, obj, user, locale);
		} catch (Exception e) {
			throw e;
		}
		return id;
	}
	
	protected int addOrderDetail(Connection conn, OrderDetail obj, CommonUser user, Locale locale) throws Exception {
		int id = 0;
		try {
			id = dao.addOrderDetail(conn, obj, user, locale);
		} catch (Exception e) {
			throw e;
		}
		return id;
	}
	
	protected int searchOrderNumberById(Connection conn, String id) throws Exception{
		int orderNumber = 0;
		try {
			orderNumber = dao.searchOrderNumberById(conn, id);
		} catch (Exception e) {
			throw e;
		}
		return orderNumber;
	}
	
	private String genOrderNumber() {
		Random random = new Random ();
		String code = "";
		
		for(int i = 0; i < 9 ; i++){
			code += random.nextInt(9);
		}
		return code;
	}

}
