package com.somapait.shoppingonline.web.shopping.admin.sale.action;

import java.sql.Connection;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.somapait.common.CommonAction;
import com.somapait.domain.Transaction;
import com.somapait.exception.AuthorizationException;
import com.somapait.interfaces.InterfaceAction;
import com.somapait.shoppingonline.core.config.parameter.domain.DBLookup;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSaleModel;
import com.somapait.shoppingonline.core.shopping.admin.sale.domain.AdminSaleSearch;
import com.somapait.shoppingonline.core.shopping.admin.sale.service.AdminSaleManager;

import util.database.ConnectionProvider;
import util.database.ConnectionUtil;


/**
 * @description Class ที่ใช้สำหรับ action ของเจ้าหน้าที่เท่านั้น
 * @author -
 *
 */
public class AdminSaleAction extends CommonAction implements ModelDriven<AdminSaleModel>, InterfaceAction{

	private static final long serialVersionUID = -1427160350963299925L;
	
	private AdminSaleModel model = new AdminSaleModel();

	@Override
	public String init() throws AuthorizationException {
		Connection conn = null;
		try {
			// สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
		} catch (Exception e) {
			
		}finally {
			getComboForSearch(conn);
			ConnectionUtil.close(conn);
		}
		return ReturnType.SEARCH.getResult();
	}

	@Override
	public void getComboForSearch(Connection conn) {
		try {
			AdminSaleManager manager = new AdminSaleManager(conn, null, getLocale());
			model.setListShip(manager.getListShip());
		} catch (Exception e) {
			
		}
	}

	@Override
	public void getComboForAddEdit(Connection conn) {
		try {
			AdminSaleManager manager = new AdminSaleManager(conn, null, getLocale());
			model.setListShip(manager.getListShip());
		} catch (Exception e) {
			
		}
	}

	@Override
	public String search() throws AuthorizationException {
		String result = null;
	    Connection conn = null;
	    try {	
	    	//1.สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
	        
	        //2.ตรวจสอบสิทธิ์การใช้งาน และจัดการเงือนไขที่ใช้ในการค้นหา
	        result = manageSearch(conn, model, model.getCriteria(), null);
	        
	        System.out.println("No   : " + model.getCriteria().getNo());
	        System.out.println("Ship : " + model.getCriteria().getShip());
	        
	        //3.การค้นหา
	        AdminSaleManager manager = new AdminSaleManager(conn, null, getLocale());
	        List<AdminSaleSearch> listResult = manager.search(model.getCriteria());
	        model.setListResult(listResult);
	        
	        //4.จัดการผลลัพธ์และข้อความ ถ้าไม่พบข้อมูล
	        manageSearchResult(model, listResult);
	        
	    }catch (Exception e) {
	    	manageException(conn, F_CODE, this, e, getModel());
		} finally {
			getComboForSearch(conn);
			ConnectionUtil.close(conn);
		}
		return result;
	}

	@Override
	public String gotoAdd() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoEdit() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoView() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateActive() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String export() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminSaleModel getModel() {
		return model;
	}
	
	public void setModel(AdminSaleModel model) {
		this.model = model;
	}
	
	public String gotoOrderList(){
		String result = null;
		try {
	        //1.ตรวจสอบสิทธิ์ หน้าเพิ่ม
	        result = ReturnType.SEARCH.getResult();
		} catch (Exception e) {
			
		}
		return result;
	}
}
