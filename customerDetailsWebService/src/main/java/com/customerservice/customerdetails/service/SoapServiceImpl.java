package com.customerservice.customerdetails.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.customerservice.customerdetails.dao.ServiceDao;
import com.customerservice.customerdetails.dao.ServiceDaoImpl;
import com.customerservice.customerdetails.model.ServicePlan;


@WebService
public class SoapServiceImpl  {

	//@Autowired
	private ServiceDao serviceDao;

	
	@WebMethod
	public List<ServicePlan> getServicePlans() {
		
		ServiceDaoImpl sdl = new ServiceDaoImpl();
		
		List<ServicePlan> ls = sdl.getServicePlans();
		
		System.out.println(ls.get(0));
		
		return ls;

		//return this.serviceDao.getServicePlans();
					
	}
	
	

}
