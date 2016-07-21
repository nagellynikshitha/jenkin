package com.bootcamp.utilityservice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bootcamp.utilityservice.domain.Customer;
import com.bootcamp.utilityservice.service.UtilityService;

/**
 * This class has Servlet implementation
 */
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Part filepart = request.getPart("fname");
		
		UtilityService service = new UtilityService();
		boolean status = UtilityService.insertCustomers(filepart);
		if (status == true) {
			
			ArrayList<Customer> customerList = service.getCustomer();
			request.setAttribute("list", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			
			out.println("Data cannot be inserted");
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
