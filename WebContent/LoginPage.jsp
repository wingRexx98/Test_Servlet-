<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<!--the action in the form calls the LoginServlet file-->
	<div>
		<form action="LoginServlet">
			<h2>Login form</h2>
			Username<br> <input type="text" name="userName"><br>
			Password<br> <input type="password" name="password"><br>
			<input type="submit" name="submitBtn" value="Login">
		</form>
	</div>
</body>
</html>