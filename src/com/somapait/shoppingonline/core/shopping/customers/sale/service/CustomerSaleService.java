package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.somapait.abstracts.AbstractService;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.config.parameter.domain.SQLPath;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearchCriteria;

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
	
	protected List<CustomerSaleSearch> search(Connection conn, CustomerSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		return null;
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
	
	
	
	
	
	

}
