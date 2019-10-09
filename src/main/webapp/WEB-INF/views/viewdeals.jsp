<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<body>
	<h3>Deals List</h3>
	<table border="2">
		<tr>
			<td>Deal Number</td>
			<td>Description</td>
			<td>Source City</td>
			<td>Destination City</td>
			<td>Price</td>
			<td>Date</td>
			<td>Ratings</td>
		</tr>
		<jstl:forEach var="deals" items="${deals}">
			<tr>
				<td>${deals.d_no}</td>
				<td>${deals.d_description}</td>
				<td>${deals.d_from_city}</td>
				<td>${deals.d_to_city}</td>
				<td>${deals.d_price}</td>
				<td>${deals.date}</td>
				<td><a href="raisequery?number=${deals.d_no}">Raise Query</a></td>
				<td>
					<form action="rateTransporter">
						<input hidden="transporterid" name="transporterid"
							value=${ deals.transporter.t_email_id}> <input
							onChange="this.form.submit();" type="radio" name="ratingValue"
							value="1"> <input onChange="this.form.submit();"
							type="radio" name="ratingValue" value="2"> <input
							onChange="this.form.submit();" type="radio" name="ratingValue"
							value="3"> <input onChange="this.form.submit();"
							type="radio" name="ratingValue" value="4"> <input
							onChange="this.form.submit();" type="radio" name="ratingValue"
							value="5">
					</form>

				</td>
			</tr>
		</jstl:forEach>
	</table>
	<hr>
</body>
</html>