<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Response</h3>
<table border="2">
	<tr>
		<td>Query No</td><td>Question</td><td>Response</td><td>Transporter</td>
	</tr>
	
	<jstl:forEach  var="query" items="${query}">
		<tr>
			<td>${query.q_id}</td>
			<td>${query.q_description}</td>
			<td>${query.q_response}</td>
			<td>${query.transporter.t_firm_name}</td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="user_home">Home</a>
</body>
</html>