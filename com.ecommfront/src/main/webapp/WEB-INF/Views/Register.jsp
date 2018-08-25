<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
-->
<script>
 		function contact()
 		{
 			alert("still working on....");
 			document.getElementById('userDetail').submit();
 		}
 	</script>

	<style>
		* {box-sizing: border-box}
			
			/* Add padding to containers */
			.container {
			  padding: 16px;
			}
			
			/* Full-width input fields */
			input[type=text], input[type=password] {
			  width: 100%;
			  padding: 15px;
			  margin: 5px 0 22px 0;
			  display: inline-block;
			  border: none;
			  background: #f1f1f1;
			}
			
			input[type=text]:focus, input[type=password]:focus {
			  background-color: #ddd;
			  outline: none;
			}
			
			/* Overwrite default styles of hr */
			hr {
			  border: 1px solid #f1f1f1;
			  margin-bottom: 25px;
			}
			
			/* Set a style for the submit/register button */
			.registerbtn {
			  background-color: #4CAF50;
			  color: white;
			  padding: 16px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			  opacity: 0.9;
			}
			
			.registerbtn:hover {
			  opacity:1;
			}
			
			/* Add a blue text color to links */
			a {
			  color: dodgerblue;
			}
			
			/* Set a grey background color and center the text of the "sign in" section */
			.signin {
			  background-color: #f1f1f1;
			  text-align: center;
			}
	</style>
	
	
	<form:form action="${pageContext.request.contextPath}/RegisterUser" modelAttribute="userDetail" method="post" enctype="multipart/form-data">
	  <div class="container">
	    <c:if test="${userAlreadyExists==1}">
			<h1 class="alert alert-danger" >UserName already exists</h1>
		</c:if>
	    
	    <h1>Register</h1>
	    <p>Please fill in this form to create an account.</p>
	    <hr>
		
		<form:hidden path="role" value="ROLE_USER"/>
		<form:hidden path="enabled" value="1"/>
		<label for="customerName"><b>Name</b></label>
	    <form:input path="customerName" required="required"/>
	    
	    <label for="userName"><b>UserName</b></label>
	    <form:input path="userName" required="required"/>
	    <!--  <input type="text" placeholder="Enter userName for login" name="userName" required> -->
	    
	    <label for="email"><b>Email</b></label>
	    <!--  input type="text" placeholder="Enter Email" name="email" required> -->
	    <form:input path="email" required="required"/>
	
	    <label for="password"><b>Password</b></label>
	    <!-- <input type="password" placeholder="Enter Password" name="password" required> -->
	    <form:password path="password" required="required"/>
	
	    <!-- 
	    <label for="psw-repeat"><b>Repeat Password</b></label>
	    <input type="password" placeholder="Repeat Password" name="password-repeat" required>
	    <hr>
	     
	
	    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
	    -->
	    
	    <button type="submit" class="registerbtn">Register</button>
	  </div>
	
	  <div class="container signin">
	    <p>Already have an account? <a href="${pageContext.request.contextPath}/loginpage">Sign in</a>.</p>
	  </div>
	</form:form>
	</body>
</html>