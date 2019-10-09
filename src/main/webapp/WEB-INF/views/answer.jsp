<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Query Response</h3>
	<hr>
		<form:form action="respondquery" modelAttribute="query">
		<pre>
			<form:hidden path="q_id"/>
			Question		<form:input path="q_description" readonly="readonly"/>
			Response		<form:input path="q_response"/>
			<form:hidden path="user.u_emailid"/>
			<form:hidden path="transporter.t_email_id"/>
				<input type="submit" value="Respond query"/>
			</pre>
		</form:form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>	