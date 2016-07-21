package com.bootcamp.utilityservice.domain;


import java.util.Date;

/**
 * @author Nikshitha Nagelly
 * This class declares all data 
 * members used for service related data for customer
 */
public class ServiceData {
	
	private String serviceId;
	private Date serviceStartDate;
	private Date serviceEndDate;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

}
