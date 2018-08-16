<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="container">
		<table class="table" border="1">
			<tr>
				<td rowspan="9">
					<img src='<c:url value="/resources/images/${product.productId}.jpg"/>' alt="image not supported">
				</td>
			</tr>
			<tr>
				<td>Product Id</td>
				<td>${product.productId}</td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td>${product.productName}</td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td>${product.productDesc}</td>
			</tr>
			<tr>
				<td>Supplier Id</td>
				<td>${product.supplierId}</td>
			</tr>
			<tr>
				<td>Stock</td>
				<td>${product.stock}</td>
			</tr>
			<tr>
				<td>Category</td>
				<td>${categoryName}</td>
			</tr>
			<form action="<c:url value="/addToCart/${product.productId}"/> method="get">
				<tr>
					<td>Quantity</td>
					<td>
						<select name="quantity" class="form.control btn-block">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="AddToCart" class="btn btn-info btn-block">
					</td>
				</tr>
			</form>
		</table>
	
	</div>