package com.customerservice.customerdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "customer")
@XmlRootElement
public class Customer {			
		
		@Column(name = "cid")
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private int id;

		private String firstName;
		private String lastName;
		private String email;
		
		@OneToOne(fetch= FetchType.EAGER)
		@JoinColumn(name="sid")
		private ServicePlan servplan;
				
		
		public ServicePlan getServplan() {
			return servplan;
		}

		public void setServplan(ServicePlan servplan) {
			this.servplan = servplan;
		}

		/*private int sid;
		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}
*/
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		@Column(name = "firstName")
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		@Column(name = "lastName")
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@Column(name = "email")
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", servplan=" + servplan + "]";
		}

		

	}
