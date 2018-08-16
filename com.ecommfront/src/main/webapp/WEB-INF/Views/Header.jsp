<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<html>
	<head>
		<meta name-"viewport" content="width-device-width",initial-scale=1>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
		<style type="text/css">
			#myContainer
			{
				background-color:orange;
			}
		</style>
	</head>
	<body>
		
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">MyBazar</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="home">Home</a></li>
					<c:if test="${!sessionScope.loggedIn}">
						<li><a href="${pageContext.request.contextPath}/loginpage">Login</a></li>
						<li><a href="${pageContext.request.contextPath}/register">Register</a></li>
						<li><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
						<li><a href="${pageContext.request.contextPath}/aboutus">About Us</a></li>
					</c:if>
					<c:if test="${sessionScope.loggedIn}">
						<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
							<li><a href="${pageContext.request.contextPath}/category">hCategory</a></li>
							<li><a href="${pageContext.request.contextPath}/product">Manage Product</a></li>
						</c:if>
						<c:if test="${sessionScope.role=='Role_User'}">
							<li><a href="${pageContext.request.contextPath}/productDisplay">Display Product</a></li>
							<li><a href="${pageContext.request.contextPath}/cartDisplay">Goto Cart</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
			<div class="nav navbar-nav navbar-right">
				<font color="white" face="calibri" size="3" style="padding-right: 30px;">Welcome : ${username} </font>
				<c:if test="${sessionScope.loggedIn}">
					<a style="padding-right: 30px;" href="${pageContext.request.contextPath}/logout"><font color="white" face="calibri" size="3">LOGOUT</font></a>
				</c:if>
			</div>
		</nav>
		
  <!-- 
	</body>
</html>
 -->
