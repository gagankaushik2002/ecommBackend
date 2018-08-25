<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<style>
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }
   </style>
<form:form action="${pageContext.request.contextPath}/ProductInsert" modelAttribute="product" method="post" enctype="multipart/form-data">
	<form:errors path = "*" cssClass = "errorblock" element = "div" />
	<table align="center" cellspacing="3" class="table">
		<tr bgcolor="pink">
			<td colspan="3"><center>Product Manage</center></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName"/></td>
			<td><form:errors path = "productName" cssClass = "error" /></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc"/></td>
			<td><form:errors path = "productDesc" cssClass = "error" /></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td colspan="2"><form:input type="file" path="pimage"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td colspan="2"><form:input path="price"/></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td colspan="2"><form:input path="stock"/></td>
		</tr>
		<tr>
			<td>Category</td>
			<td colspan="2">
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
			<td >Supplier</td>
			<td colspan="2">
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