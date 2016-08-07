package com.bootcamp.customerregistration.jms;

import org.springframework.context.support.GenericXmlApplicationContext;


public class TestJmsSender {
public static void sendMessage(int sid, int cid) {
	GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
	ctx.load("com/bootcamp/customerregistration/jms/applicationcontext.xml");
	ctx.refresh();
	
	MyMessageSender sender=ctx.getBean("messageSender",MyMessageSender.class);
	sender.sendMessage(sid+":"+cid);
	
	//System.out.println("msg from sender");
	
}
}
