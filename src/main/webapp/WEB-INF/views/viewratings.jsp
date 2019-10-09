<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>View Query</h3>
<table border="2">
	<tr>
	<td>Rating ID</td><t>Rating value</td><td>Transporter Name</td>
	</tr>
	
	<jstl:forEach  var="rating" items="${rating}">
		<tr>
			<td>${rating.r_id}</td>
			<td>${rating.r_value}</td>
			<td>${rating.transporter.t_firm_name}</td>
			<td><a href="deletetransporter?number=${rating.transporter.t_email_id}">Delete</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
</body>
</html>
