<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h3>Transporter-Entry-Form</h3>
	<hr>
	<form:form action="inserttransporter" modelAttribute="Transporter" enctype="multipart/form-data">
		<pre>
		Transporter-ID <form:input path="t_id" />	 <form:errors path="t_id" />
		Transporter-Firm-Name <form:input path="t_firm_name" />	 <form:errors path="t_firm_name" /> 
		Transporter-EmailID <form:input path="t_email_id" />	 <form:errors path="t_email_id" /> 
		Transporter-Password <form:input path="t_password" />	 <form:errors path="t_password" /> 
		Transporter-Mobile <form:input path="t_mobile" />	 <form:errors path="t_mobile" /> 
		Transporter Pan-Number	<form:input path="t_pan_no" />   <form:errors  path="t_pan_no" />
		Transporter Gst-Number <form:input path="t_gst_no" />   <form:errors path="t_gst_no" />
		Image   <input type="file" name="image1" />
			
			<input type="submit" value="Save" />
		</pre>

	</form:form>
	<hr>

</body>
</html>
