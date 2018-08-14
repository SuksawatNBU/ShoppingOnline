package com.somapait.shoppingonline.web.shopping.customers.sale.action;

import java.sql.Connection;

import com.opensymphony.xwork2.ModelDriven;
import com.somapait.common.CommonAction;
import com.somapait.domain.Transaction;
import com.somapait.exception.AuthorizationException;
import com.somapait.interfaces.InterfaceAction;
import com.somapait.shoppingonline.core.config.parameter.domain.DBLookup;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleModel;

import util.database.ConnectionProvider;
import util.log.LogUtil;

/**
 * @description Class ที่ใช้สำหรับ action ของลูกค้าท่านั้น
 * @author -
 *
 */
public class CustomerSaleAction extends CommonAction implements ModelDriven<CustomerSaleModel>, InterfaceAction{

	private static final long serialVersionUID = -1195418747257577141L;
	
	private CustomerSaleModel model = new CustomerSaleModel();
	
	@Override
	public CustomerSaleModel getModel() {
		return model;
	}

	public CustomerSaleAction(){
		try {
	        //Load authorization
	        /*getAuthorization(PFCode.SECURITY_USER);*/
	    } catch (Exception e) {
	        LogUtil.INITIAL.error("", e);
	    }
	}

	@Override
	public String init() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getComboForSearch(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getComboForAddEdit(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String search() throws AuthorizationException {
		// TODO Auto-generated method stub
		return null;
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

	

	//TODO method searchProductList() สำหรับค้นหาและแสดงรายการสินค้าแต่ละประเภทที่เลือกจากเมนู โดยรับค่าประเภทสินค้าจาก url แล้วแสดงรายการตามประเภทที่เลือก
	public String searchProductList(){
		String result = null;
	    Connection conn = null;
	    
	    try {
	    	//1.สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
	        
	        //2.ตรวจสอบสิทธิ์การใช้งาน และจัดการเงือนไขที่ใช้ในการค้นหา
	        /*result = manageSearch(conn, model, model.getCriteria(), PFCode.SECURITY_USER.getSearchFunction());*/
	        
	    }catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	    
	    
		return null;
			
	}
		
	//TODO method addToCartAjax() สำหรับจัดการเก็บรายการสินค้าที่ต้องการลงบน session


	//TODO method gotoMyCartAdd() สำหรับแสดงรายการสินค้าที่อยู่ใน session โดยกำหนดให้ default จำนวนรายการเป็น 1 จำนวน


	//TODO method add() สำหรับทำรายการสั่งซื้อ

}
