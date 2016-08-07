package com.bootcamp.customerregistration.controller;

import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.customerregistration.service.SoapClient;
import com.customerservice.customerdetails.service.ServicePlan;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/servcontrol")
public class ServicePlanController {

	@Autowired
	private SoapClient serplan;

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	@ResponseBody
	public String getServicePlans() {

		
		List<ServicePlan> services = serplan.getServices();//webservice call

		Map<String, String> servicemap = new HashMap<String, String>();
		
		
		for (Iterator iterator = services.iterator(); iterator.hasNext();) {

			ServicePlan service = (ServicePlan) iterator.next();
			String sid = "" + service.getSid();
			servicemap.put(sid, service.getServicePlan());//web service call

		}

		System.out.println("serv size" + services.size());
		
		String json = new Gson().toJson(servicemap);

		return json;

	}

}
