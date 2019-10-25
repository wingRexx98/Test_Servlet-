<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<div>
		<%
			String currentUser = (String) session.getAttribute("CurrentUser");
			if (currentUser == null) {
		%>Please Login First<%
			response.sendRedirect("LoginPage.jsp");
			} else {
				String message = (String) request.getAttribute("alertMsg");
		%>
		
		<form method="POST" action="updateServlet">
			<h2>Update user information</h2>
			<table border="0">
				<tr>
					<td>User's Name</td>
					<td><input type="text" name="name" value=""
						pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" required /></td>
				</tr>
				<tr>
					<td>User Email</td>
					<td><input type="text" name="email" value=""
						pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required /></td>
				</tr>
				<tr>
					<td>User Phone</td>
					<td><input type="text" name="phone" value=""
						pattern="^//d{9}*$" required /></td>
				</tr>
				<tr>
					<td>User Address</td>
					<td><input type="text" name="address"
						value="" required /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="text" name="date" required value="" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /> <a
						href="${pageContext.request.contextPath}/productList">Cancel</a></td>
				</tr>
			</table>
		</form>
		<%
			}
		%>
	</div>
</body>
</html>