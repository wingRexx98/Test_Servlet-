<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body>
	<div>
		<%
			String currentUser = (String) session.getAttribute("CurrentUser");
		%>
		Welcome <%=currentUser%><br> 
		<a href="Insert.jsp">Insert new User</a>
		| <a href="ShowAllServlet">Show all user</a>
		<form action="LogoutServlet">
			<input type="submit" name="Logout" value="Logout">
		</form>
	</div>
</body>
</html>