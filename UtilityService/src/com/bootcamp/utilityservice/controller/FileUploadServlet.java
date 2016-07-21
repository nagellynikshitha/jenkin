package com.bootcamp.utilityservice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.utilityservice.domain.Customer;
import com.bootcamp.utilityservice.service.Service;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class FileUploadServlet
 */
@SuppressWarnings("serial")
public class FileUploadServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String path = "C:/nik";
		@SuppressWarnings("unused")
		MultipartRequest m = new MultipartRequest(request, path);
		out.print("successfully uploaded");

		String filePath = path + "/Customer_Utility_Service_Details.txt";
		Service s = new Service();
		boolean status = s.insertCustomers(filePath);
		if(status == true){
			ArrayList<Customer> customerList = s.getCustomer();
			request.setAttribute("list", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("indexx.jsp");
			rd.include(request, response);
		}else{
			System.out.println("Data could not be inserted!");
		}
		
	}
}

