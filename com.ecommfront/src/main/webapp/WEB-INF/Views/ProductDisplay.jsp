<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Header.jsp"%>

		
			<div class="row" style="margin: auto; width: 80%;">
					<c:forEach items="${productList}" var="product">
			        <div class="col-sm-4" style="display: inline-block; height: 350px;">
			            <div class="thumbnail">
			                <h3 class="text text-danger" style="text-transform: capitalize; white-space: nowrap; overflow: hidden;text-overflow: ellipsis;">
			                        <span data-toggle="tooltip">${product.productName}&nbsp;available</span>
			                </h3>
			                <h5>@ Price - ${product.price}</h5>
			                <img class="img-responsive" style="max-height: 180px;" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="imageeee not supported">
			                <a href="<c:url value='/totalProductInfo/${product.productId}'/>" class="btn btn-primary col-xs-12" role="button">Product Detail</a>
			                <div class="clearfix"></div>
			            </div>
			        </div>
					</c:forEach>
			</div>
		
	</body>
</html>
