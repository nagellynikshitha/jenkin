<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Utility Service</title>
<style>
table, tr, td {
	border: 1px solid black;
}
th {
 background-color: #000000;
    color: white;
}
tr {
    background-color: #4CAF67;
    color: white;
}
</style>
</head>
<body bgcolor="#DC143C"  style="text-align: center;">
<h1>Customer Utility Service</h1>
	
	<form action="UploadServlet" method="post"
		enctype="multipart/form-data">

		Select File:<input type="file" name="fname" /><br /> <input
			type="submit" value="process" />
	</form>
	
	<hr>
	<table border="1">
		<% if (request.getAttribute("list") != null) {
%>
<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Service ID</th>
				<th>Service StartDate</th>
				<th>Service EndDate</th>
			</tr>
		<c:forEach items="${list}" var="Customer">
			
			<tr>
				<td>${Customer.firstName}</td>
				<td>${Customer.lastName}</td>
				<td>${Customer.email}</td>
				<td>${Customer.phone}</td>
				<td>${Customer.service.serviceId}</td>
				<td>${Customer.service.serviceStartDate}</td>
				<td>${Customer.service.serviceEndDate}</td>
			</tr>
		</c:forEach>
		<%
}
%>
	</table>
		
</body>
</html>
