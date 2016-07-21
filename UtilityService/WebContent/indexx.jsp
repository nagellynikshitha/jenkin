<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<body>
<form action="UploadServlet" method="post" enctype="multipart/form-data">  
   
Select File:<input type="file" name="fname"/><br/>  
<input type="submit" value="process"/>  
</form> 
<hr>
<table>
<% if (request.getAttribute("list") != null) {
%>
<c:forEach items = "${list}" var = "Customer">


    <tr>
        <td>
           ${Customer.firstName}
        </td>
        <td>
           ${Customer.lastName}
        </td>
        <td>
            ${Customer.email}
        </td>
        <td>
             ${Customer.phone}
        </td>
         <td>
         
             ${Customer.service.serviceId}
        </td>
      
          <td>
         
             ${Customer.service.serviceStartDate}
        </td>
          <td>
         
             ${Customer.service.serviceEndDate}
        </td>
        
        
        
    </tr>


</c:forEach>
<%
}
%>
</table>
</body>
</html> 