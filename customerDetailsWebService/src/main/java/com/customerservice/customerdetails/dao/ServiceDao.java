package com.customerservice.customerdetails.dao;

import java.util.List;

import com.customerservice.customerdetails.model.Customer;
import com.customerservice.customerdetails.model.ServicePlan;


public interface ServiceDao {

	public List<ServicePlan> getServicePlans();
	
	public Customer getCustomerDAO(int c_id);
}
