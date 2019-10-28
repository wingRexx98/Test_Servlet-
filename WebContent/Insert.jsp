<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert User</title>
</head>
<body>
	<div>
		<%
			String currentUser = (String) session.getAttribute("CurrentUser");
			if (currentUser == null) {
		%>Please Login First<%
			response.sendRedirect("LoginPage.jsp");
			} else {
		%>
		<% String message = (String)request.getAttribute("alertMsg");%>
	 <jsp:include page="/WEB-INF/view/_header.jsp"></jsp:include>
     <jsp:include page="/WEB-INF/view/_menu.jsp"></jsp:include>
		<form action="InsertServlet">
			<h2>Insert new user information</h2>
			User name<br> 
			<input type="text"
				pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" required
				name="name"><br>
				
			User Email<br>
			<input
				type="email"
				pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
				required name="email"><br>
				
			User Address<br> 
			<input type="text" required name="address"><br>
			
			User Phone<br>
			<input type="tel" pattern="^//d{9}*$" required
				name="phone"><br>
				
			Date of Birth<br>
			<input type="date" required name="date"><br>
			
			<input type="submit" name="Insert" value="Insert" >
		</form>
		<%
			}
		%>
		<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
	</div>
</body>
</html>