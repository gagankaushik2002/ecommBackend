<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
					<li class="active"><a href="home">hHome</a></li>
					<c:if test="${!sessionScope.loggedIn}">
						<li><a href="${pageContext.request.contextPath}/login">hLogin</a></li>
						<li><a href="${pageContext.request.contextPath}/register">hRegister</a></li>
						<li><a href="${pageContext.request.contextPath}/contactus">hContact Us</a></li>
						<li><a href="a${pageContext.request.contextPath}/boutus">hAbout Us</a></li>
						
					</c:if>
					<c:if test="${sessionScope.loggedIn}">
						<c:if test="${sessionScope.role='ROLE_ADMIN'}">
							<li><a href="category">hCategory</a></li>
							<li><a href="product">Manage Product</a></li>
						</c:if>
						<c:if test="${sessionScope.role='ROLE_USER'}">
							<li><a href="productDisplay">Display Product</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
			<div class="nav navbar-nav navbar-right">
				<font color="white" face="calibri" size="3">Welcome : ${userName} </font>
				<a href="/logout"><font color="white" face="calibri" size="3">LOGOUT</font></a>
			</div>
		</nav>
		
  <!-- 
	</body>
</html>
 -->
