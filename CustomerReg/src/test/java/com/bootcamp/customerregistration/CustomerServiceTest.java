package com.bootcamp.customerregistration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bootcamp.customerregistration.dao.CustomerDao;
import com.bootcamp.customerregistration.model.Customer;
import com.bootcamp.customerregistration.model.Service_Plan;
import com.bootcamp.customerregistration.service.CustomerserviceImpl;

public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerserviceImpl regService;


	@Mock
	private CustomerDao storeDao;
	
	private Customer customer;
	private Customer invalidCust;
	private Service_Plan servicePlan;

	@Before
	public void setUp() throws Exception {

		customer = new Customer();
		servicePlan = new Service_Plan();
		customer.setId(1);
		customer.setFirstName("Nikshitha");
		customer.setLastName("nagelly");
		customer.setEmail("nagellynikshitha@gmail.com");
		servicePlan.setSid(1);
		servicePlan.setServicePlan("Plan1");
		customer.setServplan(servicePlan);
		MockitoAnnotations.initMocks(this);
		
		invalidCust = new Customer();
		invalidCust.setId(2);
		invalidCust.setFirstName("Nagelly");
		invalidCust.setLastName("Nikshitha");
		invalidCust.setEmail("ikshitha@gmail.com");
		customer.setServplan(servicePlan);
		
		}

	/**
	 * Test passes if user provides valid input
	 */

	@Test
	public void testGetCustomerid() {

		when(storeDao.getCustomerid(customer)).thenReturn(customer.getId());
		assertEquals(1, regService.getCustomerid(customer));
		}

}



