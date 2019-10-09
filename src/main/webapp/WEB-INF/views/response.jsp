<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Query-Form</h3>
	<hr>
	<form:form action="queryy" modelAttribute="query">
		<pre>
		Query-ID<form:input path="q_id" /> 
		Your Query <form:input path="q_description" />
		           <form:hidden path="user.u_emailid" value="${email}"/>
		           <form:hidden path="transporter.t_email_id" value="${deals.transporter.t_email_id}"/>

			<input type="submit" value="Save" />
		</pre>

	</form:form>
	<hr>

</body>
</html>
