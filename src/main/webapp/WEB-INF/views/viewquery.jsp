<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>View Query</h3>
<table border="2">
	<tr>
	<td>Query ID</td><td>User Name</td><td>Query</td>
	</tr>
	
	<jstl:forEach  var="query" items="${query}">
		<tr>
			<td>${query.q_id}</td>
			<td>${query.user.u_name}</td>
			<td>${query.q_description}</td>
			<td><a href="raiseresponse?number=${query.q_id}">Response</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
</body>
</html>
