<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Transporter List</h3>
<table border="2">
	<tr>
		<td>Firm Name</td><td>Email ID</td><td>Mobile</td><td>PAN Number</td><td>GST Number</td><td>Proof<td>
	</tr>
	
	<jstl:forEach  var="transporter" items="${transporters}">
		<tr>
		<td>${transporter.t_firm_name}</td>
		  <%--  <td>${transporter.t_id}</td> --%>
			
			<td>${transporter.t_email_id}</td>
			<td>${transporter.t_mobile}</td>
			<td>${transporter.t_pan_no}</td>
			<td>${transporter.t_gst_no}</td>
			<td><img width="50" height="50" src="showimage?number=${transporter.t_email_id}"/></td>
			<td><a href="approvetransporter?number=${transporter.t_email_id}">Approve</a></td>
			<td><a href="rejecttransporter?number=${transporter.t_email_id}">Reject</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
</body>
</html>
