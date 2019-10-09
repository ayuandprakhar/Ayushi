<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h3>Update-Vehicle-Form/h3>
	<hr>
	<form:form action="updatevehicle" modelAttribute="Vehicles" enctype="multipart/form-data">
		<pre>
		Vehicle-Model <form:input path="v_model" />	
		Vehicle-Type	<form:input path="v_type" />
		Registration-Certificate  <input type="file" name="v_rc" />
			
			<input type="submit" value="Save" />
		</pre>

	</form:form>
	<hr>

</body>
</html>
