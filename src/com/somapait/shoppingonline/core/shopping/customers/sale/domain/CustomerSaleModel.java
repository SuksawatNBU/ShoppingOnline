package com.somapait.shoppingonline.core.shopping.customers.sale.domain;

import com.somapait.common.CommonModel;
import com.somapait.domain.SearchCriteria;

public class CustomerSaleModel extends CommonModel {

	private static final long serialVersionUID = -1549695679974322090L;
	
//	Data Type  ----------------------------------------------------------------------------
	private CustomerSaleSearchCriteria criteria = new CustomerSaleSearchCriteria();
	private CustomerSale customerSale = new CustomerSale();
	
	
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
}
