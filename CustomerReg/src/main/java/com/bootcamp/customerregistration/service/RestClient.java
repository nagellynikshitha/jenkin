package com.bootcamp.customerregistration.service;

import com.bootcamp.customerregistration.model.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
public Customer getCustomerById(int id)
{
	try {
		
		Customer cust = null;

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/CustomerDetailsWebService/services/rest/cust/"+ id);

		ClientResponse response = webResource.accept("application/xml")
                   .get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		cust = response.getEntity(Customer.class);
		return cust;
		

	  } catch (Exception e) {
		e.printStackTrace();
	  }
	return null;
}
	
}
