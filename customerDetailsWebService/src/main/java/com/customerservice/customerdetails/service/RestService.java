package com.customerservice.customerdetails.service;


import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.customerservice.customerdetails.dao.ServiceDaoImpl;
import com.customerservice.customerdetails.model.Customer;


@Path("/cust")
@Service
@Transactional
public class RestService {

	
	@GET
	@Path("/{param}")
	//@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerById(@PathParam("param") int c_id) {
		System.out.println(c_id);
		ServiceDaoImpl dao= new ServiceDaoImpl();
		Customer customer = dao.getCustomerDAO(c_id);
		System.out.println("in service"+customer.getFirstName());
		/*return customer;*/
		return Response.status(200).entity(customer).build();
	}
	
	
}
