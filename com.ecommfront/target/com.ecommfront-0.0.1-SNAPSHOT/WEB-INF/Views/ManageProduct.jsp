<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="${pageContext.request.contextPath}/ProductInsert" modelAttribute="product" method="post" enctype="multipart/form-data">
	<table align="center" cellspacing="3" class="table-striped">
		<tr bgcolor="pink">
			<td colspan="2"><center>Product Manage</center></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName"/></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc"/></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="pimage"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td><form:input path="stock"/></td>
		</tr>
		<tr>
			<td>Category</td>
			<td>
				<!-- <form:input path="categoryId"/> -->
				<form:select path="categoryId">
					<form:option value="0" label="-- Select List --"/>
					<!-- in below line we are using form:options in which we don't need to give
					     value and label seperately as compare with above used  form:option
					 -->
					<form:options items="${categoryList}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td>
				<!-- <form:input path="categoryId"/> -->
				<form:select path="supplierId">
					<form:option value="0" label="-- Select List --"/>
					<!-- in below line we are using form:options in which we don't need to give
					     value and label seperately as compare with above used  form:option
					 -->
					<form:options items="${supplierList}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><center><input type="submit" value="Save" class="btn btn-info"/></center></td>
		</tr>
	</table>
</form:form>

<table align="center" class="table">
	<tr bgcolor="pink">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		<td>Price</td>
		<td>Stock</td>
		<td>Category</td>
		<td>Supplier</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.productDesc}</td>
			<td>${product.price}</td>
			<td>${product.stock}</td>
			<td>${product.categoryId}</td>
			<td>${product.supplierId}</td>
			<td>
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
				<a href="<c:url value="/editProduct/${product.productId}"/>">Edit</a>
			</td>
		</tr>	
	</c:forEach>
	
</table>