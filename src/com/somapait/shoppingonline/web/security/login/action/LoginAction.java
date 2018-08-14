package com.somapait.shoppingonline.web.security.login.action;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Locale;

import util.database.ConnectionUtil;
import util.log.LogUtil;
import util.web.SessionUtil;

import com.opensymphony.xwork2.ModelDriven;
import com.somapait.common.CommonAction;
import com.somapait.common.CommonUser;
import com.somapait.domain.Operator;
import com.somapait.exception.AuthorizationException;
import com.somapait.shoppingonline.core.security.login.domain.LoginModel;

public class LoginAction extends CommonAction implements ModelDriven<LoginModel>{

	private static final long serialVersionUID = 6876443944132207688L;

	private LoginModel model = new LoginModel();

	public LoginAction() {
		super();
		try {
			LogUtil.LOGIN.debug("Language :- " + LOCALE.getLanguage());

		} catch (Exception e) {
			LogUtil.LOGIN.error("", e);
		}
	}

	public String init() throws AuthorizationException {
		Connection conn = null;
		try {
			//conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());

		} catch (Exception e) {
			manageException(conn, "0", this, e, model);
		} finally {
			ConnectionUtil.close(conn);
		}

		return ReturnType.INIT.getResult();
	}

	public String check() {
		LogUtil.LOGIN.info("");
		String result = ReturnType.INIT.getResult();

		try {
			CommonUser user = new CommonUser();
			user.setUserId("1");
			user.setLocale(new Locale("th"));


			SessionUtil.put(CommonUser.DEFAULT_SESSION_ATTRIBUTE, user);
			result = ReturnType.MAINPAGE.getResult();
		} catch (Exception e) {
			LogUtil.LOGIN.error("", e);
			setMessage(CommonAction.MessageType.ERROR, "Message error form server.", getErrorMessage(e), ResultType.BASIC);
		}
		return result;
	}

	public String logout(){
		//TODO
		return ReturnType.INIT.getResult();
	}

	@Override
	public LoginModel getModel() {
		return model;
	}

}
