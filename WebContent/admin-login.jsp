<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script type="text/javascript">
function preback() {window.history.forward();} 
setTimeout("preback()",0); 
window.onunload=function(){null};
</script>
</head>
<body>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <div class="container-fluid">
	    <a class="navbar-brand">Customer Management</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">

	    </div>
	  </div>
	</nav>
</header>
<br>
<br>

<form action="list" method="post">
	<div class="container" style="width:50%">
		<h2>Admin Login</h2>
		<br>
		<div class="mb-3">
		  <label for="tbUser" class="form-label">Username:</label>
		  <input type="text" class="form-control" id="tbUser" placeholder="Enter username" name="tbUser" required="required">
		</div>
		<br>

		<div class="mb-3">
		  <label for="tbPass" class="form-label">Password</label>
		  <input type="password" class="form-control" id="tbPass" placeholder="Enter password" name="tbPass" required="required">
		</div>
		<br>
		
		<div>
		  <button type="submit" class="btn btn-success">Login</button>
		</div>
	</div>
</form>
</html>