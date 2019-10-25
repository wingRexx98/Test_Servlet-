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
			if (currentUser == null) {
		%>Please Login First<%
			response.sendRedirect("LoginPage.jsp");
			
		%>
		<form action="InsertServlet">
			<input type="submit" name="Logout" value="Logout">
		</form>
		<%
			} else {
				%>
		<form action="InsertServlet">
			User name<br> <input type="text" name="userName"><br>
			User Email<br> <input type="text" name="userEmail"><br>
			User Address<br> <input type="text" name="userAddress"><br>
			User Phone<br> <input type="text" name="userPhone"><br>
			Date of Birth<br> <input type="date-local" name="userDoB"><br>

			<input type="submit" name="Logout" value="Logout">
		</form>
	</div>
</body>
</html>