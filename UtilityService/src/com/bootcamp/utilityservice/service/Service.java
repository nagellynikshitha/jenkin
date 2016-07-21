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
import com.bootcamp.utilityservice.dao.CustomerDao;

import com.bootcamp.utilityservice.domain.Customer;
import com.bootcamp.utilityservice.domain.ServiceData;

public class Service {
	CustomerDao fd = new CustomerDao();
	// static ArrayList<Customer> custlist= new ArrayList<Customer>();
	static Customer c;
	static Properties prop = new Properties();

	static public boolean insertCustomers(String serverpath) {
		boolean status = false;
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(serverpath);
			// Get the object of DataInputStream
			// DsataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;
			// Read File Line By Line

			try {
				InputStream input = new FileInputStream(
						"C:/BCJMAY16/Develop/Work Space/Corejava/UtilityService/util.properties");
				prop.load(input);
			} catch (IOException e) {

				e.printStackTrace();
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}

			int NoofThreads = Integer.parseInt(prop.getProperty("NoofThreads"));
			ExecutorService executor = Executors.newFixedThreadPool(NoofThreads);
			Runnable service = null;

			while ((strLine = br.readLine()) != null) {
				status = true;
				String[] information = strLine.split("\t");
				c = new Customer();
				c.setFirstName(information[0]);
				c.setLastName(information[1]);
				c.setEmail(information[2]);
				c.setPhone(information[3]);
				ServiceData s = new ServiceData();
				s.setServiceId(information[4]);
				s.setServiceStartDate(new Date(information[5]));
				s.setServiceEndDate(new Date(information[6]));
				c.setService(s);
				// custlist.add(c);

				service = new ThreadService(c);
				executor.execute(service);

			}
			executor.shutdown();
			// FormDao.insertData(c);
			// Close the input stream
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return status;
	}

	public  ArrayList<Customer> getCustomer() {
		//CustomerDao cudao = new CustomerDao();
		ArrayList<Customer> custlist = fd.getCustomers();
		return custlist;
	}

}
