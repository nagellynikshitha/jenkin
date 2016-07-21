package com.bootcamp.utilityservice.domain;
public class Customer {




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





	private String firstName;
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}





	private String lastName;
	private String email;
	private String phone;
	
	

	ServiceData service;
	
	
	


	}
