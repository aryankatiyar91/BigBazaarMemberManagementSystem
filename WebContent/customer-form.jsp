<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

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
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath()%>/home">Customer</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</header>
<br>
<br>


<div class="container" style="width:50%">

	<c:if test="${customer==null}">
		<form action="add" method="post">
		<h2>Add Customer</h2>
	</c:if>
	
	<c:if test="${customer!=null}">
		<form action="update" method="post">
		<h2>Edit Customer</h2>
	</c:if>
	
	  <div class="mb-3" hidden><!-- or write as hidden="hidden" The key whose declared only in key so for value use same value name -->
	       <input type="text" class="form-control" value="<c:out value="${customer.id}"></c:out>" id="tbId" name="tbId">
	  </div>
	  
	  <div class="mb-3">
	     <label for="tbName" class="col-form-label">Name</label>
	       <input type="text" class="form-control" value="<c:out value="${customer.name}"></c:out>" id="tbName" name="tbName" placeholder="Enter your Name" required="required" >
	  </div>
	  
	  <div class="mb-3">
	    <label for="tbEmail" class="col-form-label">Email</label>
	      <input type="email" class="form-control" value="<c:out value="${customer.email}"></c:out>" id="tbEmail" name="tbEmail" placeholder="Enter your Email" required="required">
	  </div>
	  
	  <div class="mb-3">
	    <label for="tbMobile" class="col-form-label">Mobile</label>
	    <input type="tel" class="form-control" value="<c:out value="${customer.mobile}"></c:out>" id="tbMobile" name="tbMobile" placeholder="Enter your Mobile No" required="required">
	  </div>
	  
	  <div>
	  	<button type="submit" class="btn btn-success">Save</button>
	  </div>
	  	
	</form>
	<!-- pattern="regex" is used to validate data without using javascript -->
</div>
</body>
</html>