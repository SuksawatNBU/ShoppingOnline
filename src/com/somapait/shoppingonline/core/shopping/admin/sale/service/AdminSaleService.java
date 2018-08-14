package com.somapait.shoppingonline.core.shopping.admin.sale.service;

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
public class AdminSaleService extends AbstractService {

	private AdminSaleDAO dao;
	
	public AdminSaleService(Connection conn, CommonUser user, Locale locale) {
		super(conn, user, locale);
		this.dao = new AdminSaleDAO();
		this.dao.setSqlPath(SQLPath.SHOPPING);
	}

}
