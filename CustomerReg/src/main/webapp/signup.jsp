<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
$(document).ready(function() {
	

		$.ajax({
			type : "GET",
			url : "servcontrol/services",	//request mapping url
			success : function(msg) {
				var response = jQuery.parseJSON(msg);
			
				$('#service').find('option').remove();	//give drop down id
				$.each(response, function(key, value) {
					$("#service").append(
							"<option value='" + key + "'>"
									+ value + "</option>");
				});
			},
			error : function() {
				alert("Failed to load serviceplans");
			}
	
	});

});
</script>
</head>
<body>

<form action="custcontrol" method="post">
  First name: <input type="text" name="firstName"><br>
  Last name: <input type="text" name="lastName"><br>
  E-mail:<input type="text" name="email" value="your email"><br>
  
    <select id="service" name="servplan.sid">
                <option>Select Service</option>
        </select>
  
  
  <input type="submit" value="Submit">
</form>
</body>
</html>