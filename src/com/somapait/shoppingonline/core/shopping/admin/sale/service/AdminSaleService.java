package com.somapait.shoppingonline.core.shopping.admin.sale.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.somapait.abstracts.AbstractService;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.config.parameter.domain.SQLPath;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSale;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSaleSearch;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSaleSearchCriteria;
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
		this.dao.setSqlPath(SQLPath.SHOPPING_ADMIN);
	}
	
	protected int countData(Connection conn, AdminSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		int totalResult = 0;
	    try {
	        totalResult = dao.countData(conn, criteria, user, locale);
	    } catch (Exception e) {
	        throw e;
	    }
		return totalResult;
	}
	
	protected List<AdminSaleSearch> search(Connection conn, AdminSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		List<AdminSaleSearch> listResult = new ArrayList<AdminSaleSearch>();
		try{
			listResult = dao.search(conn, criteria, user, locale);
		}catch (Exception e) {
			throw e;
		}
		return listResult;
	}
	
	protected AdminSale searchById(Connection conn, String id, CommonUser user, Locale locale) throws Exception {
		AdminSale result = new AdminSale();
		try{
			result = dao.searchById(conn, id, user, locale);
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	protected int edit(Connection conn, AdminSale obj, CommonUser user, Locale locale) throws Exception {
		int id = 0;
		try {
			id = dao.edit(conn, obj, user, locale);
		} catch (Exception e) {
			throw e;
		}
		return id;
	}

}
