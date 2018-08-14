package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.util.Locale;

import com.somapait.abstracts.AbstractService;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.config.parameter.domain.SQLPath;

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
		this.dao.setSqlPath(SQLPath.SHOPPING);
	}
	
	

}
