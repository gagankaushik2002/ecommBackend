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
 			alert("we will contact you soon....");
 			document.getElementById('contactUs').submit();
 		}
 	</script>
	<style>
		input[type=text], select, textarea {
		    width: 100%; /* Full width */
		    padding: 12px; /* Some padding */  
		    border: 1px solid #ccc; /* Gray border */
		    border-radius: 4px; /* Rounded borders */
		    box-sizing: border-box; /* Make sure that padding and width stays in place */
		    margin-top: 6px; /* Add a top margin */
		    margin-bottom: 16px; /* Bottom margin */
		    resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
		}
		
		/* Style the submit button with a specific background color etc */
		input[type=submit] {
		    background-color: #4CAF50;
		    color: white;
		    padding: 12px 20px;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		}
		
		/* When moving the mouse over the submit button, add a darker green color */
		input[type=submit]:hover {
		    background-color: #45a049;
		}
		
		/* Add a background color and some padding around the form */
		.container {
		    border-radius: 5px;
		    background-color: #f2f2f2;
		    padding: 20px;
		}
	</style>
	
	
	<div class="container">
		  <form:form action="${pageContext.request.contextPath}/ContactInsert" modelAttribute="contactUs" method="post" enctype="multipart/form-data">
		
		    <label for="fname">First Name</label>
		    <input type="text" id="fname" name="firstname" placeholder="Your name..">
		
		    <label for="lname">Last Name</label>
		    <input type="text" id="lname" name="lastname" placeholder="Your last name..">
		    
		    <label for="email">Email</label>
		    <input type="text" id="email" name="email" placeholder="Your email Id..">
		
		    <label for="subject">Subject</label>
		    <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>
		
		    <input type="button" value="Submit" onclick="contact();">
		
		  </form:form>
		</div>



	</body>
</html>