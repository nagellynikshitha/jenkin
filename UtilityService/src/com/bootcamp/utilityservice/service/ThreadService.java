package com.bootcamp.utilityservice.service;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.bootcamp.utilityservice.dao.UtilityDao;
import com.bootcamp.utilityservice.domain.Customer;

/**
 * @author Nikshitha Nagelly 
 * This class is a thread class to insert data
 */
public class ThreadService implements Runnable {
	Customer cust;

	public ThreadService() {

	}

	public ThreadService(Customer cust) {
		this.cust = cust;
	}

	@Override
	public void run() {
		UtilityDao.insertData(cust);
	}
}
