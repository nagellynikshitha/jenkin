package com.bootcamp.utilityservice.domain;


/**
 * @author Nikshitha Nagelly
 * This class declares all data 
 * members used for customer
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	ServiceData service;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ServiceData getService() {
		return service;
	}

	public void setService(ServiceData service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}
