<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>

<h2 class="color1">Home-Dashboard</h2>
<hr>
	<pre>
		<form action="verify">
		Email Id 	<input type="text" name="email"/>	
		Password	<input type="password" name="password"/>
				<input type="submit" value="Login"/>
				<input type="radio" name="login" value="user"> User<br>
                <input type="radio" name="login" value="transporter"> Transporter<br>
                <input type="radio" name="login" value="admin"> Admin
		</form>
		
		<a href= "addTransporter">Add-Transporter</a>
		<a href= "insert">Add-User</a>
<hr>

<hr>
</body>
</html>