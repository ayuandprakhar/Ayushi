<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Vehicle List</h3>
<table border="2">
	<tr>
		<td>RC No</td><td>Model</td><td>Type</td><td>Transporter Name</td><td>Proof</td><td>Approve Vehicle</td><td>Reject Vehicle</td>
	</tr>
	
	<jstl:forEach  var="vehicle" items="${vehicle}">
		<tr>
			<td>${vehicle.v_no}</td>
			<td>${vehicle.v_model}</td>
			<td>${vehicle.v_type}</td>
			<td>${vehicle.transporter.t_firm_name}</td>
			<td>${vehicle.v_rc}</td>
			<%-- <td><img width="50" height="50" src="LoadVehicle?number=${vehicle.v_no}"/></td> --%>
			<td><a href="updatevehicle?number=${vehicle.v_no}">Update</a></td>
			<td><a href="deletevehicle?number=${vehicle.v_no}">Delete</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
</body>
</html>