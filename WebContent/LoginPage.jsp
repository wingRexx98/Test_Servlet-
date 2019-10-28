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
	<jsp:include page="/WEB-INF/view/_header.jsp"></jsp:include>
     <jsp:include page="/WEB-INF/view/_menu.jsp"></jsp:include>
     <div class="container">
		<div class="card card-login mx-auto mt-5">
		<div class="card-header">Login</div>
		<div class="card-body">
		<form action="LoginServlet" class="form-group">
			<p style="color: red;">${errorString}</p>
			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">Username</span>
  			</div>
  			<input  type="text" name="userName" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
  			</div>
  			<div class="input-group input-group-sm mb-3">
  			<div class="input-group-prepend">
    			<span class="input-group-text" id="inputGroup-sizing-sm">Password</span>
  			</div>
  			<input type="password" name="password" name="userName" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
  			</div>
  			<div align="right">
			<input class="btn btn-outline-primary" type="submit" name="submitBtn" value="Login">
			</div>
		</form>
		</div>
		<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
		</div>
	</div>
	
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>