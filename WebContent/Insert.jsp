<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
			String currentUser = (String) session.getAttribute("CurrentUser");
			if (currentUser != null) {
		%>
		<form action="InsertServlet">
			<input type="submit" name="Logout" value="Logout">
		</form>
		<%
			} else {
		%>Please Login First<%
			response.sendRedirect("LoginPage.jsp");
			}
		%>
	</div>
</body>
</html>