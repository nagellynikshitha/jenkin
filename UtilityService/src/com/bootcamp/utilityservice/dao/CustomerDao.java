package com.bootcamp.utilityservice.dao;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bootcamp.utilityservice.dbutil.DBConnection;
import com.bootcamp.utilityservice.domain.Customer;
import com.bootcamp.utilityservice.domain.ServiceData;
import com.bootcamp.utilityservice.service.Service;

/**
 * @author Nikshitha Nagelly 
 * This class performs jdbc connections and inserts
 * user entered data in to database  
 */
public class CustomerDao {


	/*public FormDao() {
		connection = DBConnection.getConn();
	}*/
	public static boolean insertData(Customer cust) {
		
		 Connection connection=null;
		 boolean status =false;
		  
		try {
			connection= DBConnection.getConnection();
			if (connection!=null){
				
			CallableStatement stmt=connection.prepareCall("{call cust_insert(?,?,?,?,?,?,?)}");
		
			stmt.setString(1,cust.getFirstName());
			stmt.setString(2,cust.getLastName());  
			stmt.setString(3,cust.getEmail()); 
			stmt.setString(4,cust.getPhone()); 
			stmt.setString(5,cust.getService().getServiceId()); 
			  
			int day = cust.getService().getServiceStartDate().getDate();
		int month = cust.getService().getServiceStartDate().getMonth();
	int year = cust.getService().getServiceStartDate().getYear();
		stmt.setDate(6,new Date(year,month,day)); 
		day = cust.getService().getServiceEndDate().getDate();
		month = cust.getService().getServiceEndDate().getMonth();
		year = cust.getService().getServiceEndDate().getYear();
			stmt.setDate(7,new Date(year,month,day)); 
			
			stmt.execute();
			status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return status;
	
	}
	
	
	
	public   ArrayList<Customer> getCustomers(){
		
		Connection connection;
		ArrayList<Customer> custlist = new ArrayList<>();

		try {
			connection= DBConnection.getConnection();
			if (connection!=null){
			
			CallableStatement stmt=connection.prepareCall("{call get_cust}");
				ResultSet  rs = stmt.executeQuery();
				while(rs.next()){
					Customer cust= new Customer();
				
					cust.setFirstName(rs.getString("FirstName"));
					cust.setLastName(rs.getString("LastName"));
					cust.setEmail(rs.getString("Email"));
					cust.setPhone(rs.getString("Phone"));
					ServiceData s = new ServiceData();
				s.setServiceId(rs.getString("serviceid"));
				s.setServiceStartDate(rs.getDate("ServiceStartDate"));
				s.setServiceEndDate(rs.getDate("ServiceEndDate"));
						cust.setService(s);
						custlist.add(cust);
				}
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return custlist;

			
			
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
