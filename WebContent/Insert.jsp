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
     <div class="container">
		<div class="card card-login mx-auto mt-5">
		<div class="card-header">Insert new user</div>
		<div class="card-body">
		<form action="InsertServlet">
			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">User's name</span>
  			</div>
  			<input type="text"
				pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" required
				name="name" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
			</div>
			
			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">User's Email</span>
  			</div>
  			<input type="email"
				pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
				required name="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
			</div>
			
			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">User's Address</span>
  			</div>
  			<input type="text" required name="address" name="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
			</div>
			
			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">User's Phone</span>
  			</div>
  			<input type="tel" pattern="^//d{9}*$" required
				name="phone" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
			</div>
				
			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">Date of Birth</span>
  			</div>
  			<input type="date" required name="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
			</div>
			
			<div align="right">
			<a class="btn btn-outline-primary"href="ShowAllServlet">Cancel</a>
			<input type="submit" class="btn btn-outline-success" name="Insert" value="Insert" >
			</div>
		</form>
		<%
			}
		%>
		<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
		 </div>
	</div>
	</div>
	</div>
</body>
</html>