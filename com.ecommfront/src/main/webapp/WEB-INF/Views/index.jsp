
<%@include file="Header.jsp"%>
<!-- 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
-->
		<style>
			div.c-wrapper
			{
			    width: 40%; /* for example */
			    margin: auto;
			}
			
			.carousel-inner > .item > img, 
			.carousel-inner > .item > a > img
			{
				width: 100%; /* use this, or not */
				margin: auto;
			}
			.flash 
			{
			   animation-name: flash;
			    animation-duration: 0.2s;
			    animation-timing-function: linear;
			    animation-iteration-count: infinite;
			    animation-direction: alternate;
			    animation-play-state: running;
			}
			
			@keyframes flash 
			{
			    from {color: red;}
			    to {color: black;}
			}
		</style>
		<h1 class="flash">
                <span data-toggle="tooltip" title="Bootstrap version">Welcome to MyBazar..Available Products......</span>
        </h1>
		<div class="c-wrapper">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
				 <div class="carousel-inner">
					   <c:forEach items="${productList}" var="product" varStatus="stat">
					    	<c:if test="${stat.first}">
					    		<div class="item active">
						      		<h4>
					                        <span data-toggle="tooltip" title="${product.productName}">${product.productName}&nbsp;</br/> @ Price-&nbsp; ${product.price}</span>
					                </h4>
						      		<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/${product.productId}.jpg" alt="Los Angeles">
						    	</div>
					    	</c:if>
					    	<c:if test="${!stat.first}">
						    	<div class="item">
						      		<h4>
					                        <span data-toggle="tooltip" title="${product.productName}">${product.productName}&nbsp;</br/> Price-&nbsp; ${product.price}</span>
					                </h4>
						      		<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/${product.productId}.jpg" alt="Los Angeles">
						    	</div>
					    	</c:if>
					</c:forEach>
				  </div>
			</div>
		</div>
	
	</body>
</html>