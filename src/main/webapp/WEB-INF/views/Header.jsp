<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Book Mart</title>
		<meta name=viewport content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapi.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Book Mart</a>
					</div>
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/home" />">HOME</a></li>
						
						<c:if test = "${!sessionScope.loggedIn }">
						
							<li><a href="<c:url value="/login" />">LOGIN</a></li>
							<li><a href="<c:url value="/register" />">REGISTER</a></li>
							
						</c:if>
						
						<li><a href="<c:url value="/contactUs" />">Contact US</a></li>
						<li><a href="<c:url value="/about" />">About US</a></li>
						<li><a href="<c:url value="/Cart" />">Cart</a></li>
						
						<c:if test = "${sessionScope.isAdmin }" >
						
							<li><a href="<c:url value="/product" />">Manage Product</a></li>
							<li><a href="<c:url value="/category" />">Manage Category</a></li>
							
						</c:if>
						
						<c:if test = "${sessionScope.loggedIn }">
							
							<li><a href="<c:url value="/logout" />">Log-out</a></li>
							
						</c:if>
					</ul>
				</div>
			</nav>
		</div>
	</body>
</html>