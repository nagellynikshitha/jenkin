package com.bootcamp.customerregistration.dao;

import com.bootcamp.customerregistration.model.Customer;

public interface CustomerDao {
	
	public String addCustomer(Customer cust);

	public int getCustomerid(Customer cust);
	
/*	public  Customer getCustomerByid(int id);*/
	
}
