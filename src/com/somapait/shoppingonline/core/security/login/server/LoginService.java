package com.somapait.shoppingonline.core.security.login.server;

import java.sql.Connection;
import java.util.Locale;

import com.somapait.abstracts.AbstractService;
import com.somapait.common.CommonUser;
import com.somapait.shoppingonline.core.config.parameter.domain.SQLPath;

public class LoginService extends AbstractService {
	
	private LoginDAO dao;
	
	public LoginService(Connection conn, CommonUser user, Locale locale) {
		super(conn, user, locale);
		dao = new LoginDAO();
		this.dao.setSqlPath(SQLPath.LOGIN_SQL);
	}
	
	protected CommonUser searchUserLogin(Connection conn, String username, String password) throws Exception {
		CommonUser result = new CommonUser();
		try{
			result = dao.searchUserLogin(conn, username, password);
		}catch (Exception e) {
			throw e;
		}
		return result;
		
	}

}
