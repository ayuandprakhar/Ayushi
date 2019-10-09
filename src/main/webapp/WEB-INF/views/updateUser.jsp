<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h3>User-Entry-Form</h3>
	<hr>
	<form:form action="update" modelAttribute="user" enctype="multipart/form-data">
		<pre> 
		User Name <form:input path="u_name" />	
		User Address <form:input path="u_address" />   
		User EmailID <form:input path="u_emailid" /> 
		User Password <form:input path="u_password" />  
		User Number <form:input path="u_number" />  
		User City <form:input path="u_city" />   
		User State <form:input path="u_state" /> 
	    	<input type="submit" value="Update" />
		</pre>
	</form:form>
	<hr>
</body>
</html>
