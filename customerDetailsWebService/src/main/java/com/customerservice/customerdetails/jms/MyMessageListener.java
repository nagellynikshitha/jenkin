package com.customerservice.customerdetails.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.customerservice.customerdetails.service.MessageService;

public class MyMessageListener implements MessageListener{

	@Override
	public void onMessage(Message m) {
		System.out.println("Listner is listening");
		TextMessage message=(TextMessage)m;
		try{
			String scid= message.getText();
			String [] msgAry = scid.split(":");		
				
					int sid=Integer.parseInt(msgAry[0]);
					int cid=Integer.parseInt(msgAry[1]);
					System.out.println(sid + " "+ cid);
					MessageService messageservice = new MessageService();
					
					messageservice.processMessage(sid,cid);

		}catch (Exception e) {e.printStackTrace();	}
	}

}