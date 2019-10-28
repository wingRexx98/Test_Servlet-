<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="padding: 5px;">

	<a href="Home.jsp">Home</a> | 
	<a href="ShowAllServlet">Show all user</a> |
	<a href="Insert.jsp">Insert new User</a> |
	<%
		String currentUser = (String) session.getAttribute("CurrentUser");
		if (currentUser == null) {
	%><a href="LoginPage.jsp">Login</a>
	<%
		} else {
	%><a href="LogoutServlet">Logout</a>
	<%
		}
	%>


</div>
