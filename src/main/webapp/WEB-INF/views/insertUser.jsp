<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h3>User-Entry-Form</h3>
	<hr>
	<form:form action="insertuser1" modelAttribute="Users" enctype="multipart/form-data">
		<pre> 
		User-ID <form:input path="u_id" />	 <form:errors path="u_id" /> 
		User-Name <form:input path="u_name" />	 <form:errors path="u_name" /> 
		User Address	<form:input path="u_address" />   <form:errors  path="u_address" />
		User EmailID<form:input path="u_emailid" />   <form:errors path="u_emailid" />
		User Password <form:input path="u_password" />   <form:errors path="u_password" />
		User Number <form:input path="u_number" />   <form:errors path="u_number" />
		User City <form:input path="u_city" />   <form:errors path="u_city" />
		User State <form:input path="u_state" />   <form:errors path="u_state" />
			
			<input type="submit" value="Save" />
		</pre>

	</form:form>
	<hr>

</body>
</html>
