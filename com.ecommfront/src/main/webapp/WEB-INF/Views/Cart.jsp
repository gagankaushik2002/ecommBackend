<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
		
		<table class="table table-striped table-hover table-condensed">
			<tr class="success"><td colspan="6"><center>Shopping Cart</center></td></tr>
			<tr>
				<th>SL #</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total Price</th>
				<th>Operation</th>
			</tr>
			<c:if test="${empty cartItems}">
				<tr><td colspan="6">Your Cart is Empty</td></tr>
				<tr bgcolor="Lightblue">
					<td colspan="6"><a href="<c:url value="/continueShopping"/>">Continue Shopping</a>
				</tr>
			</c:if>
			
			<c:if test="${not empty cartItems}">
				<c:set var="cartCount" value="0" scope="page" />
				<c:forEach items="${cartItems}" var="cartItem">
					<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
						<tr>
							<td><c:out value="${cartCount + 1}" /></td>
							<td>${cartItem.productName}</td>
							<td>
								<input id="quantity" name="quantity" type="text" value="${cartItem.quantity}"/>
							</td>
							<td>${cartItem.price}</td>
							<td>${cartItem.quantity*cartItem.price} </td>
							<td>
								<input class="btn btn-primary" type="submit" value="Update"/>
								<a class="btn btn-info" href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>">Delete</a>
							</td>
						</tr>
					</form>
					<!-- <c:set var="cartCount" value="${cartCount + 1}" scope="page"/> -->
				</c:forEach>
				<tr class="success">
					<td class="danger" colspan="4">Total Purchase Amount</td>
					<td class="danger">${totalPurchaseAmount}</td>
					<td>
						<a class="btn btn-success" href="<c:url value="/continueShopping"/>">Continue Shopping</a>
						<a class="btn btn-success" href="<c:url value="/checkOut"/>">Checkout</a>
					</td>
				</tr>
			</c:if>
			
		</table>



	</body>
</html>