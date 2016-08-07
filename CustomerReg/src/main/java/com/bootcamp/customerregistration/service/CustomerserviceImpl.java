package com.bootcamp.customerregistration.service;

/*import javax.jws.WebService;*/

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.customerregistration.dao.CustomerDao;
import com.bootcamp.customerregistration.dao.CustomerDaoImpl;
import com.bootcamp.customerregistration.model.Customer;

@Service
/*@WebService(endpointInterface = "com.bootcamp.customerregistration.service.CustomerService", serviceName = "custService")*/
public class CustomerserviceImpl implements CustomerService{
	@Autowired
	private CustomerDao storeDao;

	@Override
	
@Transactional
	public String addCustomer(Customer cust) {
		
		return this.storeDao.addCustomer(cust);
	}
	
	@Transactional
	public int getCustomerid(Customer cust)
	{
	return this.storeDao.getCustomerid(cust);
	
	}
	
	
}
