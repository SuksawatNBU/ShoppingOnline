package com.somapait.shoppingonline.core.shopping.admin.sale.domain;

import java.util.ArrayList;
import java.util.List;

import com.somapait.common.CommonModel;
import com.somapait.common.CommonSelectItem;
import com.somapait.domain.SearchCriteria;

public class AdminSaleModel extends CommonModel{

	private static final long serialVersionUID = 4131603807845961292L;
	
//	Data Type  ----------------------------------------------------------------------------
	private AdminSaleSearchCriteria criteria = new AdminSaleSearchCriteria();
	private AdminSale adminSale = new AdminSale();
	private List<AdminSaleSearch> listResult = new ArrayList<AdminSaleSearch>();
	private List<CommonSelectItem> listShip = new ArrayList<CommonSelectItem>();
	
	
//	Getter and Setter ---------------------------------------------------------------------
	@Override
	public AdminSaleSearchCriteria getCriteria() {
		return criteria;
	}
	@Override
	public void setCriteria(SearchCriteria criteria) {
		this.criteria = (AdminSaleSearchCriteria) criteria;
	}
	
	public AdminSale getAdminSale() {
		return adminSale;
	}
	public void setAdminSale(AdminSale adminSale) {
		this.adminSale = adminSale;
	}
	public List<CommonSelectItem> getListShip() {
		return listShip;
	}
	public void setListShip(List<CommonSelectItem> listShip) {
		this.listShip = listShip;
	}
	public List<AdminSaleSearch> getListResult() {
		return listResult;
	}
	public void setListResult(List<AdminSaleSearch> listResult) {
		this.listResult = listResult;
	}
	
	
}
