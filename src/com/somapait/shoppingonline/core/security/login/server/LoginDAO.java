package com.somapait.shoppingonline.core.security.login.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.config.parameter.domain.SQLPath;

import util.database.ConnectionUtil;
import util.database.SQLUtil;
import util.log.LogUtil;
import util.string.StringUtil;
import util.type.DatabaseType.DbType;
import util.type.StringType.ResultType;

public class LoginDAO {
	
	private SQLPath sqlPath = SQLPath.LOGIN_SQL;
	private DbType dbType;
	private Map<String, String> schemas = new HashMap<String, String>();

	public SQLPath getSqlPath() {
		return sqlPath;
	}
	public void setSqlPath(SQLPath sqlPath) {
		this.sqlPath = sqlPath;
	}
	
	protected CommonUser searchUserLogin(Connection conn, String username, String password) throws Exception {
		
		int paramIndex = 0;
	    Object[] params = new Object[2];
	    params[paramIndex++] = StringUtil.replaceSpecialString(username, dbType, ResultType.NULL);
        params[paramIndex++] = StringUtil.replaceSpecialString(password, dbType, ResultType.NULL);
		
        String sql = SQLUtil.getSQLString(schemas
	            , getSqlPath().getClassName()
	            , getSqlPath().getPath()
	            , "searchUserLogin"
	            , params);
	    LogUtil.LOGIN.debug("SQL : " + sql);
	    
	    CommonUser result = new CommonUser();
	    Statement stmt = null;
		ResultSet rst = null;
		try{
			stmt = conn.createStatement();
			rst = stmt.executeQuery(sql);
			
			if (rst.next()) {
				result.setUserId(StringUtil.nullToString(rst.getString("USER_ID")));
				result.setFullName(StringUtil.nullToString(rst.getString("FULLNAME")));
				result.setActive(StringUtil.nullToString(rst.getString("ADMIN")));
			 }
			
		}catch (Exception e) {
			throw e;
		}finally {
            ConnectionUtil.closeAll(rst, stmt);
        }
		return result;
	}
	
	protected long checkDupLogin(Connection conn, String username, String password) throws Exception {
		
		int count = 0;
	
		int paramIndex = 0;
	    Object[] params = new Object[2];
	    params[paramIndex++] = StringUtil.replaceSpecialString(username, dbType, ResultType.NULL);
        params[paramIndex++] = StringUtil.replaceSpecialString(password, dbType, ResultType.NULL);
		
        String sql = SQLUtil.getSQLString(schemas
	            , getSqlPath().getClassName()
	            , getSqlPath().getPath()
	            , "checkDupLogin"
	            , params);
	    LogUtil.LOGIN.debug("SQL : " + sql);
	    
	    
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
}
