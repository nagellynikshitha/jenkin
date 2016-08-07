package com.customerservice.customerdetails.jms;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestListener {
	public static void loadListener() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("com//customerservice/customerdetails/jms/applicationContext.xml");
		ctx.refresh();
System.out.println("hi,loaded listener");
		while (true) {
		}
	}
}
