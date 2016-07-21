package com.bootcamp.utilityservice.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.Part;

import com.bootcamp.utilityservice.dao.UtilityDao;
import com.bootcamp.utilityservice.domain.Customer;
import com.bootcamp.utilityservice.domain.ServiceData;

/**
 * @author Nikshitha Nagelly 
 * This class inserts data 
 * and retrieves data from database and different threads have assigned different tasks
 */
public class UtilityService {
	UtilityDao dao = new UtilityDao();
	static Customer cust;
	static Properties prop = new Properties();

	/*
	 * This method inserts data in to database
	 */
	static public boolean insertCustomers(Part filepart) {
		boolean status = false;
		try {

			//FileInputStream fstream = new FileInputStream(filepart);
			BufferedReader br = new BufferedReader(new InputStreamReader(filepart.getInputStream()));
			String strLine;
			try {

				InputStream input = new FileInputStream(
						"C:/Properties File/util.properties");
				prop.load(input);
			} catch (IOException e) {

				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}

			int NoofThreads = Integer.parseInt(prop.getProperty("NoofThreads"));
			ExecutorService executor = Executors.newFixedThreadPool(NoofThreads);
			Runnable service = null;
			br.readLine();
			while ((strLine = br.readLine()) != null) {
				
				status = true;
				String[] information = strLine.split("\t");
				cust = new Customer();
				cust.setFirstName(information[0]);
				cust.setLastName(information[1]);
				cust.setEmail(information[2]);
				cust.setPhone(information[3]);
				ServiceData servce = new ServiceData();
				servce.setServiceId(information[4]);
				servce.setServiceStartDate(new Date(information[5]));
				servce.setServiceEndDate(new Date(information[6]));
				cust.setService(servce);

				service = new ThreadService(cust);
				executor.execute(service);
			}
			
			executor.shutdown();
			while (!executor.isTerminated()) {}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return status;
	}

	/*
	 * This method gets all the customer details
	 */
	public ArrayList<Customer> getCustomer() {

		ArrayList<Customer> custlist = dao.getCustomers();
		return custlist;
	}

}
