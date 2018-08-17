package com.somapait.shoppingonline.web.shopping.customers.sale.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.somapait.common.CommonAction;
import com.somapait.domain.Transaction;
import com.somapait.exception.AuthorizationException;
import com.somapait.interfaces.InterfaceAction;
import com.somapait.shoppingonline.core.config.parameter.domain.DBLookup;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSale;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleModel;
import com.somapait.shoppingonline.core.shopping.customers.sale.domain.CustomerSaleSearch;
import com.somapait.shoppingonline.core.shopping.customers.sale.service.CustomerSaleManager;
import com.somapait.shoppingonline.core.shopping.domain.OrderProductCart;
import com.somapait.shoppingonline.core.shopping.domain.Product;

import util.database.ConnectionProvider;
import util.database.ConnectionUtil;
import util.log.LogUtil;

/**
 * @description Class ที่ใช้สำหรับ action ของลูกค้าท่านั้น
 * @author -
 *
 */
public class CustomerSaleAction extends CommonAction implements ModelDriven<CustomerSaleModel>, InterfaceAction{

	private static final long serialVersionUID = -1195418747257577141L;
	public static final String DEFAULT_SESSION_ATTRIBUTE_ORDER = "order";
	
	private CustomerSaleModel model = new CustomerSaleModel();
	
	@Override
	public CustomerSaleModel getModel() {
		if(model.getListResult() == null){
			try {
				searchProductList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		try {
		} catch (Exception e) {
			
		}
		return ReturnType.INIT.getResult();
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
	public String searchProductList() throws Exception{
		String result = null;
	    Connection conn = null;
	    try {	
	    	//1. สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
	        
	        //2. ตรวจสอบสิทธิ์การใช้งาน และจัดการเงือนไขที่ใช้ในการค้นหา
	        result = manageSearch(conn, model, model.getCriteria(), null);
	        
	        //3. get parameter in url 
	        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	        model.getCriteria().setTypeId(request.getParameter("typeId"));

	        //4. การค้นหา
	        CustomerSaleManager manager = new CustomerSaleManager(conn, null, getLocale());
	        List<CustomerSaleSearch> listResult = manager.searchProductList(model.getCriteria());
	        model.setListResult(listResult);
	        
	        //5.จัดการผลลัพธ์และข้อความ ถ้าไม่พบข้อมูล
	        manageSearchResult(model, listResult);
	        
	    }catch (Exception e) {
	    	//6.
	    	manageException(conn, F_CODE, this, e, getModel());
		} finally {
			//7. 
			ConnectionUtil.close(conn);
		}
		return result;
			
	}
		
	//TODO method addToCartAjax() สำหรับจัดการเก็บรายการสินค้าที่ต้องการลงบน session
	public String addToCartAjax() throws Exception {
		String result = null;
	    Connection conn = null;
	    try {
	    	//1.สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
	        
	        //2.ตรวจสอบสิทธิ์การใช้งาน และจัดการเงือนไข
	        manageAdd(conn, model);
	        result = ReturnType.SEARCH.getResult();
	        
	        //3. ค้นหาข้อมูล ตาม id
	        CustomerSaleManager manager = new CustomerSaleManager(conn, null, getLocale());
	        Product product = manager.searchProductById(model.getCustomerSale().getId());
	        
	        System.out.println("id : " + model.getCustomerSale().getId());
	        
	        OrderProductCart.put(DEFAULT_SESSION_ATTRIBUTE_ORDER, product);
	        
	        Product product2 = (Product) OrderProductCart.get(DEFAULT_SESSION_ATTRIBUTE_ORDER);
	        System.out.println("id-Session : " + product2.getId());
	        
	    }catch (Exception e) {
	    	manageException(conn, F_CODE, this, e, getModel());
		} finally {
			ConnectionUtil.close(conn);
		}
		return result;
	}

	//TODO method gotoMyCartAdd() สำหรับแสดงรายการสินค้าที่อยู่ใน session โดยกำหนดให้ default จำนวนรายการเป็น 1 จำนวน
	public String gotoMyCartAdd() throws Exception {
		String result = null;
	    Connection conn = null;
	    try {
	    	//1.สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
	        
	        //2.
	        result = manageGotoAdd(conn, model);
	        
	        /*List<CustomerSale> customerSale = new ArrayList<CustomerSale>();*/
	        
	    }catch (Exception e) {
	    	manageException(conn, F_CODE, this, e, getModel());
		} finally {
			ConnectionUtil.close(conn);
		}
		return result;
	}

	//TODO method add() สำหรับทำรายการสั่งซื้อ
	@Override
	public String add() throws AuthorizationException {
		String result = null;
	    Connection conn = null;
	    try {
	    	//1.สร้าง connection โดยจะต้องระบุ lookup ที่ใช้ด้วย
	        conn = new ConnectionProvider().getConnection(conn, DBLookup.MYSQL_TEST.getLookup());
	        
	        //2.ตรวจสอบสิทธิ์การใช้งาน และจัดการเงือนไข
	        result = manageAdd(conn, model);
	        
	        //3.บันทึกข้อมูล และ retuen เลขที่ใบสั่งซื้อ
	        CustomerSaleManager manager = new CustomerSaleManager(conn, null, getLocale());
	        int orderNumber = manager.add(model.getCustomerSale());
	        model.getCustomerSale().getOrderMain().setNo(String.valueOf(orderNumber));
	        
	        //4.เคลียร์ค่าหน้าเพิ่มทั้งหมด
	        model.setCustomerSale(new CustomerSale());
	        
	    }catch (Exception e) {
	    	manageException(conn, F_CODE, this, e, getModel());
		} finally {
			ConnectionUtil.close(conn);
		}
		return result;
	}
}
