package com.customerservice.customerdetails.service;

import com.customerservice.customerdetails.dao.MessageDao;

public class MessageService {
	
	public void processMessage(int sid, int cid){
		
		MessageDao messagedao= new MessageDao();
		
		messagedao.saveSid(sid, cid);
	}

}
