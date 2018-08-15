package com.somapait.shoppingonline.core.shopping.customers.sale.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.somapait.abstracts.AbstractDAO;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSale;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearchCriteria;
import com.somapait.shoppingonline.core.shopping.domain.OrderDetail;
import com.somapait.shoppingonline.core.shopping.domain.OrderMain;

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
public class CustomerSaleDAO extends AbstractDAO<CustomerSaleSearchCriteria, CustomerSaleSearch, CustomerSale, CommonUser, Locale> {

	private DbType dbType;
	private Map<String, String> schemas = new HashMap<String, String>();
	
	@Override
	protected int countData(Connection conn, CustomerSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		int count = 0;
		
		int paramIndex = 0;
	    Object[] params = new Object[1];
	    params[paramIndex++] = StringUtil.replaceSpecialString(criteria.getTypeId(), dbType, ResultType.NULL);
		
	    String sql = SQLUtil.getSQLString(schemas
                , getSqlPath().getClassName()
                , getSqlPath().getPath()
                , "countProduct"
                , params);
        LogUtil.SELECTOR.debug("SQL : " + sql);
        
        Statement stmt = null;
	    ResultSet rst = null;
	    try {
	        stmt = conn.createStatement();
	        rst = stmt.executeQuery(sql);
	        if (rst.next()) {
	            count = rst.getInt("TOT");
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        ConnectionUtil.closeAll(rst, stmt);
	    }
	    return count;
	}

	@Override
	protected List<CustomerSaleSearch> search(Connection conn, CustomerSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		return null;
	}
	
	@Override
	protected CustomerSale searchById(Connection conn, String id, CommonUser user, Locale locale) throws Exception {
		return null;
	}

	@Override
	protected int add(Connection conn, CustomerSale obj, CommonUser user, Locale locale) throws Exception {
		return 0;
	}

	@Override
	protected int edit(Connection conn, CustomerSale obj, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int delete(Connection conn, String ids, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int updateActive(Connection conn, String ids, String activeFlag, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean checkDup(Connection conn, CustomerSale obj, CommonUser user, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected List<CustomerSaleSearch> searchProductList(Connection conn, CustomerSaleSearchCriteria criteria, CommonUser user, Locale locale) throws Exception {
		
		List<CustomerSaleSearch> listResult = new ArrayList<CustomerSaleSearch>();
		
		int paramIndex = 0;
		Object[] params = new Object[1];
		params[paramIndex++] = StringUtil.replaceSpecialString(criteria.getTypeId(), dbType, ResultType.NULL);
        
		String sql = SQLUtil.getSQLString(schemas
                , getSqlPath().getClassName()
                , getSqlPath().getPath()
                , "searchProduct"
                , params);
        LogUtil.SELECTOR.debug("SQL : " + sql);
        
        Statement stmt = null;
        ResultSet rst = null;
        try{
        	stmt = conn.createStatement();
            rst = stmt.executeQuery(sql);
            while (rst.next()) {
            	CustomerSaleSearch result = new CustomerSaleSearch();
            	result.setId(StringUtil.nullToString(rst.getString("ID")));
            	result.setCode(StringUtil.nullToString(rst.getString("CODE")));
            	result.setProductDesc(StringUtil.nullToString(rst.getString("PRODUCT_DESC")));
            	result.setPrice(StringUtil.nullToString(rst.getString("PRICE")));
            	result.setStockNum(StringUtil.nullToString(rst.getString("STOCK_NUM")));
            	result.setImage(StringUtil.nullToString(rst.getString("IMAGE")));
            	result.setTypeId(StringUtil.nullToString(rst.getString("TYPE_ID")));
            	result.setTypeDesc(StringUtil.nullToString(rst.getString("TYPE_DESC")));
            	result.setSeq(StringUtil.nullToString(rst.getString("SEQ")));
            	listResult.add(result);
            }
        }catch (Exception e) {
        	throw e;
		}finally {
			ConnectionUtil.closeAll(rst, stmt);
		}
		return listResult;
	}
	
	protected int addOrderMain(Connection conn, OrderMain obj, CommonUser user, Locale locale) throws Exception {
		int id = 0;
		int paramIndex = 0;
		Object[] params = new Object[8];
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getTotalPrice(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(user.getUserId(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getOrderDate(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getShip(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getShipDate(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getTrackingNo(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getCancel(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getNote(), dbType, ResultType.NULL);
        
		String sql = SQLUtil.getSQLString(schemas
                , getSqlPath().getClassName()
                , getSqlPath().getPath()
                , "insertOrderMain"
                , params);
        LogUtil.SELECTOR.debug("SQL : " + sql);
        
        try{
        	id = executeInsertStatement(conn, sql);
        }catch (Exception e) {
        	throw e;
		}
        
		return id;
	}
	
	protected int addOrderDetail(Connection conn, OrderDetail obj, CommonUser user, Locale locale) throws Exception {
		int id = 0;
		int paramIndex = 0;
		Object[] params = new Object[4];
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getProductId(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getTotalNum(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getTotalPrice(), dbType, ResultType.NULL);
		params[paramIndex++] = StringUtil.replaceSpecialString(obj.getOrderId(), dbType, ResultType.NULL);
        
		String sql = SQLUtil.getSQLString(schemas
                , getSqlPath().getClassName()
                , getSqlPath().getPath()
                , "insertOrderDetail"
                , params);
        LogUtil.SELECTOR.debug("SQL : " + sql);
        
        try{
        	id = executeInsertStatement(conn, sql);
        }catch (Exception e) {
        	throw e;
		}
        
		return id;
	}
	
	public int executeInsertStatement(Connection conn, String sql) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet keys = null;
		int id = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();

			keys = pstmt.getGeneratedKeys();
			if (keys.next()) {
				id = keys.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeResultSet(keys);
			ConnectionUtil.closePreparedStatement(pstmt);
		}
		return id;
	}
	
	
	/*public static void main(String[] args) {
		CustomerSaleDAO dao = new CustomerSaleDAO();
		dao.setSqlPath(SQLPath.SHOPPING_CUSROMER);
		Connection conn = null;
		CustomerSaleSearchCriteria criteria = new CustomerSaleSearchCriteria();
		
		//test : searchProductList
		try {
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PG_EXAM_SHOPPING","root","86202");
			 criteria.setTypeId("1");
			dao.searchProductList(conn, criteria, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	
}
