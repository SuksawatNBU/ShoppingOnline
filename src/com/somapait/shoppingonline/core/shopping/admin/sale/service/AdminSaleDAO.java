package com.somapait.shoppingonline.core.shopping.admin.sale.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.somapait.abstracts.AbstractDAO;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSale;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSaleSearch;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSaleSearchCriteria;

import util.database.ConnectionUtil;
import util.database.SQLUtil;
import util.log.LogUtil;
import util.string.StringUtil;
import util.type.DatabaseType.DbType;
import util.type.StringType.ResultType;

/**
 * @description Class สำหรับติดต่อกับฐานข้อมูล
 * @author -
 *
 */
public class AdminSaleDAO  extends AbstractDAO<AdminSaleSearchCriteria, AdminSaleSearch, AdminSale, CommonUser, Locale> {

	private DbType dbType;
	private Map<String, String> schemas = new HashMap<String, String>();
	
	@Override
	protected int countData(Connection conn, AdminSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		int count = 0;
		
		int paramIndex = 0;
		Object[] params = new Object[2];
		params[paramIndex++] = StringUtil.replaceSpecialString(criteria.getNo(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(criteria.getShip(), dbType, ResultType.NULL);
        
		String sql = SQLUtil.getSQLString(schemas
                , getSqlPath().getClassName()
                , getSqlPath().getPath()
                , "countData"
                , params);
        LogUtil.SELECTOR.debug("SQL : " + sql);
        
        Statement stmt = null;
        ResultSet rst = null;
        try{
        	stmt = conn.createStatement();
            rst = stmt.executeQuery(sql);
            if (rst.next()) {
            	 count = rst.getInt("TOT");
            }
        }catch (Exception e) {
        	throw e;
		}finally {
			ConnectionUtil.closeAll(rst, stmt);
		}
		return count;
	}

	@Override
	protected List<AdminSaleSearch> search(Connection conn, AdminSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		List<AdminSaleSearch> listResult = new ArrayList<AdminSaleSearch>();
		
		int paramIndex = 0;
		Object[] params = new Object[4];
		params[paramIndex++] = StringUtil.replaceSpecialString(criteria.getNo(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(criteria.getShip(), dbType, ResultType.NULL);
		params[paramIndex++] = criteria.getStart() - 1;
        params[paramIndex++] = criteria.getLinePerPage();
        
		String sql = SQLUtil.getSQLString(schemas
                , getSqlPath().getClassName()
                , getSqlPath().getPath()
                , "searchOrderMain"
                , params);
        LogUtil.SELECTOR.debug("SQL : " + sql);
        
        Statement stmt = null;
        ResultSet rst = null;
        try{
        	stmt = conn.createStatement();
            rst = stmt.executeQuery(sql);
            while (rst.next()) {
            	AdminSaleSearch result = new AdminSaleSearch();
            	result.setId(StringUtil.nullToString(rst.getString("ID")));
            	result.setNo(StringUtil.nullToString(rst.getString("NO")));
            	result.setTotalPrice(StringUtil.nullToString(rst.getString("TOTAL_PRICE")));
            	result.setOrderDate(StringUtil.nullToString(rst.getString("ORDER_DATE")));
            	result.setShip(StringUtil.nullToString(rst.getString("SHIP")));
            	result.setShipDate(StringUtil.nullToString(rst.getString("SHIP_DATE")));
            	result.setTrackingNo(StringUtil.nullToString(rst.getString("TRACKING_NO")));
            	result.setUserId(StringUtil.nullToString(rst.getString("USER_ID")));
            	result.setFullName(StringUtil.nullToString(rst.getString("FIRST_NAME")) + " " + StringUtil.nullToString(rst.getString("LAST_NAME")));
            	listResult.add(result);
            }
        }catch (Exception e) {
        	throw e;
		}finally {
			ConnectionUtil.closeAll(rst, stmt);
		}
		return listResult;
	}

	@Override
	protected AdminSale searchById(Connection conn, String id, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int add(Connection conn, AdminSale obj, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int edit(Connection conn, AdminSale obj, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int delete(Connection conn, String ids, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int updateActive(Connection conn, String ids, String activeFlag, CommonUser user, Locale locale)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean checkDup(Connection conn, AdminSale obj, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
