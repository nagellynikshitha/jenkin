<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "com.bootcamp.customerregistration.model.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>id for deatils submitted by you</h2>
<table>
<tr>
<td>Customer id:</td>
<td>${cust.getId()}
</tr>
<tr>
<td>Customer FirstName:</td>
<td>${cust.getFirstName()}
</tr>
<tr>
<td>Customer LastName:</td>
<td>${cust.getLastName()}
</tr>
<tr>
<td>CustomerEmail:</td>
<td>${cust.getEmail()}
</tr>
<tr>
<td>Service id:</td>
<td>${cust.getServplan().getSid()}
</tr>
<tr>
<td>Service plan:</td>
<td>${cust.getServplan().getServicePlan()}
</tr>
</table>
</body>
</html>