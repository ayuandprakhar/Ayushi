<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h3>Transporter-Profile-Update-Form</h3>
	<hr>
	<form:form action="new" modelAttribute="transporters" enctype="multipart/form-data">
		<pre>
		Transporter-Firm-Name <form:input path="t_firm_name" /> 
		Transporter-EmailID <form:input path="t_email_id" />
		Transporter-Password <form:input path="t_password" />
		Transporter-Mobile <form:input path="t_mobile" />
		Transporter Pan-Number	<form:input path="t_pan_no" />   
		Transporter Gst-Number <form:input path="t_gst_no" /> 
		Image   <input type="file" name="image1" />
			
			<input type="submit" value="Save" />
		</pre>

	</form:form>
	<hr>

</body>
</html>
