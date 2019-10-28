<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/_header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/view/_menu.jsp"></jsp:include>
	<div align="center">
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
		<h2>All users</h2>
		<table border="1">
			<tr>
				<th>User Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Date of Birth</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			<!-- UserList is the request atribute given in the show all servlet -->
			<c:forEach items="${ShowAllServlet}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td>${user.userPhone}</td>
					<td>${user.userAddress}</td>
					<td>${user.userDoB}</td>
					<td><a href="deleteServlet?userId=${user.userId}">Delete</a></td>
					<td><a href="updateServlet?userId=${user.userId}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
		<%
			}
		%>
	</div>
	<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>