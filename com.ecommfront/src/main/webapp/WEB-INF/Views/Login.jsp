<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Header.jsp"%>

<!--
<html>
	<head>
	
	<title>Insert title here</title>
	</head>
	<body>
-->
		<style>
			form {border: 3px solid #f1f1f1;}
			
			input[type=text], input[type=password] {
			    width: 100%;
			    padding: 12px 20px;
			    margin: 8px 0;
			    display: inline-block;
			    border: 1px solid #ccc;
			    box-sizing: border-box;
			}
			
			button {
			    background-color: #4CAF50;
			    color: white;
			    padding: 14px 20px;
			    margin: 8px 0;
			    border: none;
			    cursor: pointer;
			    width: 100%;
			}
			
			button:hover {
			    opacity: 0.8;
			}
			
			.cancelbtn {
			    width: auto;
			    padding: 10px 18px;
			    background-color: #f44336;
			}
			
			.imgcontainer {
			    text-align: center;
			    margin: 24px 0 12px 0;
			}
			
			img.avatar {
			    width: 40%;
			    border-radius: 50%;
			}
			
			.container {
			    padding: 16px;
			}
			
			span.psw {
			    float: right;
			    padding-top: 16px;
			}
			
			/* Change styles for span and cancel button on extra small screens */
			@media screen and (max-width: 300px) {
			    span.psw {
			       display: block;
			       float: none;
			    }
			    .cancelbtn {
			       width: 100%;
			    }
			}
			</style>
		<form action="login" method="post">
			  <!-- 
			  <div class="imgcontainer">
			    <img src="${pageContext.request.contextPath}/resources/images/Avatar.jpg" alt="Avatar" class="avatar"/>
			  </div>
			  -->
			
			  <div class="container">
			    <label for="username"><b>Username</b></label>
			    <input type="text" id="username" name="username" value="" placeholder="Enter Username" required>
			
			    <label for="password"><b>Password</b></label>
			    <input type="password" id="password" name="password" placeholder="Enter Password" required>
			        
			    <button type="submit">Login</button>
			    <!-- 
			    <label>
			      <input type="checkbox" checked="checked" name="remember"> Remember me
			    </label>
			    -->
			    
			    <c:if test="${not empty param.error}">
			    
			    	<h1 class="alert alert-danger" >Invalid Username/Password</h1>
			    
			    </c:if>
			    
			  </div>
				<!-- 
			  <div class="container" style="background-color:#f1f1f1">
			    <button type="button" class="cancelbtn">Cancel</button>
			    <span class="psw">Forgot <a href="#">password?</a></span>
			  </div>
			 	 -->
		</form>		
		
		
		
	</body>
</html>