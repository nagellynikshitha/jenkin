package com.bootcamp.customerregistration.service;
/*
import javax.jws.WebMethod;
import javax.jws.WebService;*/

import com.bootcamp.customerregistration.model.Customer;

/*@WebService*/
public interface CustomerService {

	public String addCustomer(Customer cust);

	public int getCustomerid(Customer cust);
	
	/*public String getCustomerbyID(int id);*/

}