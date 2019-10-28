
<!doctype html>
<html lang="en">
 <head></head>
  <body>
  	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="Home.jsp">My Test Servlet</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Actions
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Insert.jsp">Insert user</a>
          <a class="dropdown-item" href="ShowAllServlet">Show all user</a>
        </div>
      </li>
       <%	String currentUser = (String) session.getAttribute("CurrentUser");
			if (currentUser == null) {
		%>	
      <li class="nav-item">
       <a class="nav-link" href="LoginPage.jsp">Login</a>
       </li>
			<%} else {%>
		<li>
			<a class="nav-link" href="LogoutServlet">Logout</a>
      	</li>
			<%}%>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
	</div>
  </body>
</html>