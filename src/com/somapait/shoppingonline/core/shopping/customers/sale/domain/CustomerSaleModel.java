package com.somapait.shoppingonline.core.shopping.customers.sale.domain;

import java.util.ArrayList;
import java.util.List;

import com.somapait.common.CommonModel;
import com.somapait.domain.SearchCriteria;

public class CustomerSaleModel extends CommonModel {

	private static final long serialVersionUID = -1549695679974322090L;
	
//	Data Type  ----------------------------------------------------------------------------
	private CustomerSaleSearchCriteria criteria = new CustomerSaleSearchCriteria();
	private CustomerSale customerSale = new CustomerSale();
	private List<CustomerSaleSearch> listResult = new ArrayList<CustomerSaleSearch>();
	
//	Getter and Setter ---------------------------------------------------------------------
	@Override
	public CustomerSaleSearchCriteria getCriteria() {
		return criteria;
	}
	@Override
	public void setCriteria(SearchCriteria criteria) {
		this.criteria = (CustomerSaleSearchCriteria) criteria;
	}
	
	public CustomerSale getCustomerSale() {
		return customerSale;
	}
	public void setCustomerSale(CustomerSale customerSale) {
		this.customerSale = customerSale;
	}
	
	public List<CustomerSaleSearch> getListResult() {
		return listResult;
	}
	public void setListResult(List<CustomerSaleSearch> listResult) {
		this.listResult = listResult;
	}
	
}
