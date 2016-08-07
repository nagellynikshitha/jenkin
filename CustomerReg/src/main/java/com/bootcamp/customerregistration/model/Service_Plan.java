package com.bootcamp.customerregistration.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "service_plan")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Service_Plan  {
	
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;	
	private String servicePlan;
	
	
	@OneToOne(mappedBy="servplan")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Customer customer;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Column(name = "serviceplan")
	public String getServicePlan() {
		return servicePlan;
	}
	public void setServicePlan(String servicePlan) {
		this.servicePlan = servicePlan;
	}
	
	@Override
	public String toString() {
		return "Service [sid=" + sid + ", servicePlan=" + servicePlan + "]";
	}
	

}
