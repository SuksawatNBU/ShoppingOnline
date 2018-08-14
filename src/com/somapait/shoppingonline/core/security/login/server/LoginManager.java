package com.somapait.shoppingonline.core.security.login.server;

import java.sql.Connection;

import com.somapait.common.CommonUser;

public class LoginManager{
	/*private Connection conn = null;
	private LoginDAO dao = null;

	public LoginManager(Connection conn) {
		this.conn = conn;
		this.dao = new LoginDAO();
	}*/
	
	private Connection conn = null;
	private LoginService service = null;
	
	public LoginManager(Connection conn) {
		this.conn = conn;
		this.service = new LoginService(conn, null, null);
	}
	
	public CommonUser searchUserLogin(String username, String password) throws Exception {
		CommonUser result = new CommonUser();
		try{
			result = service.searchUserLogin(conn, username, password);
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
}
