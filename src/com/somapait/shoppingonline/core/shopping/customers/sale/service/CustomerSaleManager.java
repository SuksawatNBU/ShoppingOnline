package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.somapait.abstracts.AbstractManager;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSale;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearchCriteria;

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
