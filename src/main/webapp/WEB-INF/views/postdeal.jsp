 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"  %>
<html>
<body>
	<h3>Post- Deal</h3>
	<hr>
	<form:form action="adddeal" modelAttribute="Deals">
		<pre>
		Deal-ID <form:input path="d_no" />	
		Deal- Description <form:input path="d_description" />
		Source city <form:input path="d_from_city" />	
		Desitnation city <form:input path="d_to_city" />	  
		Price <form:input path="d_price" />	  
		Date <form:input path="date" />
		Vehicle <form:select path="vehicle.v_no" items="${v_nos}"/>
		        
		        <form:hidden path="transporter.t_email_id" value="${email}"/>
			
			<input type="submit" value="Save" />
		</pre>

	</form:form>
	<hr>

</body>
</html>
