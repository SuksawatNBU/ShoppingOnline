package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.util.List;
import java.util.Locale;

import com.somapait.abstracts.AbstractManager;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSale;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearchCriteria;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerSale searchById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(CustomerSale obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
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

	//TODO method searchProductList(CustomerSearchCriteria criteria) สำหรับค้นหาและแสดงรายการสินค้าแต่ละประเภทที่เลือกจากเมนู


	//TODO method add(CustomerSale customerSale) สำหรับทำรายการสั่งซื้อ

}
