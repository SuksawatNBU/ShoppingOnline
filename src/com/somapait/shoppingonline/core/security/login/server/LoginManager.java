package com.somapait.shoppingonline.core.security.login.server;

import java.sql.Connection;

public class LoginManager {
	private Connection conn = null;
	private LoginDAO dao = null;

	public LoginManager(Connection conn) {
		this.conn = conn;
		this.dao = new LoginDAO();
	}
}
