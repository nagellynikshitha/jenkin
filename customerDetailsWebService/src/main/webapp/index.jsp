<html>


<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
	$(document).ready(function() {

		$.ajax({
			type : "GET",
			url : "listenercontrol/listener", //request mapping url
			success : function(msg) {

				//var response = jQuery.parseJSON(msg);

				//$('#listener').find('option').remove();	//give drop down id

				//$.each(response, function(key, value) {
					$("#listener").html(msg);
				//});
			},
			error : function() {
				alert("Failed to load listener");
			}

		});

	});
</script>
</head>
<body>
	<h2>Web Service</h2>

	<h4 id="listener"></h4>
</body>
</html>
