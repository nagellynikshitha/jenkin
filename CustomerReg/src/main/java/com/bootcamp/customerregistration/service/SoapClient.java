package com.bootcamp.customerregistration.service;

import java.util.List;

import com.customerservice.customerdetails.service.ServicePlan;
import com.customerservice.customerdetails.service.SoapServiceImpl;
import com.customerservice.customerdetails.service.SoapServiceImplService;

public class SoapClient {

	public List<ServicePlan> getServices() {

		SoapServiceImplService soapser = new SoapServiceImplService();

		SoapServiceImpl splport = soapser.getSoapServiceImplPort();

		List<ServicePlan> srlist = splport.getServicePlans();

		return srlist;

	}

}
